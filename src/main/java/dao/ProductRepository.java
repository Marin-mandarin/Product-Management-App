package dao;

import entity.product.FoodCategory;
import entity.product.Product;

import java.util.List;

public interface ProductRepository {
    public void save (Product product);
    public List<Product> findAll();
    public Product findByID(int id);
    public Product findByName(String name);
    public void update(int id, double anDouble);
    public void update(int id, FoodCategory foodCategory);
    public void delete(int id);

}
