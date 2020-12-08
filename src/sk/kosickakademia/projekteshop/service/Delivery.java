package sk.kosickakademia.projekteshop.service;

import sk.kosickakademia.projekteshop.Item;

public class Delivery extends Item implements ServiceInterface {
    public Delivery(double price) {
        super(price, "delivery");
    }

    @Override
    public double getItemPrice() {
        return getPrice();
    }

    @Override
    public String toString() {
        return "Delivery, Price: "+getPrice();
    }
}
