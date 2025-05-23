package org.example.java8;

interface Calculator{
    void switchOn();
}

interface Calculator2{
    void sum(int input);
}

interface Calculator3{
    int subtract(int i1, int i2);
}

//public class CalculatorImpl implements Calculator{
//
//    @Override
//    public void switchOn() {
//        System.out.println("Switch on!");
//    }
//
//    public static void main(String[] args) {
//        CalculatorImpl calculator = new CalculatorImpl();
//        calculator.switchOn();
//    }
//
//}

public class CalculatorImpl{
    public static void main(String[] args) {
        Calculator calculator = () -> {
            System.out.println("switch On Lambda!");
        };
        calculator.switchOn();

        Calculator2 calculator2 = (input) -> {
            System.out.println("The sum is = " + input);
        };

        System.out.println("hello");
        calculator2.sum(120);

        Calculator3 calculator3 = (i1,i2) -> i2-i1;
        System.out.println(calculator3.subtract(2,5));
    }
}
