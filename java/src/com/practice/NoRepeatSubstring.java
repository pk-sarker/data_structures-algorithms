package com.practice;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Given a string, find the length of the longest substring, which has no repeating characters.
 *
 * Input: String="aabccbb"
 * Output: 3
 * Explanation: The longest substring without any repeating characters is "abc".
 *
 * Input: String="abbbb"
 * Output: 2
 * Explanation: The longest substring without any repeating characters is "ab".
 *
 * Input: String="abccde"
 * Output: 3
 * Explanation: Longest substrings without any repeating characters are "abc" & "cde".
 */
public class NoRepeatSubstring {

    public static int findLength(String str) {
        if (str == null || str.length() ==0) {
            return 0;
        }

        HashMap<Character, Integer> charLastPos = new HashMap<>();
        HashSet<Character> charSet = new HashSet<>();

        int start = 0, n = str.length(), maxLen=Integer.MIN_VALUE;
        for(int end=0; end<n; end++) {
            char c = str.charAt(end);

            if (charSet.contains(c) && charLastPos.get(c) > start) {
                start = charLastPos.get(c)+1;
                //charLastPos.put(c, end);
            } else {
                charSet.add(c);
                maxLen = Math.max(maxLen, end-start+1);
            }
            charLastPos.put(c, end);
        }

        return maxLen == Integer.MIN_VALUE ? 0: maxLen;
    }


    public static int findLength2(String str) {
        if (str == null || str.length() ==0) {
            return 0;
        }

        HashMap<Character, Integer> charLastPos = new HashMap<>();

        int start = 0, n = str.length(), maxLen=Integer.MIN_VALUE;
        for(int end=0; end<n; end++) {
            char c = str.charAt(end);
            if (charLastPos.containsKey(c)) {
                start = Math.max(start, charLastPos.get(c)+1);
            }
            charLastPos.put(c, end);
            maxLen = Math.max(maxLen, end-start+1);
        }

        return maxLen == Integer.MIN_VALUE ? 0: maxLen;
    }

    public static void main(String args[]) {
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabccbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));

        System.out.println("Input: tmmzuxt, Length of the longest substring: " + NoRepeatSubstring.findLength2("tmmzuxt"));
    }
}
