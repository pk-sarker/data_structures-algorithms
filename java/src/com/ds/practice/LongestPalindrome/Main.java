package com.ds.practice.LongestPalindrome;

public class Main {

    public static void main(String args[]) {
        LongestPalindromeBF lpBF = new LongestPalindromeBF();
        System.out.println(lpBF.getLongestPalindrome("babacb"));

        System.out.println(lpBF.getLongestPalindrome(""));
    }
}
