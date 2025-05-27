package org.example.java8;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomerDao {
    public static List<Customer> getCustomers(){
        return Stream.of(new Customer(1,"Nick","nick@xyz.com",Arrays.asList("123","3434")),
                new Customer(1,"Chris","chris@xyz.com",Arrays.asList("123","3434")),
                new Customer(1,"Brown","brown@xyz.com",Arrays.asList("123","3434")),
                new Customer(1,"Adam","adam@xyz.com",Arrays.asList("123","3434")),
                new Customer(1,"Eve","eve@xyz.com",Arrays.asList("123","3434"))
        ).collect(Collectors.toList());
    }
}
