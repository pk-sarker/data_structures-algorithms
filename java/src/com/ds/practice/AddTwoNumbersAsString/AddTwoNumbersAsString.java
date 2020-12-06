package com.ds.practice.AddTwoNumbersAsString;

public class AddTwoNumbersAsString {
    public String sum(String num1, String num2) {
        StringBuilder sum = new StringBuilder();
        int carry = 0;
        int n1 = num1.length()-1, n2 = num2.length()-1;
        while(n1 >= 0 || n2 >= 0) {
            int x = n1 >= 0 ? Character.getNumericValue(num1.charAt(n1)):0;
            int y = n2 >= 0 ? Character.getNumericValue(num2.charAt(n2)):0;
            int curSum = x + y + carry;
            int value = curSum % 10;
            carry = curSum / 10;
            sum.append(value);
            n1--;
            n2--;
        }

        if (carry != 0) {
            sum.append(carry);
        }
        return sum.reverse().toString();
    }

    public static void main(String args[]) {
        AddTwoNumbersAsString s = new AddTwoNumbersAsString();
        System.out.println("\nInput: 123 + 987 = 1110 \nOutput: " + s.sum("987", "123"));
        System.out.println("\nInput: 9 + 1 = 10 \nOutput: " + s.sum("9", "1"));
        System.out.println("\nInput: 1 + 0 = 1 \nOutput: " + s.sum("1", "0"));
    }
}
