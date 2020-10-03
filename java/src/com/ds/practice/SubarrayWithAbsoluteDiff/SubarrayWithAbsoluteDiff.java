package com.ds.practice.SubarrayWithAbsoluteDiff;
import java.util.Map;
import java.util.HashMap;

public class SubarrayWithAbsoluteDiff {

    public int longestSubarray(int[] nums, int limit) {
        int maxLen = 0;
        if (nums.length<=1) {
            return nums.length;
        }
        int n = nums.length;

        int start = 0;
        int end = 0;
        int maxInWindow = nums[start];
        int minInWindow = nums[end];
        Map<Integer, Integer> hash = new HashMap<>();

        while (start <n && end <n) {
            hash.put(nums[end], end);
            if (nums[end] < minInWindow) {
                minInWindow = nums[end];
            }
            if (nums[end] > maxInWindow) {
                maxInWindow = nums[end];
            }
            if (Math.abs(maxInWindow-minInWindow) <= limit) {
                maxLen = Math.max(maxLen, end - start + 1 );
            } else {
                if (maxInWindow == nums[end]) {
                    start = hash.get(minInWindow) + 1;
                    minInWindow = nums[start];
                    for(int j=start; j<=end;j++) {
                        if (nums[j]< minInWindow) {
                            minInWindow = nums[j];
                        }
                        if (nums[j]> maxInWindow) {
                            maxInWindow = nums[j];
                        }
                    }
                } else {

                    start = hash.get(maxInWindow) + 1;
                    maxInWindow = nums[start];
                    for(int j=start; j<=end;j++) {
                        if (nums[j]>maxInWindow) {
                            maxInWindow = nums[j];
                        }
                        if (nums[j]< minInWindow) {
                            minInWindow = nums[j];
                        }
                    }
                }
            }
            end++;
        }
        return maxLen;
    }
    public static void main(String args[]) {
        SubarrayWithAbsoluteDiff sa = new SubarrayWithAbsoluteDiff();
        System.out.println("Input: [8,2,4,5,7]\nOutput: "+sa.longestSubarray(new int[]{8,2,4,5,7}, 4));

        System.out.println("Input: [] Max diff: 0\nOutput: "+sa.longestSubarray(new int[]{}, 0));
        System.out.println("Input: [0] Max diff: 0\nOutput: "+sa.longestSubarray(new int[]{0},0));
        System.out.println("Input: [0,0] Max diff: 0\nOutput: "+sa.longestSubarray(new int[]{0,0},0));
        System.out.println("Input: [0,1] Max diff: 0\nOutput: "+sa.longestSubarray(new int[]{0,1},0));
        System.out.println("Input: [0,1] Max diff: 1\nOutput: "+sa.longestSubarray(new int[]{0,1},1));
        System.out.println("Input: [1,0] Max diff: 1\nOutput: "+sa.longestSubarray(new int[]{1,0},1));
        System.out.println("Input: [1,1] Max diff: 1\nOutput: "+sa.longestSubarray(new int[]{1,1},1));
        System.out.println("Input: [1,0,-1,1] Max diff: 1\nOutput: "+sa.longestSubarray(new int[]{1,0,-1,1},1));
        System.out.println("Input: [1,0,-1,2] Max diff: 1\nOutput: "+sa.longestSubarray(new int[]{1,0,-1,2},1));
        System.out.println("Input: [-2,-1,2,2] Max diff: 1\nOutput: "+sa.longestSubarray(new int[]{-2,-1,2,1},1));
        System.out.println("Input: [8,1,0,4,5,6,2]\nOutput: "+sa.longestSubarray(new int[]{8,1,0,4,5,7,3}, 4));

        System.out.println("Input: [4,2,2,2,4,4,2,2] Max diff: 1\nOutput: "+sa.longestSubarray(new int[]{4,2,2,2,4,4,2,2},0));

        System.out.println("Input: [] Max diff: 55\nOutput: "+sa.longestSubarray(new int[]{18,100,79,85,88,90,11,57,31,49,56,51,22,42,57,17,80,63,28,16,56,77,69,53,16,85,38,36,32,49,96,72,1,25,68,57,75,3,4,81,78,32,34,27,23,37,19,70,26,35,40,75,97,33,88,58,22,70,46,63,54,16,99,27,74,50,27,37,14,4,16,73,96,2,70,38,87,98,93,84,18,10,65,48,74,40,56,65,87,46,98,68,42,1,16,57,92},55));

        System.out.println("Input: [1,3,4,10,8,9] 2 \nOutput: "+sa.longestSubarray(new int[]{1,3,4,10,8,9}, 2));
    }
}
