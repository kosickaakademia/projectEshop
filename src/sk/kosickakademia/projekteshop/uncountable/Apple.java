package sk.kosickakademia.projekteshop.uncountable;

import sk.kosickakademia.projekteshop.Item;

public class Apple extends Item implements WeightItem {
    private double weight;

    public Apple(double price, String name, double weight) {
        super(price, name); // posleme kontruktoru Item
        this.weight=weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public double getItemPrice() {
        return weight*getPrice();
    }
}
