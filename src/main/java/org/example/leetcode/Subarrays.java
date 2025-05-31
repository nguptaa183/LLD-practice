package org.example.leetcode;

public class Subarrays {
    public static void printAllSubarrays(int[] arr) {
        int n = arr.length;

        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {

                System.out.println(start+ " "+end);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3,4};
        printAllSubarrays(arr);
    }
}
