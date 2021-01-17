package com.practice;

public class PairDivisionBy60 {

    public static int findPair(int[] nums) {
        int remainders[] = new int[60];
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]%60 == 0) {
                count += remainders[0];
            } else {
                count += remainders[60 - nums[i]%60];
            }
            remainders[nums[i]%60]++;
        }

        return count;
    }

    public static void main( String args[]) {

        System.out.println("\nInput: [30,20,150,100,40] \nOutput: " + PairDivisionBy60.findPair(new int[]{30,20,150,100,40}));
    }
}
