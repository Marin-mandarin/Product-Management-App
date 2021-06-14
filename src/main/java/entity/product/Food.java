package entity.product;

import java.time.LocalDate;
import java.util.Objects;

public class Food extends Product implements Printable, Billable  {
    private double DISCOUNT;
    private FoodCategory category;

    public Food(String name, double price, LocalDate date, FoodCategory category) {
        super(name, price, date);
        this.category = category;
        super.name = name;
        super.price = price;
        bestBefore = date;

    }




    public FoodCategory getCategory() {
        return category;
    }

    public void setCategory(FoodCategory category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (super.equals(o)) return false;
        if (!(o instanceof Food)) return false;
        Food food = (Food) o;
        return Objects.equals(food.category, category);
    }


    @Override
    public int hashCode() {
        return Objects.hash(DISCOUNT, category);
    }

    @Override
    public String toString() {
        return "[" + id + "] " + "FOOD: " + name + " | " + price + " | " + bestBefore + " | " + category;
    }


    @Override
    public double getPriceOnBill() {
        double priceOnBill= 0.1;

        if(getBestBefore().equals(LocalDate.now()) || getBestBefore().equals( LocalDate.now().plusDays(1)) || getBestBefore().equals( LocalDate.now().plusDays(2)) || getBestBefore().equals( LocalDate.now().plusDays(3)))
            priceOnBill = getPrice() *0.8;
        return priceOnBill;
    }

    @Override
    public String getPrintText() {
        return null;
    }
}
