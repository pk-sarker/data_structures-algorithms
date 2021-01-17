package com.ds.practice.Palindrome2;

/**
 * Given a non-empty string s, you may delete at most one character.
 * Judge whether you can make it a palindrome.
 *
 * Input: "bcb"
 * Output: true
 *
 * Input: "bcab"
 * Output: True
 * Explanation: You could delete the character 'a'.
 *
 */
public class Palindrome2 {

    public boolean isSubStringPalindrome(String s, int start, int end) {
        for(int i = start; i <= start+(end-start)/2;i++) {
            if (s.charAt(i) != s.charAt(end-i+start)) {
                return false;
            }
        }

        return true;
    }
    public boolean isPalindrome(String s) {
        int n = s.length();
        for(int i=0; i<n/2;i++) {
            if (s.charAt(i) != s.charAt(n-i-1)) {
                return isSubStringPalindrome(s, i+1, n-i-1) || isSubStringPalindrome(s, i, n-i-2);
            }
        }
        return true;
    }
    public static void main(String args[]) {
        Palindrome2 p = new Palindrome2();

        System.out.println("\nInput: abccba \nOutput:" + p.isPalindrome("abccba"));
        System.out.println("\nInput: abccaba \nOutput:" + p.isPalindrome("abccaba"));
        System.out.println("\nInput: abdccba \nOutput:" + p.isPalindrome("abdccba"));
    }
}
