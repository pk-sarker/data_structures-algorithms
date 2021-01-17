package com.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string and a pattern, find all anagrams of the pattern in the given string.
 *
 * Anagram is actually a Permutation of a string. For example, “abc” has the following six anagrams:
 *
 *  abc
 *  acb
 *  bac
 *  bca
 *  cab
 *  cba
 * Write a function to return a list of starting indices of the anagrams of the
 * pattern in the given string.
 *
 * Input: String="ppqp", Pattern="pq"
 * Output: [1, 2]
 * Explanation: The two anagrams of the pattern in the given string are "pq" and "qp".
 *
 * Input: String="abbcabc", Pattern="abc"
 * Output: [2, 3, 4]
 * Explanation: The three anagrams of the pattern in the given string are "bca", "cab", and "abc".
 */
public class StringAnagrams {
    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        int[] patternMap = new int[26];
        int[] strMap = new int[26];
        int n= str.length(), pn = pattern.length();

        for(int i =0; i<pn; i++) {
            patternMap[pattern.charAt(i)-'a']++;
            strMap[str.charAt(i)-'a']++;
        }

        for(int j=0; j<n-pn; j++) {
            if(match(patternMap, strMap)) {
                resultIndices.add(j);
            }
            strMap[str.charAt(j+pn)-'a']++;
            strMap[str.charAt(j)-'a']--;
        }

        if(match(patternMap, strMap)) {
            resultIndices.add(n-pn);
        }
        return resultIndices;
    }

    public static boolean match(int[] ar1, int[] ar2){
        for(int i=0; i<26; i++) {
            if (ar1[i]!=ar2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        System.out.println("\nInput: String=\"ppqp\", Pattern=\"pq\"\nOutput:" +
                StringAnagrams.findStringAnagrams("ppqp", "qp"));

        System.out.println("\nInput: String=\"cbaebabacd\", Pattern=\"abc\"\nOutput:" +
                StringAnagrams.findStringAnagrams("cbaebabacd", "abc"));

        System.out.println("\nInput: String=\"abab\", Pattern=\"ab\"\nOutput:" +
                StringAnagrams.findStringAnagrams("abab", "ab"));

        System.out.println("\nInput: String=\"abbcabc\", Pattern=\"abc\"\nOutput:" +
                StringAnagrams.findStringAnagrams("abbcabc", "abc"));
    }
}
