package com.practice;

/**
 * Given an array of sorted numbers and a target sum,
 * find a pair in the array whose sum is equal to the given target.
 *
 * Input: [1, 2, 3, 4, 6], target=6
 * Output: [1, 3]
 * Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
 *
 * Input: [2, 5, 9, 11], target=11
 * Output: [0, 2]
 * Explanation: The numbers at index 0 and 2 add up to 11: 2+9=11
 */
public class TwoSumInSortedArray {

    public static int[] search(int[] arr, int targetSum) {
        if (arr.length == 0) {
            return new int[]{};
        }
        int[] result = new int[2];
        int leftPtr = 0, rightPtr = arr.length-1;
        while (leftPtr < rightPtr) {
            int sum = arr[leftPtr] + arr[rightPtr];
            if (sum == targetSum) {
                return new int[]{leftPtr, rightPtr};
            }
            if (sum > targetSum) {
                rightPtr--;
            } else {
                leftPtr++;
            }
        }
        return new int[]{};
    }
    public static void main(String args[]) {
        int[] result = TwoSumInSortedArray.search(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = TwoSumInSortedArray.search(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    }
}
