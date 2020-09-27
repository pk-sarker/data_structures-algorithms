package com.ds.practice.LongestPalindrome;

public class Main {

    public static void main(String args[]) {
        LongestPalindromeBF lpBF = new LongestPalindromeBF();
        System.out.println("Longest Palindrome: " + lpBF.getLongestPalindrome("babacb"));
        System.out.println("Longest Palindrome: " + lpBF.getLongestPalindrome("abbaabbcb"));
        LongestPalindromeDP lpDP = new LongestPalindromeDP();
        System.out.println("Longest Palindrome: " + lpDP.getLongestPalindrome("babacb"));
        System.out.println("Longest Palindrome: " + lpDP.getLongestPalindrome("abbaabbcb"));

        System.out.println("Longest Palindrome: " +lpDP.getLongestPalindrome("cbbd"));
        System.out.println(lpDP.getLongestPalindrome(""));



        // "cbbd"
    }
}
