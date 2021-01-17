package com.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given a string and a list of words, find all the starting indices of
 * substrings in the given string that are a concatenation of all the given
 * words exactly once without any overlapping of words. It is given that all
 * words are of the same length.
 *
 * Input: String="catfoxcat", Words=["cat", "fox"]
 * Output: [0, 3]
 * Explanation: The two substring containing both the words are "catfox" & "foxcat".
 *
 * Input: String="catcatfoxfox", Words=["cat", "fox"]
 * Output: [3]
 * Explanation: The only substring containing both the words is "catfox".
 */
public class WordConcatenation {

    public static List<Integer> findSubstring(String s, String[] words) {
        int n = s.length(), wn = words.length;
        if (n==0 || wn == 0) {
            return new ArrayList<>();
        }
        int wl = words[0].length();
        List<Integer> result = new ArrayList<>();
        HashMap<String, Integer> wordMap = new HashMap<>();
        for(int i=0; i<wn; i++) {
            wordMap.put(words[i], wordMap.getOrDefault(words[i], 0)+1);
        }

        for(int end = 0; end <= n - wn * wl; end++) {
            HashMap<String, Integer> wordInWindow = new HashMap<>();
            for(int j=0; j<wn; j++) {
                int wordIndex = end + j * wl;
                String word = s.substring(wordIndex, wordIndex+wl);
                wordInWindow.put(word, wordInWindow.getOrDefault(word, 0)+1);
                if (!wordMap.containsKey(word)) {
                    break;
                }

                if (wordInWindow.get(word) > wordMap.getOrDefault(word, 0)) {
                    break;
                }

                if (j+1 == wn) {
                    result.add(end);
                }
            }
        }
        return result;
    }

    public static void main(String args[]) {
        List<Integer> result = WordConcatenation.findSubstring("catfoxcat", new String[] { "cat", "fox" });
        System.out.println(result);
//        result = WordConcatenation.findSubstring("catcatfoxfox", new String[] { "cat", "fox" });
//        System.out.println(result);


        List<Integer> result1 = WordConcatenation.findSubstring("wordgoodgoodgoodbestword", new String[] { "word","good","best","word"});
        System.out.println(result1);
    }
}
