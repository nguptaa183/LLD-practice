package org.example.practice;

import java.util.ArrayList;
import java.util.Collections;

public class Main{
    public static void main(String[] args){
        String name = "Nikhil";
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Input radius: ");
//        int radius=scanner.nextInt();
        float radii=2.5f;
        double dd=3.6;

//        if(radius==2){
//            System.out.println("Yayyyay!");
//        }

        int[] arrFixed = {1,2,3,4,5};
        System.out.println(arrFixed[0]);

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        System.out.println("Arraylist: " + arrayList);
        System.out.println(arrayList.get(1));

        System.out.println(Collections.max(arrayList));
        System.out.println(arrayList.get(arrayList.size()-1));

        for(int i = 0; i<3; i++){
            System.out.println("Hello World");
        }

    }
}

