package org.example.leetcode;

import java.util.Arrays;

public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] inp = new int[3][5];
        inp[0][4]=5;
        inp[2][0]=1;
        inp[1][1]=2;
        inp[1][2]=2;
        inp[1][3]=2;

        for(int[] i:inp){
            System.out.println(Arrays.toString(i));
        }

        System.out.println("\n=============\n");

        int[][] dp = new int[3][5];
        int rows = dp.length;
        int cols = dp[0].length;
        for(int r=rows-1;r>=0;r--){
            for(int c=0;c<cols;c++){
                if(r==rows-1 && c==0) dp[r][c]=inp[r][c];
                else if(r==rows-1) dp[r][c]=inp[r][c]+dp[r][c-1];
                else if(c==0) dp[r][c]=inp[r][c]+dp[r+1][c];
                else dp[r][c]=inp[r][c]+Math.max(dp[r][c-1],dp[r+1][c]);
            }
        }
        for(int[] i:dp) System.out.println(Arrays.toString(i));
    }
}
