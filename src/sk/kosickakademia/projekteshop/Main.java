package sk.kosickakademia.projekteshop;

import sk.kosickakademia.projekteshop.cart.Cart;
import sk.kosickakademia.projekteshop.countable.Water;
import sk.kosickakademia.projekteshop.coupon.Coupon;
import sk.kosickakademia.projekteshop.coupon.Reader;
import sk.kosickakademia.projekteshop.service.Delivery;
import sk.kosickakademia.projekteshop.uncountable.Apple;
import sk.kosickakademia.projekteshop.util.Util;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Cart cart = new Cart();

        Apple item1=new Apple(1.09, "Golden",1.5);
        Apple item5=new Apple(1.60, "Idared",2.3);
        Item item2=new Water(0.49, "Budis jemne perliva",6);
        Item item8=new Water(0.49, "Budis jemne perliva",4);
        Water item3=new Water(1.79, "Orange juice",2);
        Item item4 = new Apple(1.0,"red apple",5.2);
        Apple item6=new Apple(1.09, "Golden",0.54);
        Apple item7=new Apple(1.19, "Golden",1);

        Item delivery = new Delivery(2.99);

        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item3);
        cart.addItem(item4);
        cart.addItem(item5);
        cart.addItem(item6);
        cart.addItem(item7);
        cart.addItem(item8);
        cart.addItem(delivery);

        double totalPrice= cart.getTotalPrice();

        cart.printCart();
        System.out.println("Do you have any coupon (y/n) ?");
        Scanner scanner = new Scanner(System.in);
        String coupon;
        String input = scanner.nextLine().toLowerCase();
        if(input.charAt(0)=='y'){
            System.out.println("Enter coupon code: ");
            coupon = scanner.nextLine();
            List<Coupon> list = Reader.getListOfCouponsFromFile();
            totalPrice = cart.getTotalPrice();
            for(Coupon temp:list){
                if(temp.getCode().equalsIgnoreCase(coupon)){
                    System.out.println("Coupon is valid");
                    totalPrice=totalPrice*(1-(double)temp.getValue()/100);
                    list.remove(temp);
                    break;
                }
            }
            Reader.updateCoupons(list);
        }
        System.out.println("\nTotal price : "+totalPrice);
        System.out.println("( Information price in SKK: "+ Util.convertEurToSkk(cart.getTotalPrice())+ " )");
    }


}
