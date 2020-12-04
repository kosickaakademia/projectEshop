package sk.kosickakademia.projekteshop;

import sk.kosickakademia.projekteshop.cart.Cart;
import sk.kosickakademia.projekteshop.countable.Water;
import sk.kosickakademia.projekteshop.uncountable.Apple;
import sk.kosickakademia.projekteshop.util.Util;

public class Main {

    public static void main(String[] args) {
        Cart cart = new Cart();

        Apple item1=new Apple(1.09, "Golden",1.5);
        Item item2=new Water(0.49, "Budis jemne perliva",6);
        Water item3=new Water(1.79, "Orange juice",2);
        Item item4 = new Apple(0.6,"red apple",0.855);

        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item3);
        cart.addItem(item4);

        cart.printCart();
        System.out.println("\nTotal price : "+cart.getTotalPrice());
        System.out.println("( Information price in SKK: "+ Util.convertEurToSkk(cart.getTotalPrice())+ " )");
    }


}
