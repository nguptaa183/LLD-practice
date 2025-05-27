package org.example.java8;
import java.util.*;

public class MapReduceExample {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(3,7,8,1,5,9));

        //Find sum of the arr using various ways

        int sum=0;
        for(int i:arr){
            sum+=i;
        }
        System.out.println(sum);

        int sum2 = arr.stream().mapToInt(i->i).sum();
        System.out.println(sum2);

        int sum3 = arr.stream().reduce(0, (a,b)->a+b);
        System.out.println(sum3);

        int sum4 = arr.stream().reduce(0, Integer::sum);
        System.out.println(sum4);

        int product = arr.stream().reduce(1, (a,b)->a*b);
        System.out.println(product);

        int largest = arr.stream().reduce(0, (a, b)-> a>b?a:b);
        System.out.println(largest);

        int largestWithMethodReference = arr.stream().reduce(Integer::max).get();
        System.out.println(largestWithMethodReference);

        //Find the longest string from a list of string
        List<String> words = Arrays.asList("Hello","I","Love","You","Beautiful");

        String longestWord = words.stream().reduce("",(a,b)->a.length() > b.length() ? a : b);
        System.out.println(longestWord);

        //Evaluate average salary of grade A employees
        List<Employee> employees = EmployeeDao.getEmployees();
        double average = employees.stream()
                .filter(employee -> employee.getGrade().equalsIgnoreCase("A"))
                .mapToDouble(Employee::getSalary).average().getAsDouble();

        System.out.println(average);

    }
}
