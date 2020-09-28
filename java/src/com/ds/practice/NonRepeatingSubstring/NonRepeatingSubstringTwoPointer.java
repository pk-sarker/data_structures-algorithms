package com.ds.practice.NonRepeatingSubstring;
import java.util.HashSet;
import java.util.Set;

public class NonRepeatingSubstringTwoPointer {
    public int getNonRepeatingSubstring(String str) {
        int n = str.length();
        if (n <= 1) {
            return n;
        }

        int start = 0;
        int end = 0;
        int maxLen = 0;
        Set<Character> seen = new HashSet<>();

        while(start < n && end < n) {

            if (!seen.contains(str.charAt(end))) {
                seen.add(str.charAt(end++));
                maxLen = Math.max(maxLen, end-start);
            } else {
                seen.remove(str.charAt(start));
                start++;
            }
        }
        return maxLen;
    }
}
