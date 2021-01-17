package com.practice;

import java.util.Arrays;

/**
 * Given an integer array nums sorted in non-decreasing order,
 * return an array of the squares of each number sorted in non-decreasing order.
 *
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 *
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 *
 */
public class SortedArraySquares {
    public static int[] sortedSquares(int[] nums) {
        if (nums.length == 0) {
            return new int[]{};
        }
        int[] result = new int[nums.length];
        int left = 0, right = nums.length - 1, lsq = 0, rsq = 0, counter = nums.length - 1;

        while (left<=right) {
            lsq = nums[left] * nums[left];
            rsq = nums[right] * nums[right];
            if (lsq > rsq) {
                result[counter] = lsq;
                left++;
            } else {
                result[counter] = rsq;
                right--;
            }
            counter--;
        }
        return result;
    }

    public static void main(String args[]) {


        System.out.println("\nInput: [-7,-3,2,3,11] \nOutput: "+ Arrays.toString(SortedArraySquares.sortedSquares(new int[]{-7,-3,2,3,11})));

//        System.out.println("\nInput: [-2, -1, 0, 2, 3] \nOutput: "+ Arrays.toString(SortedArraySquares.sortedSquares(new int[]{-2, -1, 0, 2, 3})));
//        System.out.println("\nInput: [-3, -1, 0, 1, 2] \nOutput: "+ Arrays.toString(SortedArraySquares.sortedSquares(new int[]{-3, -1, 0, 1, 2})));
    }
}
