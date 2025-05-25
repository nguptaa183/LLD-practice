package org.example.java8;

import java.util.*;
import java.util.function.Consumer;

public class ForEachDemo {
    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        arr.add("Nick");
        arr.add("Chris");
        arr.add("Nuck");
        arr.add("Hash");

        arr.stream().forEach(s-> System.out.println(s));

        Map<Integer,Integer> hm = new HashMap<>();
        hm.put(1,2);
        hm.put(2,3);
        hm.put(3,4);

        hm.forEach((k,v)-> System.out.println(k + " " + v));

        Consumer<String> consumer = i -> System.out.println(i);
        consumer.accept("Hello World!");

        arr.stream().filter(i->i.startsWith("N")).forEach(s-> System.out.println(s));

        hm.entrySet().stream()
                .filter(k -> k.getKey()%2==0)
                .forEach(s-> System.out.println(s));


    }
}
