package org.example.onlineshopping;

import java.util.ArrayList;
import java.util.List;

interface Product{
    double getPrice();
    String getName();
}

class Electronics implements Product{
    private final String name;
    private final double price;
    private final int warranty;

    Electronics(String name, double price, int warranty){
        this.name=name;
        this.price=price;
        this.warranty=warranty;
    }

    public double getPrice(){
        return price;
    }

    public String getName(){
        return name;
    }
}

class Clothing implements Product{
    private final String name;
    private final double price;
    private final String size;

    Clothing(String name, double price, String size){
        this.name=name;
        this.price=price;
        this.size=size;
    }

    public double getPrice(){
        return price;
    }

    public String getName(){
        return name;
    }
}

class Order{
    List<Product> productList = new ArrayList<>();
}

public class OnlineShoppingSystem {
}
