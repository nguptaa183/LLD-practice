package org.example.practice;

import java.util.*;

public class OptimalBalancing{

    public static int optimal(List<List<Integer>> inp){
        //Net balance of each
        Map<Integer,Integer> nb = new HashMap<>();
        for(List<Integer> i:inp){
            int from = i.get(0);
            int to = i.get(1);
            int amount = i.get(2);
            nb.put(from, nb.getOrDefault(from,0)-amount);
            nb.put(to, nb.getOrDefault(to,0)+amount);
        }

        //Remove individual with zero net balance
        List<Integer> debt = new ArrayList<>(nb.values());
        debt.removeIf(i->i==0);

        return dfs(debt,0);
    }

    public static int dfs(List<Integer> debt, int start){

        while(start<debt.size() && debt.get(start)==0){
            start++;
        }

        //Base condition
        if(start==debt.size()) return 0;

        int minTransaction = Integer.MAX_VALUE;

        for(int i=start+1;i<debt.size();i++){
            if (debt.get(start) * debt.get(i) < 0){
                debt.set(i,debt.get(i)+debt.get(start));
                minTransaction = Math.min(minTransaction,1+dfs(debt,start+1));
                debt.set(i,debt.get(i)-debt.get(start));
            }
        }
        return minTransaction;
    }

    public static void main(String[] args) {
        List<List<Integer>> inp = new ArrayList<>();
//        inp.add(Arrays.asList(0,1,10));
//        inp.add(Arrays.asList(1,0,1));
//        inp.add(Arrays.asList(1,2,5));
//        inp.add(Arrays.asList(2,0,5));
        inp.add(Arrays.asList(0,1,10));
        inp.add(Arrays.asList(2,0,5));

        int res = optimal(inp);
        System.out.println(res);

    }
}