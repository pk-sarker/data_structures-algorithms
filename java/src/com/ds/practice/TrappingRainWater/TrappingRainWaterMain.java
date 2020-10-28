package com.ds.practice.TrappingRainWater;

public class TrappingRainWaterMain {

    public static void main(String args[]) {
        TrappingRainWater trw = new TrappingRainWater();
        int[] input1 = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(">> Brute Force <<");
        System.out.println("Input: [0,1,0,2,1,0,1,3,2,1,2,1]");
        System.out.println("Output: " +  trw.bruteForce(input1));

        System.out.println("\n>> Dynamic Programming <<");
        System.out.println("Input: [0,1,0,2,1,0,1,3,2,1,2,1]");
        System.out.println("Output: " +  trw.dp(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println("Input: [4,2,0,3,2,5]");
        System.out.println("Output: " +  trw.dp(new int[]{4,2,0,3,2,5}));

        System.out.println("\n>> Two Pointer <<");
        System.out.println("Input: [0,1,0,2,1,0,1,3,2,1,2,1]");
        System.out.println("Output: " +  trw.twoPointer(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println("Input: [4,2,0,3,2,5]");
        System.out.println("Output: " +  trw.twoPointer(new int[]{4,2,0,3,2,5}));
        System.out.println("Input: [0,1,2,3,2,1,0]");
        System.out.println("Output: " +  trw.twoPointer(new int[]{0,1,2,3,2,1,0}));
        System.out.println("Input: [3,2,1,0]");
        System.out.println("Output: " +  trw.twoPointer(new int[]{3,2,1,0}));
        System.out.println("Input: [0,1,2,3]");
        System.out.println("Output: " +  trw.twoPointer(new int[]{0,1,2,3}));
        System.out.println("Input: [3,2,1,0,1,2,3]");
        System.out.println("Output: " +  trw.twoPointer(new int[]{3,2,1,0,1,2,3}));
    }
}
