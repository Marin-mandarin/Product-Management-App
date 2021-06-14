package app;

import dao.InMemoryProductRepository;
import entity.product.FoodCategory;
import entity.product.Product;
import service.ProductService;
import service.ProductServiceImpl;

import java.time.LocalDate;
import java.util.Scanner;

public class ProductManagementAdminMenu  {
    private final Scanner scan;
    ProductService productService;


    public ProductManagementAdminMenu(Scanner scan, ProductService productService) {
        this.productService = productService;
        this.scan = scan;

    }

    public void showMenu() {
        boolean exit;
        do{
            System.out.println("""
                =======ADMIN OPTIONS=======
                [1] View all Products
                [2] View all expired products
                [3] Add new product
                [4] Update food product
                [5] Update drink product
                [6] Remove product
                ======================
                [0] Exit\s
                =======================
                >>""");
        exit = handleAdminChoice(scan.nextInt());
        }while (exit);

    }

    private boolean handleAdminChoice(int userChoice) {
        scan.nextLine();
        switch (userChoice) {
            case 1:
                viewAllProducts();
                break;
            case 2:
                viewAllExpiredProducts();
                break;
            case 3:
                addNewProduct();
                break;
            case 4:
                updateFood();
                break;
            case 5:
                updateDrink();
                break;
            case 6:
                removeProduct();
                break;
            case 0:
                System.out.println("Dead in said");
                return false;
            default:
                System.out.println("Unknown option selected!");
                return true;
        }
   return true;}

    private void viewAllProducts() {
        for (Product p : productService.getAll()) {
            System.out.println(p);
        }

    }

    private void viewAllExpiredProducts() {
        for (Product p : productService.getAllExpired()) {
            System.out.println(p);
        }

    }

    private void addNewProduct() {
        System.out.println("Please give your choice FOOD/DRINK ");
        String choice = scan.nextLine().toUpperCase();
        if (choice.equals("FOOD")) {
            System.out.println("Please give the name:");
            String name = scan.nextLine();
            System.out.println("Please give price:");
            double price = scan.nextDouble();
            LocalDate bestBefore = LocalDate.now().plusDays(14);
            System.out.println("Please give the Food Category(ANIMAL_SOURCE, GRAIN, VEGETABLES, BAKERY): ");
            scan.nextLine();
            String category = scan.nextLine();
            FoodCategory foodCategory = FoodCategory.valueOf(category.toUpperCase());
            productService.create(name, price, bestBefore, foodCategory);
        }
        if (choice.equals("DRINK")) {
            System.out.println("Please give the name:");
            String name = scan.nextLine();
            System.out.println("Please give price:");
            double price = scan.nextDouble();
            LocalDate bestBefore = LocalDate.now().plusDays(14);
            System.out.println("Please give the volume of Drink:");
            double vol = scan.nextDouble();
            productService.create(name, price, bestBefore, vol);
        }


    }

    private void updateFood() {
        System.out.println("Please give the ID: ");
        int elected = scan.nextInt();
        System.out.println("Please give the new FooD Category(ANIMAL_SOURCE, GRAIN, VEGETABLES, BAKERY): ");
        scan.nextLine();
        String el = scan.nextLine();
        FoodCategory newFoodCategory = FoodCategory.valueOf(el.toUpperCase());
        productService.update(elected, newFoodCategory);

    }

    private void updateDrink() {
        System.out.println("Please give the ID: ");
        int elected = scan.nextInt();
        System.out.println("Please give the new Drink Volume: ");
        double newVlo = scan.nextDouble();

        productService.update(elected, newVlo);

        System.out.println(productService.getById(elected));
    }

    private void removeProduct() {
        System.out.println("Please give the ID:");
        int id = scan.nextInt();
        productService.delete(id);

    }




}
