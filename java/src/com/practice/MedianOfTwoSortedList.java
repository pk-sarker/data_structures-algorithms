package com.practice;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively,
 * return the median of the two sorted arrays.
 *
 * Follow up: The overall run time complexity should be O(log (m+n)).
 *
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 *
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 *
 * Input: nums1 = [], nums2 = [1]
 * Output: 1.00000
 *
 */
public class MedianOfTwoSortedList {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;

        // m <= n
        if (m> n) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int t = m;
            m = n;
            n = t;
        }

        int imin = 0, imax = m, half = (m+n+1)/2;

        while(imin <= imax) {
            int i = (imin+imax)/2;
            int j = half - i;

            if (i < imax && nums2[j-1] > nums1[i]) {
                imin = i + 1;
            } else if (i > imin && nums1[i-1]>nums2[j]) {
                imax = i-1;
            } else {
                int leftMax = 0;
                if (i==0) {
                    leftMax = nums2[j-1];
                } else if(j==0) {
                    leftMax = nums1[i-1];
                } else {
                    leftMax = Math.max(nums1[i-1], nums2[j-1]);
                }
                if ((m+n)%2 == 1) {
                    return leftMax;
                }
                int rightMin = 0;
                if (i==m) {
                    rightMin = nums2[j];
                } else if (j==n) {
                    rightMin = nums1[i];
                } else {
                    rightMin = Math.min(nums1[i], nums2[j]);
                }

                return (leftMax+rightMin)/2.0;
            }
        }
        return 0.0;
    }

    public static void main(String args[]) {
        System.out.println("\nInput: [1,2], [3,4] \nMedian: " +
                MedianOfTwoSortedList.findMedianSortedArrays(new int[]{1, 2}, new int[]{3,4}));
    }
}
