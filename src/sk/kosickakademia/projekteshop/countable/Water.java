package sk.kosickakademia.projekteshop.countable;

import sk.kosickakademia.projekteshop.Item;

public class Water extends Item implements CountItem{
    private int count;
    public Water(double price, String name, int count) {
        super(price, name);
        this.count=count;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public double getItemPrice() {
        return 0;
    }
}
