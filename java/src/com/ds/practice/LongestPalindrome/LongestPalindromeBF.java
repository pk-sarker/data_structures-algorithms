package com.ds.practice.LongestPalindrome;

public class LongestPalindromeBF {

    public String getLongestPalindrome(String str) {
        int n = str.length();
        if (n == 0) {
            return "";
        }
        int length = 1;
        int startIndex = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                boolean flag = true;

                for(int k = 0; k < (j - i + 1)/2; k++) {
                    if (str.charAt(i+k) != str.charAt(j-k)) {
                        flag = false;
                        break;
                    }
                }

                if (flag && j - i + 1 > length ) {
                    length = j - i + 1;
                    startIndex = i;
                }
            }
        }
        return str.substring(startIndex, startIndex + length);
    }
}
