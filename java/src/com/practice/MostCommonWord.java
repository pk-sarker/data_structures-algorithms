package com.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a paragraph and a list of banned words, return the most frequent word that
 * is not in the list of banned words.  It is guaranteed there is at least one word
 * that isn't banned, and that the answer is unique.
 *
 * Words in the list of banned words are given in lowercase, and free of punctuation.
 * Words in the paragraph are not case sensitive.  The answer is in lowercase.
 *
 * Input:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * Output: "ball"
 * Explanation:
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"),
 * and that "hit" isn't the answer even though it occurs more because it is banned.
 *
 */
public class MostCommonWord {

    public static String mostCommonWord(String paragraph, String[] banned) {
        if (paragraph == null || paragraph.length()==0) {
            return "";
        }
        // Access the paragraph by characters
        String para_lower= paragraph.toLowerCase();
        char[] paragraphAr = para_lower.toCharArray();

        HashMap<String, Integer> wordCount = new HashMap<>();
        Set<String> bannedSet = new HashSet<>();
        for(String s: banned) {
            bannedSet.add(s);
        }
        int maxCount = -1;
        StringBuilder result = new StringBuilder();
        StringBuilder wordChars = new StringBuilder();
        for(int i=0; i<paragraphAr.length; i++) {

            if (Character.isLetter(paragraphAr[i])) {
                wordChars.append(paragraphAr[i]);
                if (i!=paragraphAr.length-1){
                    continue;
                    // don't process the remaining steps until it reaches at the end of the paragraph
                }
            }
            if (wordChars.length()>0){
                String word = wordChars.toString();

                if (bannedSet.contains(word)) {
                    wordChars.setLength(0);
                    continue;
                }

                int count = wordCount.getOrDefault(word, 0)+1;
                if (maxCount < count ) {
                    maxCount = count;
                    result.setLength(0);
                    result.append(word);
                }
                wordCount.put(word, count);
                wordChars.setLength(0);
            }
        }

        return result.toString();
    }

    public static void main(String args[]) {
        // System.out.println("\nInput: \"Bob hit a ball, the hit BALL flew far after it was hit.\" banned=[\"hit\"]\nOutput: " + MostCommonWord.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
        System.out.println("\nInput: \"Bob. hIt, baLl\" banned=[\"hit\"]\nOutput: " + MostCommonWord.mostCommonWord("Bob. hIt, baLl", new String[]{"bob", "hit"}));

    }
}
