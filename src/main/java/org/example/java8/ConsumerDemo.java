package org.example.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

//public class ConsumerDemo implements Consumer<Integer> {
//
//    @Override
//    public void accept(Integer i) {
//        System.out.println("Print: "+i);
//    }
//
//    public static void main(String[] args) {
//        ConsumerDemo consumerDemo = new ConsumerDemo();
//        consumerDemo.accept(20);
//    }
//}

public class ConsumerDemo{

    public static void main(String[] args) {
        Consumer<Integer> consumer = i -> System.out.println("Print: "+i);
        consumer.accept(28);

        List<Integer> arr = Arrays.asList(1,2,3,4);
        arr.stream().forEach(i -> System.out.println("Print: "+i));
        arr.forEach(i -> System.out.println("Print: "+i));
    }

}





