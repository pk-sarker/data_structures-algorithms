package com.practice;

/**
 * Given an array of sorted numbers, remove all duplicates from it.
 * You should not use any extra space; after removing the duplicates
 * in-place return the length of the subarray that has no duplicate in it.
 *
 * Input: [2, 3, 3, 3, 6, 9, 9]
 * Output: 4
 * Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].
 *
 * Input: [2, 2, 2, 11]
 * Output: 2
 * Explanation: The first two elements after removing the duplicates will be [2, 11].
 *
 * [1, 2, 3]
 */
public class RemoveDuplicates {

    public static int remove(int[] arr) {
        int left = 0, right = 1;
        if (arr.length == 1 || arr.length == 0) {
            return arr.length;
        }
        while(right < arr.length) {
            if (arr[left] != arr[right]) {
                if (right-left > 1) {
                    //swap
                    arr[left+1] = arr[right];
                }
                left++;
            }
            right++;
        }
        return left+1;
    }

    public static void main(String args[]) {
        int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
        System.out.println("\nInput: [2, 3, 3, 3, 6, 9, 9 ] \nOutput: "+RemoveDuplicates.remove(arr));

        arr = new int[] { 2, 2, 2, 11 };
        System.out.println("\nInput: [2, 2, 2, 11] \nOutput: "+RemoveDuplicates.remove(arr));

        System.out.println("\nInput: [0,0,1,1,1,2,2,3,3,4] \nOutput: "+RemoveDuplicates.remove(new int[]{0,0,1,1,1,2,2,3,3,4}));

        System.out.println("\nInput: [1, 2, 3, 4] \nOutput: "+RemoveDuplicates.remove(new int[]{1,2,3,4}));
    }
}
