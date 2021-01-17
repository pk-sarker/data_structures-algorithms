package com.practice;

public class HappyNumber {
    public static boolean isHappy(int num) {
        int slow = squareSum(num);
        int fast = squareSum(squareSum(num));
        while(slow != fast) {
            slow = squareSum(slow);
            fast = squareSum(squareSum(fast));
        }
        return slow == 1;
    }

    public static int squareSum(int num) {
        int sum = 0;
        while(num > 0) {
            int digit = num % 10;
            sum += digit*digit;
            num = num / 10;
        }
        return sum;
    }
    public static void main(String args[]) {
        System.out.println("\nInput: 23 \nOutput: " + HappyNumber.isHappy(23));
        System.out.println("\nInput: 12 \nOutput: " + HappyNumber.isHappy(12));
        System.out.println("\nInput: 19 \nOutput: " + HappyNumber.isHappy(19));
    }
}
