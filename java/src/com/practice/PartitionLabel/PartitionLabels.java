package com.practice.PartitionLabel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A string S of lowercase English letters is given. We want to partition this string into as many parts
 * as possible so that each letter appears in at most one part, and return a list of integers representing
 * the size of these parts.
 *
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 */
public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();

        int ptr1 = 0;
        int ptr2 = 0;
        int maxPtr = 0;

        HashMap<Character, Integer> hash = new HashMap<>();

        for(int i=0; i<S.length(); i++) {
            hash.put(S.charAt(i), i);
        }
        while(ptr2 < S.length()) {
            maxPtr = Math.max(hash.get(S.charAt(ptr2)), maxPtr);
            if (ptr2 == maxPtr) {
                res.add(ptr2-ptr1+1);
                ptr1=ptr2+1;
            }
            ptr2++;
        }

        return res;
    }


    public List<Integer> partitionLabels2(String S) {
        List<Integer> res = new ArrayList<>();

        int ptr1 = 0;
        int ptr2 = 0;
        int maxPtr = 0;

        int[] hash = new int[26];

        for(int i=0; i<S.length(); i++) {
            hash[S.charAt(i)-'a'] = i;
        }
        while(ptr2 < S.length()) {
            maxPtr = Math.max(hash[S.charAt(ptr2)-'a'], maxPtr);
            if (ptr2 == maxPtr) {
                res.add(ptr2-ptr1+1);
                ptr1=ptr2+1;
            }
            ptr2++;
        }

        return res;
    }

    public static void main(String args[]) {
        PartitionLabels pl = new PartitionLabels();
        System.out.println(pl.partitionLabels("abcadef"));

        System.out.println(pl.partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(pl.partitionLabels2("ababcbacadefegdehijhklij"));

    }
}
