package com.practice;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string and a pattern, find out if the string contains any permutation of the pattern.
 *
 * Permutation is defined as the re-arranging of the characters of the string.
 * For example, “abc” has the following six permutations:
 *      abc
 *      acb
 *      bac
 *      bca
 *      cab
 *      cba
 * If a string has ‘n’ distinct characters, it will have n!n! permutations.
 */
public class StringPermutation {

    public static boolean findPermutation(String str, String pattern) {
        if (pattern == null || pattern == "") {
            return true;
        }
        HashSet<Character> patternCharSet = new HashSet<>();
        for(int i=0; i<pattern.length(); i++) {
            patternCharSet.add(pattern.charAt(i));
        }

        for(int end =0;end < str.length(); end++) {
            if (patternCharSet.contains(str.charAt(end))) {
                Set<Character> charSet = new HashSet<>();
                charSet.addAll(patternCharSet);
                charSet.remove(str.charAt(end));
                for(int i=end+1; i < end+1+pattern.length()-1; i++) {
                    if (i < str.length()) {
                        if (charSet.contains(str.charAt(i))) {
                            charSet.remove(str.charAt(i));
                        } else {
                            break;
                        }
                    }
                }
                if (charSet.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean findPermutation2(String str, String pattern) {
        if (pattern.length()>str.length()) {
            return false;
        }
        int[] patternCharMap = new int[26];
        for(int i=0; i<pattern.length();i++) {
            patternCharMap[pattern.charAt(i)-'a']++;
        }

        for(int end=0; end <= str.length() - pattern.length(); end++) {
            int[] strCharMap = new int[26];

            for(int j=0; j<pattern.length(); j++) {
                strCharMap[str.charAt(end+j)-'a']++;
            }
            if (match(strCharMap, patternCharMap)){
                return true;
            }
        }

        return false;
    }

    //
    public static boolean findPermutation3(String str, String pattern) {
        if (pattern == null || pattern == "") {
            return true;
        }
        int pn = pattern.length(), n = str.length();
        int[] patternCharMap = new int[26];
        int[] strCharMap = new int[26];
        for(int i=0; i<pn;i++) {
            patternCharMap[pattern.charAt(i)-'a']++;
            strCharMap[str.charAt(i)-'a']++;
        }

        for(int end =0;end < n - pn; end++) {
            if (StringPermutation.match(strCharMap, patternCharMap)){
                return true;
            }
            strCharMap[str.charAt(end+pn)-'a']++;
            strCharMap[str.charAt(end)-'a']--;
        }
        return StringPermutation.match(strCharMap, patternCharMap);
    }

    public static boolean match(int[] s1map, int[] s2map) {
        for(int i=0; i<26; i++) {
            if (s1map[i]!=s2map[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
//        System.out.println(StringPermutation.findPermutation("oidbcaf", "abc"));
//        System.out.println(StringPermutation.findPermutation("oidbcmafcad", "abc"));
//
//        System.out.println(StringPermutation.findPermutation("oidbcmafcabd", "abc"));

//        System.out.println(StringPermutation.findPermutation("odicf", "dc"));
//
        System.out.println(StringPermutation.findPermutation("bcdxabcdy", "bcdyabcdx"));
        System.out.println(StringPermutation.findPermutation2("bcdxabcdy", "bcdyabcdx"));
//
//        System.out.println(StringPermutation.findPermutation("aaacb", "abc"));

        System.out.println(StringPermutation.findPermutation("ooolleoooleh", "hello"));

        System.out.println(StringPermutation.findPermutation2("ooolleoooleh", "hello"));

        System.out.println(StringPermutation.findPermutation3("ooolleoooleh", "hello"));



    }
}
