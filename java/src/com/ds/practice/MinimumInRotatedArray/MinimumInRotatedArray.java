package com.ds.practice.MinimumInRotatedArray;

public class MinimumInRotatedArray {

    public int findMinimum(int[] nums) {
        if (nums.length<=0) {
            return -1;
        }
        if (nums.length==1) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;

        // if not rotated array
        if (nums[left] < nums[right]) {
            return nums[0];
        }

        int mid = (right - left) /2;

        while(right >= left) {
            mid = left + (right - left)/2;

            if (nums[mid] > nums[mid+1]) {
                return nums[mid+1];
            }
            if (nums[mid-1]>nums[mid]) {
                return nums[mid];
            }

            if (nums[mid] > nums[0]) {
                left = mid+1;
            } else {
                right = mid-1;
            }

        }
        return -1;
    }
    public static void main(String args[]) {
        int[] nums = new int[]{4, 5, 6, 7, 9, 0, 1, 2, 3};
        System.out.println("\nInput: [4, 5, 6, 7, 9, 0, 1, 2, 3]");
        MinimumInRotatedArray sra = new MinimumInRotatedArray();
        System.out.println("Output: " + sra.findMinimum(nums));


        System.out.println("\nInput: [1, 2, 3, 4, 5, 6]");
        System.out.println("Output: " + sra.findMinimum(new int[]{1, 2, 3, 4, 5, 6}));
    }
}
