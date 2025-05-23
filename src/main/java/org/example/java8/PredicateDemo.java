package org.example.java8;

import java.util.function.Predicate;
import java.util.*;

//public class PredicateDemo implements Predicate<Integer> {
//
//    @Override
//    public boolean test(Integer i) {
//        return i % 2 == 0;
//    }
//
//    public static void main(String[] args) {
//        PredicateDemo predicateDemo = new PredicateDemo();
//        boolean res = predicateDemo.test(21);
//        System.out.println(res);
//    }
//}

public class PredicateDemo{
    public static void main(String[] args) {
        Predicate<Integer> predicate = i -> i % 2 == 0;
        System.out.println(predicate.test(20));

        List<Integer> arr = Arrays.asList(1, 2, 3, 4);
        arr.stream()
                .filter(i -> i%2==0)
                .forEach(i -> System.out.println("Even: "+i));

    }
}