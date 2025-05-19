package org.example.dp;

public class CoinChange {

    public static int minCoin(int[] coins, int target, int n){
        //BC
        if(n==0 || target==0) return 0;

        if(coins[n-1]<=target){
            int pick = coins[n-1] + minCoin(coins, target-coins[n-1],n);
            int notPick = minCoin(coins, target,n-1);
            return Math.min(pick,notPick);
        }
        else{
            return minCoin(coins,target,n-1);
        }
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int target = 11;
        int n = coins.length;

        int res = minCoin(coins,target,n);
        System.out.println(res);

    }
}
