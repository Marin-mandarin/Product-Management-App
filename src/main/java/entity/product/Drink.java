package entity.product;

import java.time.LocalDate;
import java.util.Objects;

public class Drink extends Product implements Printable, Billable {
    private double DISCOUNT;
    private double volume;


    public Drink(String name, double price, LocalDate date, double volume) {
        super(name, price, date);
        this.volume = volume;
        super.name = name;
        super.price = price;
        bestBefore = date;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (super.equals(o)) return false;
        if (!(o instanceof Drink)) return false;
        Drink drink = (Drink) o;
        return Double.compare(drink.volume, volume) == 0;
    }
     @Override
    public int hashCode(){return Objects.hash(super.hashCode(), volume);}
    @Override
    public String toString() {
        return "[" + id + "] " +  "DRINK: " + name + " | " + price + " | " + bestBefore +" | " + volume ;
    }

    public static void main(String[] args) {
        Drink d = new Drink("dsa", 10, LocalDate.of(2021,6,18),0.6);
        System.out.println(d.getPriceOnBill());
    }

    @Override
    public double getPriceOnBill() {
        double priceOnBill= 0.0;

        if(getBestBefore().equals(LocalDate.now()) || getBestBefore().equals( LocalDate.now().plusDays(1)) )
            priceOnBill = getPrice() *0.5;
        return priceOnBill;

    }

    @Override
    public String getPrintText() {
        return null;
    }
}