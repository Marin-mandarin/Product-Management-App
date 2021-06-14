package Main;

import entity.product.Drink;
import entity.product.Food;
import entity.product.Product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
   private List<Product> productList = new ArrayList<>();


    public List<Product> getProductList() {
        return  this.productList;
    }

    public void addProduct(Product product) {
        this.productList.add(product);
    }

    public double getPrice() {
        double price = 0.0;
        for (Product p : productList) {
            if (p instanceof Food) {
                price += ((Food) p).getPriceOnBill();
            } if(p instanceof  Drink) {
                price += ((Drink) p).getPriceOnBill();
            }

        }

        return price;
    }

    public double getPriceWithOutDiscount() {
        double priceWithOutDiscount = 0.0;
        for (Product p : productList) {
            priceWithOutDiscount += p.getPrice();
        }
        return priceWithOutDiscount;
    }

    public double getSavedMoney() {
        return getPrice() - getPriceWithOutDiscount();
    }


}
