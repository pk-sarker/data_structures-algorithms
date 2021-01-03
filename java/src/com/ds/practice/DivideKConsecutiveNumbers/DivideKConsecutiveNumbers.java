package com.ds.practice.DivideKConsecutiveNumbers;

import java.util.TreeMap;

public class DivideKConsecutiveNumbers {

    public boolean isNStraightHand(int[] nums, int k) {
        TreeMap<Integer, Integer> count = new TreeMap<>();

        for(int num: nums) {
            count.put(num, count.getOrDefault(num, 0)+1);
        }

        while(!count.isEmpty()) {
            int base = count.firstKey();
            for(int i = base; i < base + k; i++) {
                if(!count.containsKey(i)) {
                    return false; // there are no consecutive numbers of k elements
                }
                int c = count.get(i);
                if (c == 1) {
                    count.remove(i);
                } else {
                    count.replace(i, c-1);
                }
            }
        }
        return true;

    }

    public static void main(String args[]) {
        /**
         * [1,1,2,2,3,3]
         * [1,2,3,6,2,3,4,7,8], W = 3
         * Sort: [1,2,2,3,3,4,6,7,8]
         * n = 9
         * m = n % 3 = 0
         *
         * if m == 0:  then there are enough numbers to device in k consecutive numbers
         *  otherwise return false;
         *
         *  groups = n/3 = 3
         *  [1,2,2,3,3,4,6,7,8]
         *
         *  min heap
         *  push the elements in min heap
         *
         *  the pull a one by one upto 3 numbers
         *      if difference between last and current is not 1 then return false
         *
         *
         */
        DivideKConsecutiveNumbers dk = new DivideKConsecutiveNumbers();
        System.out.println("\nInput: [1,2,3,6,2,3,4,7,8] k = 3  \nOutput: "+dk.isNStraightHand(new int[]{1,2,3,6,2,3,4,7,8}, 3));
        System.out.println("\nInput: [1,2,3,6,2,3,4,7,8] k = 2  \nOutput: "+dk.isNStraightHand(new int[]{1,2,3,6,2,3,4,7,8}, 2));


        System.out.println("\nInput: [1,2,3,6,2,3,4,7,8] k = 3  \nOutput: "+dk.isNStraightHand(new int[]{1,2,3,8,6,2,3,6,7}, 3));
    }
}
