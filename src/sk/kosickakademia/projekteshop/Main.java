package sk.kosickakademia.projekteshop;

import sk.kosickakademia.projekteshop.cart.Cart;
import sk.kosickakademia.projekteshop.countable.Water;
import sk.kosickakademia.projekteshop.coupon.Coupon;
import sk.kosickakademia.projekteshop.coupon.Reader;
import sk.kosickakademia.projekteshop.uncountable.Apple;
import sk.kosickakademia.projekteshop.util.Util;

import java.util.List;
import java.util.Scanner;

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

        double totalPrice=0;

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
