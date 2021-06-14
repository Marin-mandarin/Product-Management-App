package service;

import dao.ProductRepository;
import entity.product.FoodCategory;
import entity.product.Product;

import java.time.LocalDate;
import java.util.List;

public interface ProductService  {

    public void create (String name, double price, LocalDate date, double volume);
    public void create (String name, double price, LocalDate date, FoodCategory foodCategory);
    public List<Product> getAll();
    public List<Product> getAllNonExpired();
    public List<Product> getAllExpired();
    public Product getById(int id);
    public void update (int id, double volume);
    public void update (int id, FoodCategory foodCategory);
    public void delete (int id);

}
