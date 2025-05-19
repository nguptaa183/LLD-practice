package org.example.leetcode;

import java.util.*;
import java.util.Collections;
import java.util.List;

public class CoinChange {

    public static int solution(int[] coins, int amount){
        int n = coins.length;
        int[] res = {Integer.MAX_VALUE};
        List<Integer> arr = new ArrayList<>();
        int i=0;
        backtrack(arr,i,res,n,amount,coins);
        return res[0];
    }

    private static void backtrack(List<Integer> arr, int i, int[] res, int n, int amount,int[] coins) {

        if(sum(arr)==amount){
            System.out.println(arr);
            res[0]=Math.min(res[0],arr.size());
            return;
        }

        if(sum(arr) > amount || i==n){
            return;
        }

        arr.add(coins[i]);
        backtrack(arr, i, res, n, amount,coins);

        arr.remove(arr.size()-1);
        backtrack(arr, i+1, res, n, amount,coins);

    }

    public static int sum(List<Integer> arr){
        int res=0;
        for(int i:arr){
            res+=i;
        }
        return res;
    }



    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        int res = solution(coins, amount);
        System.out.println(res);
    }
}
