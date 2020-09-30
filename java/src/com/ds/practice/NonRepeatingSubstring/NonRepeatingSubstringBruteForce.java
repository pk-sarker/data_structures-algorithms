package com.ds.practice.NonRepeatingSubstring;
import java.util.HashSet;
import java.util.Set;

public class NonRepeatingSubstringBruteForce {
    public int getNonRepeatingSubstring(String str) {
        int n = str.length();
        if (n <= 1) {
            return n;
        }
        char[] strArr = str.toCharArray();
        int maxLength = 0;

        for(int i=0; i<n; i++) {

            for(int j = i + 1; j < n; j++) {
                Set ch = new HashSet<>();
                int len = 0;
                for (int k = i; k<=j; k++) {
                    if (ch.contains(strArr[k])) {
                        break;
                    } else {
                        len++;
                        ch.add(strArr[k]);
                    }
                }
                if (len > 0) {
                    maxLength = Math.max(maxLength, len);
                }
            }
        }

        return maxLength;
    }
}
