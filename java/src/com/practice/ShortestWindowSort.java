package com.practice;

/**
 * Given an integer array nums, you need to find one continuous subarray
 * that if you only sort this subarray in ascending order, then the whole
 * array will be sorted in ascending order.
 *
 * Return the shortest such subarray and output its length.
 *
 * Input: nums = [2,6,4,8,10,9,15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order
 * to make the whole array sorted in ascending order.
 *
 * Input: nums = [1,2,3,4]
 * Output: 0
 *
 * Input: nums = [1]
 * Output: 0
 *
 * Input: [1, 3, 2, 0, -1, 7, 10]
 * Output: 5
 * Explanation: We need to sort only the subarray [1, 3, 2, 0, -1] to make the whole array sorted
 *
 * Input: [3, 2, 1]
 * Output: 3
 * Explanation: The whole array needs to be sorted.
 *
 */
public class ShortestWindowSort {

    public static int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        if (n==1) {
            return 0;
        }
        int low = 0, high = n - 1;
        // find the first occurrence of ordering issue from left
        while(low < n - 1 && nums[low] <= nums[low+1]) {
            low++;
        }
        // array is already sorted
        if (low == n - 1) {
            return 0;
        }

        // find the first occurrence of ordering issue from right
        while(high > 0 && nums[high] >= nums[high-1]) {
            high--;
        }

        // now low points the the previous number where there is a ordering issue from left and
        // high points to the previous number where there is a ordering issue from right

        // find the maximum and minimum of the subarray where ordering issue is present
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int i = low; i<=high; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        // expand window
        while(low>0 && nums[low-1] > min) {
            low--;
        }
        while(high<n-1 && nums[high+1] < max) {
            high++;
        }
        return high - low + 1;
    }


    public static int findUnsortedSubarray1(int[] nums) {
        int n = nums.length;
        if (n<=1) {
            return 0;
        }
        int low = 0, high = n - 1;

        // find ordering issue from left/low
        while(low<n-1 && nums[low] <= nums[low+1]) {
            low++;
        }

        if (low == n - 1) {
            return 0; // array is already sorted
        }
        // find ordering issue from right/high
        while(high>0 && nums[high] >= nums[high-1]) {
            high--;
        }

        // find max and min in the window.
        int max = Integer.MAX_VALUE, min = Integer.MIN_VALUE;
        for(int i=low; i<=high; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        // expand the window if needed
        while(low > 0 && nums[low-1] > min) {
            low--;
        }

        while(high < n-1 && nums[high+1] < max) {
            high++;
        }

        return high-low+1;
    }

    public static void main(String args[]) {
        System.out.println("\nInput: [2,6,4,8,10,9,15] \nOutput: "
                + ShortestWindowSort.findUnsortedSubarray(new int[] {2,6,4,8,10,9,15}));

        System.out.println("\nInput: [2,6,4,8,10,9,15] \nOutput: "
                + ShortestWindowSort.findUnsortedSubarray1(new int[] {2,6,4,8,10,9,15}));

//        System.out.println("\nInput: [1,2,3,4] \nOutput: "
//                + ShortestWindowSort.findUnsortedSubarray(new int[] {1,2,3,4}));
//
//        System.out.println("\nInput: [4,3,2,1] \nOutput: "
//                + ShortestWindowSort.findUnsortedSubarray(new int[] {4,3,2,1}));
//
//        System.out.println("\nInput: [9] \nOutput: "
//                + ShortestWindowSort.findUnsortedSubarray(new int[] {9}));
//
//        System.out.println("\nInput: [1, 6, 3, 2, 0, -1, 7, 10] \nOutput: "
//                + ShortestWindowSort.findUnsortedSubarray(new int[] {1, 6, 3, 2, 0, -1, 7, 10}));
    }
}
