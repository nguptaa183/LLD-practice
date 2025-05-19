package org.example.dp;

import java.util.Arrays;

public class Knapsack01 {

    public static int knapsack(int[] wt, int[] val, int weight, int n){
        //BC
        if(n==0 || weight==0) return 0;

        if(wt[n-1] <= weight){
            int pick = val[n-1] + knapsack(wt,val,weight-wt[n-1],n-1);
            int notPick = knapsack(wt,val,weight,n-1);
            return Math.max(pick,notPick);
        }
        else{
            return knapsack(wt,val,weight,n-1);
        }
    }

    public static int knapsackMemo(int[] wt, int[] val, int weight, int n,int[][] dp){
        //Base Condition
        if(n==0 || weight==0) return 0;

        if(dp[n][weight]!=-1) return dp[n][weight];

        //Valid weight as per the bag
        //Choice to pick or not pick
        if(wt[n-1]<=weight){
            int pick = val[n-1] + knapsackMemo(wt,val,weight-wt[n-1],n-1,dp);
            int notPick = knapsackMemo(wt,val,weight,n-1,dp);
            dp[n][weight] = Math.max(pick,notPick);
        }
        else{
            dp[n][weight] = knapsackMemo(wt,val,weight,n-1,dp);
        }
        return dp[n][weight];
    }

    public static int knapsackDp(int[] wt, int[] val, int weight, int n, int[][] dpp){
        for(int i=0;i<n+1;i++){
            for(int j=0;j<weight+1;j++){
                if(i==0 || j==0) dpp[i][j] = 0;
                else if(wt[i-1]<=j){
                    int pick = val[i-1] + dpp[i-1][j-wt[i-1]];
                    int notPick = dpp[i-1][j];
                    dpp[i][j]=Math.max(pick,notPick);
                }
                else dpp[i][j]=dpp[i-1][j];
            }
        }
        return dpp[n][weight];
    }

    public static void main(String[] args) {
        int[] wt = {1,3,4,5};
        int[] val = {1,4,5,7};
        int weight = 7;
        int n = wt.length;

        int[][] dp = new int[n+1][weight+1];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }

        int res = knapsack(wt,val,weight,n);
        System.out.println("Knapsack = " + res);

        int resMemo = knapsackMemo(wt, val, weight, n, dp);
        System.out.println("KnapsackMemo = " + resMemo);

        int[][] dpp = new int[n+1][weight+1];

        int resDp = knapsackDp(wt, val, weight, n, dpp);
        System.out.println("KnapsackDp = " + resDp);
    }
}


