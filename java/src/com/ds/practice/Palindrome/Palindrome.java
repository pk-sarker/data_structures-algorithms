package com.ds.practice.Palindrome;

public class Palindrome {

    public boolean check(String str) {
        System.out.println("Input: " + str);
        int n = str.length();
        for (int i = 0; i <  n; i++) {
            if (str.charAt(i) != str.charAt(n-1-i)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String input = "abcdjdcba";
        Palindrome pl = new Palindrome();
        System.out.println("Output: " + pl.check(input));
    }
}
