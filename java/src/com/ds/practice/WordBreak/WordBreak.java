package com.ds.practice.WordBreak;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    private boolean break_word(String s, Set<String> wordDic, int start) {
        if (s.length()==start) {
            return true;
        }
        for (int end = start + 1; end<=s.length(); end++) {
            if (wordDic.contains(s.substring(start, end)) && break_word(s, wordDic, end)) {
                return true;
            }
        }
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        return break_word(s, new HashSet<String>(wordDict), 0);
    }


    public boolean break_word2(String s, Set<String> dict, int start, Boolean[] prevResult) {
        if (start == s.length()) {
            return true;
        }
        if (prevResult[start] != null) {
            return prevResult[start];
        }
        for(int end=start+1; end <= s.length(); end++) {

            if (dict.contains(s.substring(start, end)) && break_word2(s, dict, end, prevResult)) {
                prevResult[start] = true;
                return true;
            }
        }
        prevResult[start] = false;
        return prevResult[start];
    }
    public boolean wordBreak2(String s, List<String> wordDict) {
        return break_word2(s, new HashSet<String>(wordDict), 0, new Boolean[s.length()]);
    }

    public static void main(String args[]) {
        WordBreak wb = new WordBreak();

        List<String> ls = new ArrayList<>();
        ls.add("code");
        ls.add("leet");

        System.out.println("\ns=leetcode  wordDict = [\"leet\", \"code\"] \nOutput: " + wb.wordBreak("leetcode", ls));

        ls.clear();
        ls.add("kumar");
        ls.add("pij");
        ls.add("us");
        System.out.println("\ns=pijuskumar  wordDict = [\"kumar\", \"us\",\"pij\"] \nOutput: " + wb.wordBreak2("pijuskumar", ls));
    }
}
