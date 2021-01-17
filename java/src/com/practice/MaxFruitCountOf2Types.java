package com.practice;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Given an array of characters where each character represents a fruit tree,
 * you are given two baskets, and your goal is to put maximum number of fruits
 * in each basket. The only restriction is that each basket can have only one type
 * of fruit.
 *
 * You can start with any tree, but you can’t skip a tree once you have started.
 * You will pick one fruit from each tree until you cannot, i.e., you will stop when
 * you have to pick from a third fruit type.
 *
 * Write a function to return the maximum number of fruits in both the baskets.
 *
 * Input: Fruit=['A', 'B', 'C', 'A', 'C']
 * Output: 3
 * Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
 *
 * Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
 * Output: 5
 * Explanation: We can put 3 'B' in one basket and two 'C' in the other basket.
 * This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']
 *
 */
public class MaxFruitCountOf2Types {

    public static int findLength(char[] arr) {
        int start = 0, maxLen = Integer.MIN_VALUE;

        HashSet<Character> charSet = new HashSet<>();

        for(int end=0; end<arr.length; end++) {
            charSet.add(arr[end]);
            while (charSet.size()>2) {
                charSet.remove(arr[start]);
                start++;
            }
            maxLen = Math.max(maxLen, end-start+1);
        }


        return maxLen == Integer.MIN_VALUE ? 0:maxLen;
    }

    public static int totalFruit(int[] arr) {
        int start = 0, maxLen = Integer.MIN_VALUE;

        //HashSet<Integer> charSet = new HashSet<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int end=0; end<arr.length; end++) {
            hashMap.put(arr[end], hashMap.getOrDefault(arr[end], 0) + 1);
            while (hashMap.size()>2) {
                int leftNum = arr[start];
                hashMap.put(leftNum, hashMap.get(leftNum)-1);
                if (hashMap.get(leftNum) == 0) {
                    hashMap.remove(leftNum);
                }
                start++;
            }
            maxLen = Math.max(maxLen, end-start+1);
            System.out.println("s: "+start+" en:"+end+ " set: "+hashMap.size() +" max:"+maxLen);
        }

        return maxLen == Integer.MIN_VALUE ? 0:maxLen;
    }

    public static void main(String args[]) {
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));

        System.out.println(">> Maximum number of fruits: " +
                MaxFruitCountOf2Types.totalFruit(new int[] { 3,3,3,1,2,1,1,2,3,3,4 }));

    }
}
