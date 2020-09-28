package com.ds.practice.NonRepeatingSubstring;

import java.util.HashMap;
import java.util.Map;

public class NonRepeatingSubstringTwoPointerOptimized {

    public int getNonRepeatingSubstring(String s) {
        if (s == null) {
            return 0;
        }
        int n = s.length();
        if (n <= 1) {
            return n;
        }
        int result = 0;
        Map<Character, Integer> seen = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int end = 0, start = 0; end < n; end++) {
            if (seen.containsKey(s.charAt(end))) {
                start = Math.max(seen.get(s.charAt(end)), start);
            }
            result = Math.max(result, end - start + 1);
            seen.put(s.charAt(end), end + 1);
        }
        return result;
    }
}
