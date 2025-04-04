package org.example.onlineshopping;

import java.util.*;

interface Product{

    UUID getUuid();
    double getPrice();
    String getName();
}

class Electronics implements Product{
    private final UUID uuid;
    private final String name;
    private final double price;
    private final int warranty;

    Electronics(String name, double price, int warranty){
        this.uuid=UUID.randomUUID();
        this.name=name;
        this.price=price;
        this.warranty=warranty;
    }

    public UUID getUuid(){
        return uuid;
    }

    public double getPrice(){
        return price;
    }

    public String getName(){
        return name;
    }
}

class Clothing implements Product{
    private final UUID uuid;
    private final String name;
    private final double price;
    private final String size;

    Clothing(String name, double price, String size){
        this.uuid=UUID.randomUUID();
        this.name=name;
        this.price=price;
        this.size=size;
    }

    public UUID getUuid() {
        return uuid;
    }

    public double getPrice(){
        return price;
    }

    public String getName(){
        return name;
    }
}

class Order{
    private final HashMap<Product,Integer> orderList = new HashMap<>();

    void addToOrderList(Product product, int quantity){
        orderList.put(product,quantity);
    }

    void removeFromOrderList(UUID uuid){

        /*
        Iterator<Product> iterator = orderList.keySet().iterator();
        while(iterator.hasNext()){
            Product product = iterator.next();
            if(product.getUuid().equals(uuid)){
                iterator.remove();
            }
        }
        */

        //OR

        orderList.keySet().removeIf(product -> product.getUuid().equals(uuid));
    }

    void getOrderSummary(){
        if (orderList.isEmpty()) {
            System.out.println("Order is empty.");
            return;
        }

        System.out.println("Order Summary:");
        for (Product product : orderList.keySet()) {
            int quantity = orderList.get(product);
            System.out.printf("%s (%s) - %d pcs - $%.2f each\n",
                    product.getName(), product.getUuid(), quantity, product.getPrice());
        }
    }

    double totalOrderCost(){

        /*
        double total=0;
        for(Product product: orderList.keySet()){
            total+=(product.getPrice()*orderList.get(product));
        }

        return total;
         */

        //OR

        return orderList.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();

    }
}

public class OnlineShoppingSystem {

    public static void main(String[] args){
        // Create Products
        Electronics iphone = new Electronics("iPhone", 48973, 12);
        Clothing jeans = new Clothing("Jeans", 3833, "M");

        Order order = new Order();

        // Add products
        order.addToOrderList(iphone, 2);
        order.addToOrderList(jeans, 1);

        // Display order summary
        order.getOrderSummary();

        // Remove an item
        order.removeFromOrderList(jeans.getUuid());

        // Display updated order
        order.getOrderSummary();

        // Show total cost
        System.out.printf("\nTotal Order Cost: $%.2f\n", order.totalOrderCost());

    }

}
