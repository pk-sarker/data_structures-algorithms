package com.practice;

import java.util.Arrays;

/**
 * Given an array arr of unsorted numbers and a target sum,
 * count all triplets in it such that arr[i] + arr[j] + arr[k] < target
 * where i, j, and k are three different indices.
 * Write a function to return the count of such triplets.
 *
 * Input: [-1, 0, 2, 3], target=3
 * Output: 2
 * Explanation: There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]
 *
 * Input: [-1, 4, 2, 1, 3], target=5
 * Output: 4
 * Explanation: There are four triplets whose sum is less than the target:
 *    [-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]
 *
 *
 */
public class TripletSumSmallerSum {

    public static int searchTriplet(int[] arr, int targetSum) {
        int n = arr.length;
        if (n<3) {
            return 0;
        }
        Arrays.sort(arr);
        int count = 0, left = 0, right = n - 1;

        for(int i =0; i<n; i++) {
            left = i + 1;
            right = n - 1;
            int target = targetSum - arr[i];
            while(left < right) {
                if ((arr[left]+arr[right]) < target) {
                    // count++;
                    count += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        return count;
    }

    public static void main(String args[]) {

        System.out.println("\nInput: [-1, 0, 2, 3], k=3 \nOutput: " + TripletSumSmallerSum.searchTriplet(new int[] { -1, 0, 2, 3 }, 3));


        System.out.println("\nInput: [-1, 4, 2, 1, 3], k=5 \nOutput: " +
                TripletSumSmallerSum.searchTriplet(new int[] { -1, 4, 2, 1, 3  }, 5));
    }
}
