package org.example.leetcode;

import java.util.Arrays;

public class lc560 {
    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        int it=56;
        System.out.println(Integer.toString(it));
        System.out.println(Arrays.stream(nums).sum());

        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                System.out.println(i+" "+j);
            }
        }
//        Arrays.de
    }
}
