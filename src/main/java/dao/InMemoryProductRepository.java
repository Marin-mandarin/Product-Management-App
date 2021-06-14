package dao;

import entity.product.Drink;
import entity.product.Food;
import entity.product.FoodCategory;
import entity.product.Product;
import exceptions.ProductExistsException;
import exceptions.ProductUpdateUnknownPropertyException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class InMemoryProductRepository implements ProductRepository {
    private static final ArrayList<Product> productList = new ArrayList<>();

    public InMemoryProductRepository() {
        Food sushi = new Food("SUSHI", 30.50, LocalDate.of(2021,6,15), FoodCategory.ANIMAL_SOURCE);
        sushi.setId(0);
        Food avocado = new Food("AVOCADO", 10.50, LocalDate.now().plusDays(15), FoodCategory.VEGETABLES);
        avocado.setId(1);
        Food bread = new Food("BREAD", 4.50, LocalDate.now(), FoodCategory.BAKERY);
        bread.setId(2);

        Drink tea = new Drink("TEA", 1.99, LocalDate.of(2021,6,13), 0.5);
        tea.setId(3);
        Drink juice = new Drink("JUICE", 5.99, LocalDate.now().plusMonths(1), 2.0);
        juice.setId(4);
        Drink coffee = new Drink("COFFEE", 1.99, LocalDate.of(2021,6,12), 0.5);
        coffee.setId(5);
        Drink beer = new Drink("BEER", 3.99, LocalDate.now().plusMonths(1), 1.0);
        beer.setId(6);

        productList.add(sushi);
        productList.add(avocado);
        productList.add(bread);
        productList.add(tea);
        productList.add(juice);
        productList.add(coffee);
        productList.add(beer);


    }


    private int getMaxID() {
        int id = 1;
        for (Product product : productList) {
            if (product.getId() > id) {
                id = product.getId();
            }
        }
        return id;
    }


    @Override
    public void save(Product product) {
        if (findByName(product.getName()) != null) {
            throw new ProductExistsException("Product with name " + product.getName() + " already exist!");
        }
        product.setId(getMaxID() + 1);
        productList.add(product);
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public Product findByID(int id) {
        Product product = null;
        for (Product pr : productList) {
            if (pr.getId() == id) {
                product = pr;
            }
        }
        if (product == null) {
            throw new ProductExistsException("Product with this id does not exist!");
        }

        return product;

    }

    @Override
    public Product findByName(String name) {
        Product product = null;
        for (Product pr : productList) {
            if (pr.getName().equals(name)) {
                product = pr;
            }
        }

        return product;
    }

    @Override
    public void update(int id, double anDouble) {
        Drink product = null;
        for (Product p : productList) {
            if (p.getId() == id) {
                if (p instanceof  Drink)
                    product = (Drink) p;
                    product.setVolume(anDouble);
                if (!(p instanceof Drink))
                    throw new ProductUpdateUnknownPropertyException("Be careful you make a mistake!!");
            }
        }
    }

    @Override
    public void update(int id, FoodCategory foodCategory) {
        Food product = null;
        for (Product p : productList) {
            if (p.getId() == id) {
                if (p instanceof  Food)
                    product = (Food) p;
                product.setCategory(foodCategory);
                if (!(p instanceof Food))
                    throw new ProductUpdateUnknownPropertyException("Be careful you make a mistake!!");
            }
        }
    }


    @Override
    public void delete(int id) {
        Product product = null;
        for (Product p : productList){
            if(p.getId() == id){
                product = p;
            }
        }
        if (product == null){
            throw new ProductExistsException("This ID does not exist!");
        }
        productList.remove(id);

    }

}
