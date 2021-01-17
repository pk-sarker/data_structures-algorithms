package com.practice;

import java.util.HashMap;

/**
 * Given a string and a pattern, find the smallest substring in
 * the given string which has all the characters of the given pattern.
 *
 * Input: String="aabdec", Pattern="abc"
 * Output: "abdec"
 * Explanation: The smallest substring having all characters of the pattern is "abdec"
 *
 * Input: String="abdbca", Pattern="abc"
 * Output: "bca"
 * Explanation: The smallest substring having all characters of the pattern is "bca".
 *
 * Input: String="adcad", Pattern="abc"
 * Output: ""
 * Explanation: No substring in the given string has all characters of the pattern.
 */
public class MinimumWindowSubstring {

    public static String findSubstring1(String str, String pattern) {
        StringBuilder sb = new StringBuilder();
        int minLen = Integer.MAX_VALUE;
        int[] patternMap = new int[26];
        int[] strMap = new int[26];
        int n= str.length(), pn = pattern.length();

        for(int i =0; i<pn; i++) {
            patternMap[pattern.charAt(i)-'a']++;
            strMap[str.charAt(i)-'a']++;
        }
        int start = 0;

        for(int j=0; j<n-pn; j++) {
            if(match(patternMap, strMap)) {
                // resultIndices.add(j);
                minLen = Math.min(minLen, j+pn-start);
                start++;
            }
            strMap[str.charAt(j+pn)-'a']++;
            strMap[str.charAt(j)-'a']--;
        }

        return sb.toString();
    }

    public static boolean match(int[] ar1, int[] ar2){
        for(int i=0; i<26; i++) {
            if (ar1[i]>0 && ar1[i]!=ar2[i]) {
                return false;
            }
        }
        return true;
    }

    public static String findSubstring(String str, String pattern) {
        int n = str.length(), pn = pattern.length();
        if (n==0 || pn ==0 || pn>n) {
            return "";
        }
        // character count in the pattern
        HashMap<Character, Integer> patternMap = new HashMap<>();
        for(int i=0; i<pn; i++) {
            char c = pattern.charAt(i);
            patternMap.put(c, patternMap.getOrDefault(c,0)+1);
        }
        int required = patternMap.size();

        HashMap<Character, Integer> windowMap = new HashMap<>();

        int left = 0, right = 0, formed = 0;

        // window length, left & right
        int[] res = new int[]{-1, 0, 0};

        while(right<n) {
            char rc = str.charAt(right);
            windowMap.put(rc, windowMap.getOrDefault(rc, 0)+1);

            // check how many formed
            if (patternMap.containsKey(rc) && patternMap.get(rc).intValue() == windowMap.get(rc).intValue()) {
                formed++;
            }

            while (left <= right && required == formed) {
                // shrink window
                char lc = str.charAt(left);
                if (res[0] == -1 || right - left + 1 < res[0]) {
                    res[0] = right - left + 1;
                    res[1] = left;
                    res[2] = right;
                }
                // remove from window count
                windowMap.put(lc, windowMap.get(lc)-1);

                // check if left char contribute to formation
                if (patternMap.containsKey(lc) && windowMap.get(lc) < patternMap.get(lc)) {
                    formed--;
                }
                left++;
            }
            right++;
        }
        return res[0] == -1 ? "": str.substring(res[1], res[2]+1);
    }

    public static void main(String args[]) {
//        System.out.println(MinimumWindowSubstring.findSubstring1("aabdec", "abc"));
//        System.out.println(MinimumWindowSubstring.findSubstring1("abdbca", "abc"));
//        System.out.println(MinimumWindowSubstring.findSubstring1("adcad", "abc"));


        // System.out.println(MinimumWindowSubstring.findSubstring("aabdec", "abc"));

        System.out.println(MinimumWindowSubstring.findSubstring("ADOBECODEBANC", "ABC"));

    }
}
