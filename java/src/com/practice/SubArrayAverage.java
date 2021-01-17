package com.practice;

import java.util.Arrays;

/**
 * Given an array, find the average of all contiguous subarrays of size ‘K’ in it.
 */
public class SubArrayAverage {
    public double[] average(int[] nums, int k) {
        int n = nums.length;
        double[] res = new double[n-k+1];
        double sum = 0;
        int j = 0;
        for(int i=0; i<n; i++) {
            sum += nums[i];

            if (i >= k-1) {
                res[j] = sum/k;
                j++;
                sum -= nums[i-k+1];
            }
        }
        return res;
    }

    public double maxAverage(int[] nums, int k) {
        int n = nums.length;
        double sum = 0;
        int j = 0;
        double max = 0d;
        for(int i=0; i<n; i++) {
            sum += nums[i];

            if (i >= k-1) {
                max = Math.max(sum/k,max);
                j++;
                sum -= nums[i-k+1];
            }
        }
        return max;
    }

    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double sum = 0;
        double maxSum = 0d;
        if (n==1) {
            return nums[0]/k;
        }
        for(int i=0; i<n; i++) {
            sum += nums[i];
            if (i >= k-1) {
                maxSum = Math.max(sum,maxSum);
                sum -= nums[i-k+1];
            } else {
                maxSum = Math.max(sum,maxSum);
            }

        }
        return maxSum/k;
    }
    public static void main(String args[]) {
        SubArrayAverage saa = new SubArrayAverage();
        double[] res = saa.average(new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2}, 5);
        System.out.println("Averages of subarrays of size K: " + Arrays.toString(res));

        System.out.println("Max Averages of subarrays of size K: " + saa.maxAverage(new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2}, 5));

        System.out.println("Max Averages of subarrays of size K: " + saa.findMaxAverage(new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2}, 5));

        System.out.println("Max Averages of subarrays of size K: " + saa.findMaxAverage(new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2}, 9));




    }
}
