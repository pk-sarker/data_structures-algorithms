package com.practice;

import java.util.*;

/**
 * Given an array with positive numbers and a target number,
 * find all of its contiguous subarrays whose product is less than the target number.
 *
 * Input: [2, 5, 3, 10], target=30
 * Output: [2], [5], [2, 5], [3], [5, 3], [10]
 * Explanation: There are six contiguous subarrays whose product is less than the target.
 *
 * Input: [8, 2, 6, 5], target=50
 * Output: [8], [2], [8, 2], [6], [2, 6], [5], [6, 5]
 * Explanation: There are seven contiguous subarrays whose product is less than the target.
 *
 */
public class SubarrayProductLessThanK {
    public static List<List<Integer>> findSubarrayProductLessThanK(int[] nums, int k){
        int n = nums.length;
        int left = 0, product = 1;
        List<List<Integer>> result = new ArrayList<>();

        for(int right = 0; right < n; right++) {
            product *= nums[right];

            while(product >= k && left < n) {
                product /= nums[left];
                left++;
            }
            List<Integer> temp = new LinkedList<>();
            for(int i=right; i>=left; i--){
                temp.add(0, nums[i]);
                result.add(new ArrayList<>(temp));
            }
        }
        return result;
    }

    /**
     * Your are given an array of positive integers nums.
     *
     * Count and print the number of (contiguous) subarrays
     * where the product of all the elements in the subarray is less than k.
     *
     * @param nums
     * @param k
     * @return
     */
    public static int countSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        if (n==0 || k<=1) {
            return 0;
        }

        int product = 1, left = 0, result = 0;
        for(int right=0; right < n; right++) {
            product = product * nums[right];

            while(product >= k && left < n) {
                product = product/nums[left];
                left++;
            }
            result += right - left + 1;
        }

        return result;
    }

    public static void main(String args[]) {
        System.out.println("\nInput: [2, 5, 3, 10], k=30 \nOutput: "
                + SubarrayProductLessThanK.findSubarrayProductLessThanK(new int[]{2, 5, 3, 10}, 30));
        System.out.println("\nInput: [8, 2, 6, 5], k=50 \nOutput: "
                + SubarrayProductLessThanK.findSubarrayProductLessThanK(new int[]{8, 2, 6, 5}, 50));


        System.out.println("\nInput: [2, 5, 3, 10], k=30 \nOutput: "
                + SubarrayProductLessThanK.countSubarrayProductLessThanK(new int[]{2, 5, 3, 10}, 30));
        System.out.println("\nInput: [8, 2, 6, 5], k=50 \nOutput: "
                + SubarrayProductLessThanK.countSubarrayProductLessThanK(new int[]{8, 2, 6, 5}, 50));
    }
}
