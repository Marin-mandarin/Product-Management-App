package app;

import Main.ShoppingCart;
import dao.InMemoryProductRepository;
import service.ProductService;
import service.ProductServiceImpl;

import java.util.Scanner;

public class ProductManagementImpl implements ProductManagement {
    private final Scanner scan ;
    private ProductManagementAdminMenu adminMenu = new ProductManagementAdminMenu(new Scanner(System.in), new ProductServiceImpl(new InMemoryProductRepository()));
    private    ProductManagementUserMenu userMenu = new ProductManagementUserMenu(new ProductServiceImpl(new InMemoryProductRepository()), new ShoppingCart() , new Scanner(System.in));

    public ProductManagementImpl(Scanner scan, ShoppingCart cart, ProductService productService) {
        this.scan = scan;

    }


    @Override
    public void run() {
        System.out.println("==============================\n" +
                "Welcome to Product Management App\n" +
                "============================\n" +
                "Press 'Enter' to continue...." );
        String userString = scan.nextLine();
        if(userString.equalsIgnoreCase("admin")){
            adminMenu.showMenu();
        }else {
            userMenu.showMenu();
        }


    }
}
