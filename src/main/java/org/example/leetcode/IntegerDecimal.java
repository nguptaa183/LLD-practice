package org.example.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntegerDecimal {

    public static String solution(int num,int den){

        StringBuilder res = new StringBuilder();
        List<List<Integer>> arr = new ArrayList<>();

        if((num<0) ^ (den<0)) res.append("-");

        int quo = num/den;
        res.append(quo);
        int rem = num%den;

        if (rem==0) return res.toString();

        res.append(".");
        Map<Integer, Integer> hm = new HashMap<>();
        while(rem!=0){
            if(hm.containsKey(rem)){
                int start = hm.get(rem);
                res.insert(start,"(");
                res.append(")");
                break;
            }

            hm.put(rem,res.length());
            rem=rem*10;
            int qt = rem/den;
            res.append(qt);
            rem=rem%den;
        }

        String s = "fs";
        return res.toString();


    }

    public static void main(String[] args){
        int num = 4;
        int den = 333;


        String res = solution(num,den);
        System.out.println(res);
    }
}
