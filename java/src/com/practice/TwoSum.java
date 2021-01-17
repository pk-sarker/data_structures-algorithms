package com.practice;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 */
public class TwoSum {
    // unsorted array
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        int[] res = new int[2];
        for(int i=0; i<nums.length;i++) {
            int rem = target - nums[i];
            if (hash.containsKey(rem)) {
                res[0] = hash.get(rem);
                res[1] = i;
                return res;
            }
            hash.put(nums[i], i);
        }
        return res;
    }

    // sorted array
    public static int[] twoSumSorted(int[] nums, int target) {
        int n = nums.length;
        int[] res = new int[2];
        int left = 0, right = n-1;

        int sum = 0;
        while(left < right) {
            sum = nums[left] + nums[right];
            if (sum==target) {
                res[0] = left;
                res[1] = right;
                break;
            }
            if (sum>target) {
                right--;
            } else {
                left++;
            }
        }

        return res;
    }

    public static void main(String args[]) {
        TwoSum ts = new TwoSum();

        int[] res = ts.twoSum(new int[]{2,7,11,15}, 9);
        System.out.println(res[0] + ", "+res[1]);

        int[] res2 = ts.twoSum(new int[]{2,7,11,15, 5, -4}, 3);
        System.out.println(res2[0] + ", "+res2[1]);

        System.out.println("\nInput: [-4,2,5,7,11,15], t=3 \nOutput: " + Arrays.toString(TwoSum.twoSumSorted(new int[]{-4,2,5,7,11,15}, 3)));
        System.out.println("\nInput: [-4,2,5,7,11,15], t=11 \nOutput: " + Arrays.toString(TwoSum.twoSumSorted(new int[]{-4,2,5,7,11,15}, 11)));


    }
}
