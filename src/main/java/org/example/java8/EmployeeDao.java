package org.example.java8;
import java.util.*;

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
}
