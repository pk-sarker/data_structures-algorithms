package com.ds.practice.LongestNonRepeatingSubstring;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class NonRepeatingSubstring {

    public int findLengthOfLongestNonRepeatingSubstring(String s) {
        int maxLen = 0;
        int start = 0;
        int end = 0;
        int n = s.length();
        if (s.length()<=1) {
            return n;
        }

        Set<Character> seen = new HashSet<>();

        while (start < n && end < n) {
            if (!seen.contains(s.charAt(end))) {
                seen.add(s.charAt(end));
                end = end+1;
                if (end-start > maxLen) {
                    maxLen = end-start;
                }
            } else {
                seen.remove(s.charAt(end));
                start = start + 1;
            }
        }
        return maxLen;
    }


    public int findLengthOfLongestNonRepeatingSubstringOptimized(String s) {
        int maxLen = 0;
        int n = s.length();
        if (s.length()<=1) {
            return n;
        }

        Map<Character, Integer> hash = new HashMap<>();

        for(int start=0, end = 0; end<n; end++) {
            if (hash.containsKey(s.charAt(end))) {
                start = Math.max(hash.get(s.charAt(end)), start);
            }
            maxLen = Math.max(maxLen, end-start+1);
            hash.put(s.charAt(end), end+1);
        }
        return maxLen;
    }

    public static void main(String args[]) {
        NonRepeatingSubstring nrs = new NonRepeatingSubstring();

        int result = nrs.findLengthOfLongestNonRepeatingSubstring("AABCBDCAEDBF");
        System.out.println("Input: AABCBDCAEDBF\nOutput:"+result);

        System.out.println("Input: AABCBDCAEDBF\nOutput:"+nrs.findLengthOfLongestNonRepeatingSubstringOptimized("AABCBDCAEDBF"));

    }
}
