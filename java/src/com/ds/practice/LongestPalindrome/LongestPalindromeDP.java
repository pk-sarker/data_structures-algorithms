package com.ds.practice.LongestPalindrome;

public class LongestPalindromeDP {

    public String getLongestPalindrome(String str) {
        System.out.println("Using Dynamic programming: Input: " + str);
        int n = str.length();
        if (n <= 0) {
            return str;
        }
        boolean dpTable[][] = new boolean[n][n];

        int maxLength = 0;
        // Check all substring of length 1
        for( int i = 0; i < n; i++) {
            dpTable[i][i] = true;
        }
        maxLength = 1;
        int start = 0;
        // check all substrings of length 2
        for(int i = 0; i < n - 1; i++) {
            dpTable[i][i+1] = false;
            if (str.charAt(i) == str.charAt(i+1)) {
                dpTable[i][i+1] = true;
                maxLength = 2;
                start = i;
            }
        }

        for (int l = 3; l <= n; l++) {  // check substrings of length l
            for( int i = 0; i < n - l + 1; i++) {  //
                int j = i + l - 1;
                if (str.charAt(i) == str.charAt(j) && dpTable[i+1][j-1]) {
                    dpTable[i][j] = true;
                    if (l > maxLength) {
                        maxLength = l;
                        start = i;
                    }
                }
            }
        }
        return str.substring(start, start+maxLength);
    }
}
