package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of unsorted numbers and a target number,
 * find all unique quadruplets in it, whose sum is equal to the target number.
 *
 * Input: [4, 1, 2, -1, 1, -3], target=1
 * Output: [-3, -1, 1, 4], [-3, 1, 1, 2]
 * Explanation: Both the quadruplets add up to the target.
 *
 * Input: [2, 0, -1, 1, -2, 2], target=2
 * Output: [-2, 0, 2, 2], [-1, 0, 1, 2]
 * Explanation: Both the quadruplets add up to the target.
 */
public class SumOfFour {

    public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        int n = arr.length;
        ;
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<n-3; i++) {
            if (i>0 && arr[i] == arr[i-1]) {
                continue;
            }
            for(int j=i+1; j<n-2; j++) {
                if (j > i+1 && arr[j] == arr[j-1]) {
                    continue;
                }
                // target-arr[i]-arr[j] = arr[left]+arr[right]
                // target = arr[i] + arr[j] + arr[left] + arr[right]
                searchPairs(arr, target-arr[i]-arr[j], i, j, result);
                //searchPairs(arr, target, i, j, result);
            }
        }

        return result;
    }

    public static void searchPairs(int[] arr, int target, int first, int second, List<List<Integer>> quadruplets) {
        int right = arr.length-1;
        int left = second + 1;
        while(left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                quadruplets.add(Arrays.asList(arr[first], arr[second], arr[left], arr[right]));
                left++;
                right--;

                while(left<right && arr[left] == arr[left-1]) {
                    left++;
                }
                while(left<right && arr[right] == arr[right+1]) {
                    right--;
                }
            } else if (sum > target) {
                right--;
            } else  { // (sum < target)
                left++;
            }
        }
    }

//    public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
//        Arrays.sort(arr);
//        List<List<Integer>> quadruplets = new ArrayList<>();
//        for (int i = 0; i < arr.length - 3; i++) {
//            if (i > 0 && arr[i] == arr[i - 1]) // skip same element to avoid duplicate quadruplets
//                continue;
//            for (int j = i + 1; j < arr.length - 2; j++) {
//                if (j > i + 1 && arr[j] == arr[j - 1]) // skip same element to avoid duplicate quadruplets
//                    continue;
//                searchPairs(arr, target, i, j, quadruplets);
//            }
//        }
//        return quadruplets;
//    }
//
//    private static void searchPairs(int[] arr, int targetSum, int first, int second, List<List<Integer>> quadruplets) {
//        int left = second + 1;
//        int right = arr.length - 1;
//        while (left < right) {
//            int sum = arr[first] + arr[second] + arr[left] + arr[right];
//            if (sum == targetSum) { // found the quadruplet
//                quadruplets.add(Arrays.asList(arr[first], arr[second], arr[left], arr[right]));
//                left++;
//                right--;
//                while (left < right && arr[left] == arr[left - 1])
//                    left++; // skip same element to avoid duplicate quadruplets
//                while (left < right && arr[right] == arr[right + 1])
//                    right--; // skip same element to avoid duplicate quadruplets
//            } else if (sum < targetSum)
//                left++; // we need a pair with a bigger sum
//            else
//                right--; // we need a pair with a smaller sum
//        }
//    }
    public static void main(String args[]) {
        System.out.println("\nInput: [4, 1, 2, -1, 1, -3], k=1 \nOutput: " + SumOfFour.searchQuadruplets(new int[]{4, 1, 2, -1, 1, -3 }, 1));

        System.out.println("\nInput: [1,0,-1,0,-2,2], k=0 \nOutput: " + SumOfFour.searchQuadruplets(new int[]{1,0,-1,0,-2,2 }, 0));



    }
}
