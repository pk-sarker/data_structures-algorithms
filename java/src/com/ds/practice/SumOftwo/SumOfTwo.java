package com.ds.practice.SumOftwo;
import java.util.Map;
import java.util.HashMap;

public class SumOfTwo {
    public int[] find(int[] numbers, int target) {
        Map <Integer, Integer> hash = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int diff = target - numbers[i];
            if (hash.containsKey(diff)) {
                result[0] = hash.get(diff);
                result[1] = i;
                break;
            }

            hash.put(numbers[i], i);
        }
        return result;
    }

    public static void main(String args[]) {
        SumOfTwo s = new SumOfTwo();
        int[] result = s.find(new int[]{2,7,5,4,9}, 12);
        for(int i =0; i<result.length; i++) {
            System.out.print(""+result[i]+", ");
        }
    }
}
