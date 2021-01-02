package com.ds.practice.DecodingWays;

import java.util.HashMap;

public class DecodingWays {
    HashMap<Integer, Integer> hash = new HashMap<>();

    public int numDecodingRecursion(int index, String s) {
        // if reached at the end of the string
        // return 1
        if (index == s.length()) {
            return 1;
        }
        // if there is a character which we don't have
        // mapping, return 0
        if (s.charAt(index)=='0') {
            return 0;
        }
        if (index == s.length()-1) {
            return 1;
        }
        if (hash.containsKey(index)) {
            return hash.get(index);
        }
        // go to next char for single digit decoding
        int res = numDecodingRecursion(index+1, s);
        if (Integer.parseInt(s.substring(index, index+2))<=26) {
            res += numDecodingRecursion(index+2, s);
        }
        hash.put(index, res);
        return res;

    }
    public int numDecodings(String s) {
        if (s == null || s.length() ==0) {
            return 0;
        }
        return numDecodingRecursion(0, s);
    }

    public int numDecodingItr(String s) {
        if (s == null || s.length() ==0) {
            return 0;
        }
        int[] dp = new int[s.length()+1];
        // initialize dp
        dp[0] = 1;
        // Ways to decode a string of size 1 is 1. Unless the string is '0'.
        // '0' doesn't have a single digit decode.
        dp[1] = s.charAt(0) != '0' ? 1:0;

        for(int i=2; i<dp.length;i++) {
            if (s.charAt(i-1) != '0') {
                //System.out.println(">> " + dp[i] + " > " + dp[i-1]);
                dp[i] += dp[i-1];
            }
            int twoDigit = Integer.parseInt(s.substring(i-2, i));
            if (twoDigit >=10 && twoDigit<=26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];
    }

    public int numDecodingItrConstantSpace(String s) {
        if (s == null || s.length() ==0) {
            return 0;
        }
        //int[] dp = new int[s.length()+1];
        // initialize dp
        int pprev = 1;
        // Ways to decode a string of size 1 is 1. Unless the string is '0'.
        // '0' doesn't have a single digit decode.
        int prev = s.charAt(0) != '0' ? 1:0;
        int cur = prev;

        for(int i=2; i<s.length()+1;i++) {
            cur = 0;
            if (s.charAt(i-1) != '0') {
                cur = prev;
            }
            int twoDigit = Integer.parseInt(s.substring(i-2, i));
            if (twoDigit >=10 && twoDigit<=26) {
                cur += pprev;
            }
            pprev = prev;
            prev = cur;
        }
        return cur;
    }

    public int numDecodings1(String s) {

        if(s == null || s.length() == 0) {
            return 0;
        }

        // DP array to store the subproblem results
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        // Ways to decode a string of size 1 is 1. Unless the string is '0'.
        // '0' doesn't have a single digit decode.
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for(int i = 2; i < dp.length; i += 1) {

            // Check if successful single digit decode is possible.
            if(s.charAt(i-1) != '0') {
                dp[i] += dp[i-1];
            }

            // Check if successful two digit decode is possible.
            int twoDigit = Integer.valueOf(s.substring(i-2, i));
            if(twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];

    }
    public static void main(String args[]) {
        DecodingWays dw = new DecodingWays();
        System.out.println("Input 1: 12 \nOutput: " + dw.numDecodings("12"));
        dw.hash.clear();
        System.out.println("Input 2: 226 \nOutput: " + dw.numDecodings("226"));
        dw.hash.clear();
        System.out.println("Input 3: 0 \nOutput: " + dw.numDecodings("0"));
        dw.hash.clear();
        System.out.println("Input 4: 321 \nOutput: " + dw.numDecodings("321"));
        dw.hash.clear();
        System.out.println("Input 5: 1234 \nOutput: " + dw.numDecodings("129"));
        dw.hash.clear();
        System.out.println("Input 6: 1234 \nOutput: " + dw.numDecodings("1234"));
        dw.hash.clear();
        System.out.println("Input 7: 12345 \nOutput: " + dw.numDecodings("1510"));
        dw.hash.clear();
        //System.out.println("Input 2: 1234 \nOutput: " + dw.recursiveWithMemo(0, "1234"));


        System.out.println("\n - - - - - - - - - ");

        System.out.println("Input 9: 1234 \nOutput: " + dw.numDecodingItr("1234"));

        System.out.println("Input 10: 1510 \nOutput: " + dw.numDecodingItrConstantSpace("1510"));
        System.out.println("Input 11: 0 \nOutput: " + dw.numDecodingItrConstantSpace("0"));
        System.out.println("Input 12: 1 \nOutput: " + dw.numDecodingItrConstantSpace("1"));



    }
}
