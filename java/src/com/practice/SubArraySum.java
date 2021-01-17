package com.practice;

/**
 * Given an array of positive numbers and a positive number ‘k,’
 * find the maximum sum of any contiguous subarray of size ‘k’.
 *
 * Input: [2, 1, 5, 1, 3, 2], k=3
 * Output: 9
 * Explanation: Subarray with maximum sum is [5, 1, 3].
 *
 * Input: [2, 3, 4, 1, 5], k=2
 * Output: 7
 * Explanation: Subarray with maximum sum is [3, 4].
 */
public class SubArraySum {

    public static int findMaxSumSubArray(int k, int[] nums) {
        int n = nums.length;
        int sum = 0;
        int maxSum = 0;
        for(int i=0; i<n; i++) {
            sum += nums[i];
            if (i >= k-1) {
                maxSum = Math.max(maxSum, sum);
                sum -= nums[i-k+1];
            }
        }
        return maxSum;
    }

    public static int findMaxSumSubArray2(int k, int[] nums) {
        int sum =0, maxSum = 0;

        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            if (i < k) {
                maxSum = sum;
            } else {
                sum -= nums[i-k];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
    public static void main(String args[]) {
        System.out.println("Maximum sum of a subarray of size K: "
                + SubArraySum.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
        System.out.println("Maximum sum of a subarray of size K: "
                + SubArraySum.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));

        System.out.println("> Maximum sum of a subarray of size K: "
                + SubArraySum.findMaxSumSubArray2(3, new int[] { 2, 1, 5, 1, 3, 2 }));
        System.out.println("> Maximum sum of a subarray of size K: "
                + SubArraySum.findMaxSumSubArray2(2, new int[] { 2, 3, 4, 1, 5 }));
    }
}
