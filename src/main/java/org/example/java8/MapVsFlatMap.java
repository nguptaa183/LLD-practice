package org.example.java8;
import java.util.*;
import java.util.stream.Collectors;

public class MapVsFlatMap {
    public static void main(String[] args) {
        //Get customers
        List<Customer> customers = CustomerDao.getCustomers();

        //Data transformation from the list of customers to the list of customers email address
        //customer -> customer.getEmail() = One-to-one mapping
        List<String> emailAddress = customers.stream().map(customer -> customer.getEmail()).collect(Collectors.toList());

        //Can also be written as
        List<String> emailAddress2 = customers.stream().map(Customer::getEmail).toList();

        System.out.println(emailAddress);
        System.out.println(emailAddress2);

        //Fetch all the phone numbers
        //customer -> customer.getPhoneNumbers() = One-to-many mapping
        List<List<String>> phoneNumbers = customers.stream().map(Customer::getPhoneNumbers).toList();
        System.out.println(phoneNumbers);

        //In case of phone numbers, one customer has many phone numbers, therefore we need to use flatMap
        List<String> phones = customers.stream()
                .flatMap(customer -> customer.getPhoneNumbers().stream())
                .toList();
        System.out.println(phones);
    }
}
