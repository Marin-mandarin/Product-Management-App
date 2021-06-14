package service;


import dao.InMemoryProductRepository;
import dao.ProductRepository;
import entity.product.Drink;
import entity.product.Food;
import entity.product.FoodCategory;
import entity.product.Product;
import exceptions.ProductUpdateUnknownPropertyException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;


    public ProductServiceImpl(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }


    @Override
    public void create(String name, double price, LocalDate date, double volume) {
        Drink aNewDrink = new Drink(name, price, date, volume);
        productRepository.save(aNewDrink);


    }

    @Override
    public void create(String name, double price, LocalDate date, FoodCategory foodCategory) {
        Food aNewFood = new Food(name, price, date, foodCategory);
        productRepository.save(aNewFood);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getAllNonExpired() {
        List<Product> nonExpiredProducts = new ArrayList<>();
        for (Product p : getAll()) {
            if (p.getBestBefore().isAfter(LocalDate.now()) || p.getBestBefore().equals(LocalDate.now())){
                nonExpiredProducts.add(p);

            }
        }
        return nonExpiredProducts;
    }

    public static void main(String[] args) {
        ProductServiceImpl p =new ProductServiceImpl(new InMemoryProductRepository());
        System.out.println(p.getAll());
        System.out.println(p.getAllExpired());
        System.out.println(p.getAllNonExpired());
    }
    @Override
    public List<Product> getAllExpired() {
        List<Product> ExpiredProducts = new ArrayList<>();
        for (Product p : getAll()) {
            if (p.getBestBefore().isBefore(LocalDate.now())){
                ExpiredProducts.add(p);
            }
        }

        return ExpiredProducts;
    }

    @Override
    public Product getById(int id) {
     return productRepository.findByID(id);
    }

    @Override
    public void update(int id, double volume) throws ProductUpdateUnknownPropertyException {
        productRepository.update(id , volume);

    }

    @Override
    public void update(int id, FoodCategory foodCategory) throws ProductUpdateUnknownPropertyException {
        productRepository.update(id, foodCategory);
    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);

    }
    public void print(List<Product> list){
        for (Product p: list) {
            System.out.println(p);

        }
    }


}
