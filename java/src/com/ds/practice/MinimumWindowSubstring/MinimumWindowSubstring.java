package com.ds.practice.MinimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        Map<Character, Integer> subStrMap = new HashMap<>();
        for(int i=0; i<t.length(); i++) {
            subStrMap.put(t.charAt(i), subStrMap.getOrDefault(t.charAt(i), 0)+1);
        }
        // total unique character in  the sub string
        int uniqueCharLen = subStrMap.size();
        // equal # of characters found in current  window
        int charactersMatched = 0;

        int left = 0, right = 0;

        HashMap<Character, Integer> charactersInCurrentWindow = new HashMap<>();
        // window  length, start and end position
        int[] result = new int[]{-1, 0, 0};
        while(right < s.length()) {
            char c = s.charAt(right);
            charactersInCurrentWindow.put(c, charactersInCurrentWindow.getOrDefault(c, 0)+1);

            if (subStrMap.containsKey(c) && subStrMap.get(c).intValue() == charactersInCurrentWindow.get(c).intValue()) {
                charactersMatched++;
            }

            while(left <= right && charactersMatched == uniqueCharLen) {
                c = s.charAt(left);

                if (result[0] == -1) {
                    result[0] =  right - left + 1;
                    result[1] = left;
                    result[2] = right;
                } else {
                    if (result[0] > right - left + 1) {
                        result[0] =  right - left + 1;
                        result[1] = left;
                        result[2] = right;
                    }
                }
                charactersInCurrentWindow.put(c, charactersInCurrentWindow.get(c)-1);
                if (subStrMap.containsKey(c) && charactersInCurrentWindow.get(c).intValue() < subStrMap.get(c).intValue()) {
                    charactersMatched--;
                }
                left++;
            }
            right++;
        }

        return result[0] > -1 ? s.substring(result[1], result[2]+1): "";
    }

    public static void main(String args[]) {
        MinimumWindowSubstring mw = new MinimumWindowSubstring();
        System.out.println("\nInput: s=ADOBECODEBANC t=ABC \nOutput: "+mw.minWindow("ADOBECODEBANC", "ABC"));

        System.out.println("\nInput: s=ADOBECODEBANC  t=CD \nOutput: "+mw.minWindow("ADOBECODEBANC", "CD"));
    }
}
