package app;

import Main.ShoppingCart;
import dao.InMemoryProductRepository;
import entity.product.Product;
import exceptions.ProductNotFoundExceptions;
import service.ProductService;
import service.ProductServiceImpl;

import java.util.Scanner;

public class ProductManagementUserMenu  {
    private final ProductService productService;
    private final ShoppingCart cart;
    private final Scanner scan;

    public ProductManagementUserMenu(ProductService productService, ShoppingCart cart, Scanner scan) {
        this.productService = productService;
        this.cart = cart;
        this.scan = scan;
    }



    public void showMenu() {
        boolean exit;
        do {
            System.out.println("""
                ===========USER OPTIONS==========
                [1] View all products
                [2] View shopping cart
                [3] Add product to shopping cart
                [4] Print bill
                =========================
                [0] Exit
                =========================
                >>""");

            exit = handleUserChoice(scan.nextInt());
        } while (exit);
    }

        private boolean handleUserChoice(int userChoice){
        scan.nextLine();
        switch (userChoice) {
            case 1:
                viewAllNonExpiredProducts();
                break;
            case 2:
                viewShoppingCart();
                break;
            case 3:
                addProductToShoppingCart();
                break;
            case 4:
                printBill();
                break;
            case 0:
                System.out.println("Dead in said");
                return false;
            default:
                System.out.println("Unknown option selected!");
                return true;
        }

    return true;}

    private void viewAllNonExpiredProducts(){
        for (Product p : productService.getAllNonExpired()) {
            System.out.println(p);
        }
    }
    private void addProductToShoppingCart(){
        System.out.println("Please choice an ID of product!");
        int choice = scan.nextInt();
        Product p = productService.getById(choice);
        cart.addProduct(p);

    }
    private void viewShoppingCart() {
        if(cart.getProductList() != null){
            for (Product p : cart.getProductList())
                System.out.println(p);
        }
        else try {

        }catch (NullPointerException e ){
            System.out.println("the card is empty");
        }
    }
    private void printBill(){
        System.out.println("Total price: " + cart.getPrice());
        System.out.println("Total price with out discount: " + cart.getPriceWithOutDiscount());
    }


}
