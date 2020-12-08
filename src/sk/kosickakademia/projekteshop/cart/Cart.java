package sk.kosickakademia.projekteshop.cart;

import sk.kosickakademia.projekteshop.Item;
import sk.kosickakademia.projekteshop.countable.CountItem;
import sk.kosickakademia.projekteshop.service.ServiceInterface;
import sk.kosickakademia.projekteshop.uncountable.WeightItem;
import sk.kosickakademia.projekteshop.util.Util;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Item> list;

    public Cart() {
        list = new ArrayList<>();
    }

    public void addItem(Item newItem){
        if(newItem.getPrice()>=0){
            if(newItem instanceof CountItem && ((CountItem) newItem).getCount()>0){
                list.add(newItem);
            }
            if(newItem instanceof WeightItem && ((WeightItem) newItem).getWeight()>0){
                list.add(newItem);
            }
            if(newItem instanceof ServiceInterface){
                list.add(newItem);
            }
        }

    }
    public int getCountOfItemsInCart(){
        return list.size();
    }
    public double getTotalPrice(){
        double total = 0;
        for(Item temp : list){
            total = total + Util.formatPrice(temp.getItemPrice());
        }
        return Util.formatPrice(total);
    }
    public void printCart(){
        System.out.println("List of items in your cart:");
        for(Item temp : list){
            System.out.println(" -  "+temp.toString());
        }
    }
}
