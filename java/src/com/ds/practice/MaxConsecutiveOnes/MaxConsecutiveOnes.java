package com.ds.practice.MaxConsecutiveOnes;

public class MaxConsecutiveOnes {
    public int find(int[] nums) {
        if (nums.length<=0) {
            return 0;
        }
        int seq = 0;
        int  max = 0;
        for(int i=0;i<nums.length;i++) {
            if (nums[i] == 1) {
                seq++;
                max = Math.max(seq, max);
            } else {
                seq = 0;
            }
        }
        return max;
    }
    // k 2
    // 1,0,0,1,0,1,1
    public int findMaxConsecutiveOnesWithKChanges(int[] nums, int k) {
        int start, end;
        for(start = 0, end = 0; end < nums.length; end++) {
            if (nums[end]==0) {
                k--;
            }
            if (k<0) {
                if (nums[start]==0) {
                    k++;
                }
                start++;
            }
        }

        return end-start;
    }
}
