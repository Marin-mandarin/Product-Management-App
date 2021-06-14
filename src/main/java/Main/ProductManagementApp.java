package Main;

import app.ProductManagement;
import app.ProductManagementImpl;
import dao.InMemoryProductRepository;
import dao.ProductRepository;
import service.ProductService;
import service.ProductServiceImpl;

import java.util.Scanner;

public class ProductManagementApp {
    public static void main(String[] args) {
        ProductRepository productRepository = new InMemoryProductRepository();
        ProductService productService = new ProductServiceImpl(productRepository);
        ProductManagement productManagement = new ProductManagementImpl(new Scanner(System.in),new ShoppingCart()  , productService );
        productManagement.run();
    }
}
