package org.example.java8;

import java.util.stream.IntStream;
import java.util.*;

public class ParallelStreamExample {
    public static void main(String[] args) {

        long start = 0;
        long end = 0;

        start = System.currentTimeMillis();
        IntStream.range(1, 10_000_000).forEach(i -> {});
        end = System.currentTimeMillis();
        System.out.println("Sequential time: " + (end - start));

        start = System.currentTimeMillis();
        IntStream.range(1, 10_000_000).parallel().forEach(i -> {});
        end = System.currentTimeMillis();
        System.out.println("Parallel time: " + (end - start));

        IntStream.range(1,10).forEach(x -> {
            System.out.println("Thread: " + Thread.currentThread().getName() + " : " + x);
        });

        IntStream.range(1,10).parallel().forEach(x -> {
            System.out.println("Thread: " + Thread.currentThread().getName() + " : " + x);
        });

        List<Employee> employees = EmployeeDao.getBulkEmployees();

        //Find employee average salary using normal stream
        start = System.currentTimeMillis();

        double averageSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .getAsDouble();

        end = System.currentTimeMillis();
        System.out.println("Average Salary: " + averageSalary + " Time taken: " + (end-start));

        //Find employee average salary using parallel stream
        start = System.currentTimeMillis();

        double averageSalaryParallel = employees.parallelStream()
                .mapToDouble(Employee::getSalary)
                .average()
                .getAsDouble();

        end = System.currentTimeMillis();
        System.out.println("Average Salary: " + averageSalaryParallel + " Time taken: " + (end-start));

    }
}