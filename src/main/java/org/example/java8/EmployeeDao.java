package org.example.java8;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class EmployeeDao {
    public static List<Employee> getEmployees(){
        List<Employee> arr = new ArrayList<>();
        arr.add(new Employee(1,"Nick","pata nahi", "A",302000));
        arr.add(new Employee(2,"Chris","pata nahi","A", 5436453));
        arr.add(new Employee(3,"Brown","pata nahi", "B", 54754));
        arr.add(new Employee(4,"Max","pata nahi", "C", 543564));
        arr.add(new Employee(5,"Paul","pata nahi", "B", 7987687));
        return arr;
    }

    public static List<Employee> getBulkEmployees(){
        List<Employee> employees = new ArrayList<>();
        for(int i=1;i<=100000;i++){
            employees.add(new Employee(i,"Employee"+i, "pata"+i+"nahi", "A", ThreadLocalRandom.current().nextDouble(10000,1000000)));

        }
        return employees;
    }
}
