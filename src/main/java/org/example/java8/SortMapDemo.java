package org.example.java8;

import java.util.*;

public class SortMapDemo {
    public static void main(String[] args) {

        Map<String,Integer> hm = new HashMap<>();
        hm.put("Nick",6);
        hm.put("Ove",8);
        hm.put("Mike",4);
        hm.put("Col",2);

        List<Map.Entry<String, Integer>> listHm = new ArrayList<>(hm.entrySet());

        Collections.sort(listHm, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        Collections.sort(listHm, ((o1, o2) -> o1.getKey().compareTo(o2.getKey())));

        Collections.sort(listHm, Comparator.comparing(Map.Entry::getKey));

        listHm.forEach((entry)-> System.out.println(entry.getKey() + " " + entry.getValue()));

        hm.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);

        List<Map.Entry<String, Integer>> res = hm.entrySet().stream().sorted(Map.Entry.comparingByKey()).toList();
        System.out.println(res);

        Map<Employee,Integer> employeeMap = new TreeMap<>(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        //Can also be written as lambda expression as comparator is a functional interface

        Map<Employee,Integer> employeeMap2 = new TreeMap<>(((o1, o2) -> o1.getName().compareTo(o2.getName())));

        //Can also be written as

        Map<Employee,Integer> employeeMap3 = new TreeMap<>(Comparator.comparing(Employee::getName));

        employeeMap3.put(new Employee(1,"Nick","pata nahi", "A",302000),80);
        employeeMap3.put(new Employee(2,"Chris","pata nahi","A", 5436453),70);
        employeeMap3.put(new Employee(3,"Brown","pata nahi", "B", 54754),30);
        employeeMap3.put(new Employee(4,"Max","pata nahi", "C", 543564),90);

        System.out.println(employeeMap3);

        //we can do the same using stream as well

        employeeMap3.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getSalary)))
                .forEach(System.out::println);

        //we can sort it in descending as well by calling reversed() in comparator
        employeeMap3.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getSalary).reversed()))
                .forEach(System.out::println);

    }
}
