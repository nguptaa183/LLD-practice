package org.example.java8;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.*;

public class OptionalDemo {

    public static Customer getCustomerByEmailId(String email) throws Exception {
        List<Customer> customers = CustomerDao.getCustomers();
        return customers.stream()
                .filter(customer -> customer.getEmail().equals(email))
                .findAny().orElseThrow(()-> new Exception("No customer present with this email id"));
    }

    public static void main(String[] args) throws Exception {
        Customer customer = new Customer(1,null,"nick@abc.com", Arrays.asList("343214","34324"));

        //empty
        //of
        //ofNullable

        Optional<Object> emptyOptional = Optional.empty();
        System.out.println(emptyOptional);

        //use of when you know the value you're passing isn't null
//        Optional<String> emailOptional = Optional.of(customer.getName());
//        System.out.println(emailOptional);

        //if the value you're passing isn't null us ofNullable
        Optional<String> emailOptional2 = Optional.ofNullable(customer.getName());
        if(emailOptional2.isPresent()) System.out.println(emailOptional2.get());
        System.out.println(emailOptional2.orElse("Hello"));
//        System.out.println(emailOptional2.orElseThrow(() -> new IllegalArgumentException("Name not present!")));

        System.out.println(getCustomerByEmailId("nick@xyz.com").getEmail());

    }
}
