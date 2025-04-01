package org.example.practice;

abstract class Animal{
    String name;
    String id;

    public Animal(String name){
        this.name = name;
        System.out.println("Animal constructor called!");
    }

    abstract String sound();
}

class Dog extends Animal{

    Dog(String name){
        super(name);
    }

    @Override
    String sound(){
        return "Dog Barks!";
    }
}

public class Practice{
    public static void main(String[] args){
        Dog dog = new Dog("Kelly");
        System.out.println(dog.name);
        System.out.println(dog.sound());
    }
}