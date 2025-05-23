package org.example.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

//public class SupplierDemo implements Supplier<String> {
//
//    @Override
//    public String get() {
//        return "Hi Nikhil here!";
//    }
//
//    public static void main(String[] args) {
//        SupplierDemo supplierDemo = new SupplierDemo();
//        System.out.println(supplierDemo.get());
//    }
//}

public class SupplierDemo{
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "Hello";
        System.out.println(supplier.get());

        List<String> arr = Arrays.asList();
        System.out.println(arr.stream()
                .findAny()
                .orElseGet(() -> "Hello World!"));
    }
}
