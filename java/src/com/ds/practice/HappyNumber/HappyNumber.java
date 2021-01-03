package com.ds.practice.HappyNumber;

import java.util.HashSet;

public class HappyNumber {
    public int nextNumber(int n) {
        int sum = 0;
        while(n>0) {
            int digit = n%10;
            sum += digit*digit;
            n = n/10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        while(n!=1 && !seen.contains(n)) {
            seen.add(n);
            n = nextNumber(n);
        }

        return n==1;
    }

    public static void main(String args[]) {
        HappyNumber  hn = new HappyNumber();
        System.out.println("\nInput: n=19 \nOutput: "+hn.isHappy(19));
        System.out.println("\nInput: n=123 \nOutput: "+hn.isHappy(123));
    }
}
