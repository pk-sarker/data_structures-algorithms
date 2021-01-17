package com.practice;

/**
 * Given a palindromic string palindrome, replace exactly one character by any
 * lowercase English letter so that the string becomes the lexicographically smallest
 * possible string that isn't a palindrome.
 *
 * After doing so, return the final string.  If there is no way to do so, return the empty string.
 *
 * Example 1:
 * Input: palindrome = "abccba"
 * Output: "aaccba"
 * Example 2:
 *
 * Input: palindrome = "a"
 * Output: ""
 */
public class BreakAPalindrome {

    public static String breakPalindrome(String palindrome) {
        if (palindrome == null || palindrome.length() <=1) {
            return "";
        }
        char[] chars = palindrome.toCharArray();
        int mid = chars.length / 2 - 1;
        for(int i=0; i<=mid; i++) {
            if(chars[i] != 'a') {
                chars[i] = 'a';
                return new String(chars);
            }
            if (i==mid) {
                chars[chars.length-1] = 'b';
                return new String(chars);
            }
        }
        return "";
    }

    public static void main(String args[]) {
        System.out.println("\nInput: \"abccba\" \nOutput: " + BreakAPalindrome.breakPalindrome("abccba"));
        System.out.println("\nInput: \"aaaa\" \nOutput: " + BreakAPalindrome.breakPalindrome("aaaa"));
        System.out.println("\nInput: \"cc\" \nOutput: " + BreakAPalindrome.breakPalindrome("cc"));
        System.out.println("\nInput: \"d\" \nOutput: " + BreakAPalindrome.breakPalindrome("d"));
    }
}
