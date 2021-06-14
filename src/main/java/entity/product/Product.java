package entity.product;

import java.time.LocalDate;
import java.util.Objects;

public class Product {

    protected int id;
    protected String name;
    protected double price;
    protected LocalDate bestBefore;


    protected Product(String name, double price, LocalDate bestBefore) {
        this.name = name;
        this.price = price;
        this.bestBefore = bestBefore;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getBestBefore() {
        return bestBefore;
    }

    public void setBestBefore(LocalDate bestBefore) {
        this.bestBefore = bestBefore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return id == product.id
                && Double.compare(product.price, price) == 0
                && Objects.equals(name, product.name)
                && Objects.equals(bestBefore, product.bestBefore);

    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, bestBefore);
    }

    @Override
    public String toString() {
        return "[" + id + "] " + name + " | " + +price + " | " + bestBefore + " | ";
    }


}
