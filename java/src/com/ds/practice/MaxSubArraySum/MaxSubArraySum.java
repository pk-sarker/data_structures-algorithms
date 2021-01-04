package com.ds.practice.MaxSubArraySum;

public class MaxSubArraySum {

    public int maxSumGreedy(int[] nums) {
        int n = nums.length, maxSum = 0;
        if (n<=0) {
            return maxSum;
        }
        if (n==1) {
            return nums[0];
        }
        int currentSum = nums[0];
        maxSum = nums[0];
        for(int i=1; i<n; i++) {
            // Reset the sum to current element if sum of the
            // previous elements are less than the current element
            currentSum = Math.max(nums[i], currentSum+nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static void main(String args[]) {
        MaxSubArraySum msam = new MaxSubArraySum();
        System.out.println("\nInput: [-2,1,-3,4,-1,2,1,-5,4]");
        System.out.println("Output: " + msam.maxSumGreedy(new int[]{-2,1,-3,4,-1,2,1,-5,4}));

        System.out.println("\nInput: [-2,-7,-3,-4,-6,-2,0,-3,-5,-4]");
        System.out.println("Output: " + msam.maxSumGreedy(new int[]{-2,-7,0,-3,-4,-6,-2,-3,-5,-4}));
    }
}
