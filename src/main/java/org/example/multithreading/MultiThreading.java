package org.example.multithreading;

public class MultiThreading {
    public static void main(String[] args) {
        MultiThreadThing multiThreadThing = new MultiThreadThing(1);
        MultiThreadThing multiThreadThing2 = new MultiThreadThing(2);

        multiThreadThing.start();
        multiThreadThing2.start();

    }
}
