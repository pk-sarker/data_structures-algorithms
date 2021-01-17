package com.practice;

import java.util.Arrays;

/**
 * Given an array nums with n objects colored red, white, or blue,
 * sort them in-place so that objects of the same color are adjacent,
 * with the colors in the order red, white, and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the
 * color red, white, and blue respectively.
 *
 * Could you solve this problem without using the library's sort function?
 * Could you come up with a one-pass algorithm using only O(1) constant space?
 */
public class Sort3ColorInPlace {

    public static void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1;
        int idx = 0;
        while(idx <= high) {
            if (nums[idx] == 0) {
                swap(nums, idx, low);
                low++;
                idx++;
            } else if (nums[idx] == 2) {
                swap(nums, idx, high);
                high--;
            } else {
                idx++;
            }
        }

    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String args[]) {
        int[] nums1 = new int[]{1, 2, 0, 2, 1, 0, 1, 0};
        Sort3ColorInPlace.sortColors(nums1);
        System.out.println("\nInput: [1, 2, 0, 2, 1, 0, 1, 0] \nOutput: " + Arrays.toString(nums1));

        int[] nums2 = new int[]{2, 2, 0, 1, 2, 0 };
        Sort3ColorInPlace.sortColors(nums2);
        System.out.println("\nInput: [2, 2, 0, 1, 2, 0] \nOutput: " + Arrays.toString(nums2));

        int[] nums3 = new int[]{2, 2, 0, 2, 2, 0 };
        Sort3ColorInPlace.sortColors(nums3);
        System.out.println("\nInput: [2, 2, 0, 1, 2, 0] \nOutput: " + Arrays.toString(nums3));
    }
}
