package org.example.java8;

public class Employee {
    private int id;
    private String name;
    private String address;
    private String grade;
    private double salary;

    public Employee(int id, String name, String address, String grade, double salary) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.grade = grade;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getSalary() {
        return salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}
