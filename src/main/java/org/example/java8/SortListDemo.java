package org.example.java8;

import java.util.*;

public class SortListDemo {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(4);
        arr.add(10);
        arr.add(2);
        arr.add(1);

        Collections.sort(arr);
        System.out.println(arr);
        Collections.reverse(arr);
        System.out.println(arr);

        arr.stream().sorted().forEach(i-> System.out.println(i));
        arr.stream().sorted(Comparator.reverseOrder()).forEach(i-> System.out.println(i));

        List<Employee> employees = EmployeeDao.getEmployees();

        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return (int) (o1.getSalary() - o2.getSalary());
            }
        });

        System.out.println(employees);

        employees.sort((o1, o2) -> (int) (o1.getSalary()-o2.getSalary())); //Might give integer overflow while converting from double to int

        employees.sort(Comparator.comparingDouble(Employee::getSalary)); //preferred way using method reference

        System.out.println(employees);

        List<Employee> res = employees.stream().sorted(((o1, o2) -> (int) (o1.getSalary()-o2.getSalary()))).toList();

        List<Employee> res2 = employees.stream().sorted(Comparator.comparingInt(Employee::getId)).toList();

        System.out.println(res);
        System.out.println(res2);


    }
}
