package com.practice;

import java.util.HashMap;

/**
 * Longest Substring with K Distinct Characters
 *
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 *
 * Input: String="araaci", K=2
 * Output: 4
 * Explanation: The longest substring with no more than '2' distinct characters is "araa".
 *
 * Input: String="araaci", K=1
 * Output: 2
 * Explanation: The longest substring with no more than '1' distinct characters is "aa".
 *
 * Input: String="cbbebi", K=3
 * Output: 5
 * Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".
 */
public class LongestSubstringKDistinct {

    public static int findLength(String str, int k) {
        if (str == null || str.length() == 0 || str.length() < k) {
            throw new IllegalArgumentException();
        }
        int start = 0, maxLen = 0;

        HashMap<Character, Integer> charFrequencyMap = new HashMap<>();
        for (int end =0; end < str.length(); end++) {
            char rightChar = str.charAt(end);
            charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0)+1);

            while(charFrequencyMap.size()>k) {
                char leftChar = str.charAt(start);
                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar)-1);
                if (charFrequencyMap.get(leftChar) == 0) {
                    charFrequencyMap.remove(leftChar);
                }
                start++; // shring window
            }
            maxLen = Math.max(maxLen, end-start+1);
        }
        return maxLen;
    }


    public static int findLength2(String str, int k) {
        if (str == null || str.length() == 0 || str.length() < k) {
            throw new IllegalArgumentException();
        }
        int start = 0, maxLen = Integer.MIN_VALUE;
        int n = str.length();
        HashMap<Character, Integer> charOccurenceHash = new HashMap<>();

        for(int end=0; end < n; end++ ) {
            char rightChar = str.charAt(end);
            charOccurenceHash.put(rightChar, charOccurenceHash.getOrDefault(rightChar, 0) + 1);

            while(charOccurenceHash.size()>k) {
                char leftChar = str.charAt(start);
                charOccurenceHash.put(leftChar, charOccurenceHash.get(leftChar)-1);
                if (charOccurenceHash.get(leftChar)==0) {
                    charOccurenceHash.remove(leftChar);
                }
                start++;
            }
            maxLen = Math.max(maxLen, end-start+1);
        }
        return maxLen;
    }

    public static void main(String args[]) {
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));

        System.out.println("\n\nLength of the longest substring: " + LongestSubstringKDistinct.findLength2("araaci", 2));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength2("araaci", 1));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength2("cbbebi", 3));
    }
}
