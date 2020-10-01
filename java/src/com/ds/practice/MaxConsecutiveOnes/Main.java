package com.ds.practice.MaxConsecutiveOnes;

public class Main {
    public static void main(String args[]) {
        MaxConsecutiveOnes mco = new MaxConsecutiveOnes();


        System.out.println("Input: [1, 1, 0, 1, 1, 1, 0, 1, 1] \nOutput:" + mco.find(new int[]{1, 1, 0, 1, 1, 0, 1, 0, 1, 1}));

        System.out.println("Input: [0, 0] \nOutput:" + mco.findMaxConsecutiveOnesWithKChanges(new int[]{0, 0}, 1));
        System.out.println("Input: [0, 0, 0] \nOutput:" + mco.findMaxConsecutiveOnesWithKChanges(new int[]{0, 0, 0},1));
        System.out.println("Input: [0, 1, 0, 0, 1] \nOutput:" + mco.findMaxConsecutiveOnesWithKChanges(new int[]{0, 1, 0, 0, 1}, 1));
        System.out.println("Input: [1, 1, 0, 1, 1, 0, 1, 0, 1, 1] \nOutput:" + mco.findMaxConsecutiveOnesWithKChanges(new int[]{1, 1, 0, 1, 1, 0, 1, 0, 1, 1}, 1));
        System.out.println("Input: [1, 1, 0] \nOutput:" + mco.findMaxConsecutiveOnesWithKChanges(new int[]{1,1, 0}, 1));
        System.out.println("Input: [1, 1, 1] \nOutput:" + mco.findMaxConsecutiveOnesWithKChanges(new int[]{1,1, 1}, 1));
        System.out.println("Input: [0] \nOutput:" + mco.findMaxConsecutiveOnesWithKChanges(new int[]{0}, 1));
        System.out.println("Input: [1] \nOutput:" + mco.findMaxConsecutiveOnesWithKChanges(new int[]{1}, 1));

        System.out.println("-- -- -- -- Max consecutive Ones length with K changes at most -- -- -- -- -- ");

        System.out.println("Input: [0], K=2 \nOutput:" + mco.findMaxConsecutiveOnesWithKChanges(new int[]{0}, 2));
        System.out.println("Input: [0, 0], K=2 \nOutput:" + mco.findMaxConsecutiveOnesWithKChanges(new int[]{0, 0}, 2));
        System.out.println("Input: [0, 1, 0, 1], K=2 \nOutput:" + mco.findMaxConsecutiveOnesWithKChanges(new int[]{0, 1, 0, 1}, 2));
        System.out.println("Input: [0, 0, 0, 0, 0], K=2 \nOutput:" + mco.findMaxConsecutiveOnesWithKChanges(new int[]{0, 0, 0, 0, 0}, 2));
        System.out.println("Input: [0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 1], K=2 \nOutput:" + mco.findMaxConsecutiveOnesWithKChanges(new int[]{0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 1}, 2));

    }
}
