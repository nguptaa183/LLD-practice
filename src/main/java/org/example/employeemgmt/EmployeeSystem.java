package org.example.employeemgmt;

class Employee{
    private final String name;
    private double salary;

    Employee(String name, double salary){
        this.name=name;
        this.salary=salary;
    }

    String getName(){
        return name;
    }

    double getSalary(){
        return salary;
    }

    double calculateBonus(){
        return 0.1*salary;
    }
}

class Manager extends Employee{

    Manager(String name, double salary){
        super(name,salary);
    }

    @Override
    double calculateBonus(){
        return 0.2*getSalary();
    }
}

class Developer extends Employee{

    Developer(String name, double salary){
        super(name,salary);
    }

    @Override
    double calculateBonus(){
        return 0.15*getSalary();
    }
}

public class EmployeeSystem {
    public static void main(String[] args){
        Employee employee = new Employee("Harshit",100000.00);
        Employee manager = new Manager("Bhawdish",100000.00);
        Employee developer = new Developer("Nikhil",100000.00);

        System.out.printf("Hello %s. You've got $%.2f Bonus!%n",employee.getName(),employee.getSalary());

        System.out.println(employee.getName() + " received " + String.format("%.2f",employee.calculateBonus()) + "$ bonus!");
        System.out.println(manager.getName() + " received " + String.format("%.2f",manager.calculateBonus()) + "$ bonus!");
        System.out.println(developer.getName() + " received " + String.format("%.2f",developer.calculateBonus()) + "$ bonus!");
    }
}
