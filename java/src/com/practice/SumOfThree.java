package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such that
 * a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Input: [-3, 0, 1, 2, -1, 1, -2]
 * Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
 * Explanation: There are four unique triplets whose sum is equal to zero.
 *
 * Input: [-5, 2, -1, -2, 3]
 * Output: [[-5, 2, 3], [-2, -1, 3]]
 * Explanation: There are two unique triplets whose sum is equal to zero.
 */
public class SumOfThree {

    public static List<List<Integer>> searchTriplets(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if (i>0 && arr[i] == arr[i-1]) {
                continue;
            }
            SumOfThree.searchPair(arr, -arr[i], i+1, result);
        }
        return result;
    }

    private static void searchPair(int[] arr, int targetSum, int left, List<List<Integer>> triplets){
        int right = arr.length - 1;
        int sum = 0;
        while(left < right) {
            sum = arr[left] + arr[right];
            if (sum==targetSum) {
                triplets.add(Arrays.asList(-targetSum, arr[left], arr[right]));
                left++;
                right--;

                // skip same element to avoid duplicate triplets
                while(left < right && arr[left] == arr[left-1]) {
                    left++;
                }
                // skip same element to avoid duplicate triplets
                while(left < right && arr[right] == arr[right+1]) {
                    right--;
                }
            } else if (sum>targetSum) {
                right--;
            } else {
                left++;
            }
        }
    }


    public static void main(String args[]) {
        System.out.println(SumOfThree.searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
        System.out.println(SumOfThree.searchTriplets(new int[] { -5, 2, -1, -2, 3 }));

        System.out.println(SumOfThree.searchTriplets(new int[] { 1,2,-2,-1 }));



    }
}
