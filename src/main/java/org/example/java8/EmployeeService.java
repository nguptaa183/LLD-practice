package org.example.java8;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeService {
    public static List<Employee> evaluateTaxUsers(String inp){
        List<Employee> employees = EmployeeDao.getEmployees();
        return (inp.equalsIgnoreCase("tax"))
                ? employees.stream().filter(o -> o.getSalary() > 600000).collect(Collectors.toList())
                : employees.stream().filter(o -> o.getSalary() <= 600000).collect(Collectors.toList());
        }

    public static void main(String[] args) {
        List<Employee> res = evaluateTaxUsers("TAX");
        System.out.println(res);
    }
}
