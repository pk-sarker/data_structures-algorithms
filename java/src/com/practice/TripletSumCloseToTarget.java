package com.practice;

import java.util.Arrays;

/**
 * Given an array of unsorted numbers and a target number,
 * find a triplet in the array whose sum is as close to the
 * target number as possible, return the sum of the triplet.
 * If there are more than one such triplet, return the sum of the
 * triplet with the smallest sum.
 *
 * Input: [-2, 0, 1, 2], target=2
 * Output: 1
 * Explanation: The triplet [-2, 1, 2] has the closest sum to the target.
 *
 * Input: [-3, -1, 1, 2], target=1
 * Output: 0
 * Explanation: The triplet [-3, 1, 2] has the closest sum to the target.
 *
 * Input: [1, 0, 1, 1], target=100
 * Output: 3
 * Explanation: The triplet [1, 1, 1] has the closest sum to the target.
 *
 */
public class TripletSumCloseToTarget {

    public static int searchTriplet(int[] arr, int targetSum) {

        int n = arr.length;
        if (n<3) {
            return 0;
        }
        Arrays.sort(arr);
        int smallestDiff = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            int left = i+1;
            int right = n - 1;

            while(left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                int diff = targetSum - sum;
                if (diff == 0) {
                    return targetSum;
                }
                if (Math.abs(diff) < Math.abs(smallestDiff) || (Math.abs(diff) == Math.abs(smallestDiff) && diff > smallestDiff)) {
                    smallestDiff = diff;
                }
                if (diff > 0) {
                    left++; // a triplet with a bigger sum
                } else {
                    right--; // a triplet with a smaller sum
                }
            }
        }

        return targetSum - smallestDiff;
    }

    public static void main(String args[]) {
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -2, 0, 1, 2 }, 2));
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -3, -1, 1, 2 }, 1));
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { 1, 0, 1, 1 }, 100));

        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -1,2,1,-4 }, 1));


    }

}
