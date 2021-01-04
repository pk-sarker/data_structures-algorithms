package com.ds.practice.LabelPartition;
import java.util.ArrayList;
import java.util.List;

public class LabelPartition {

    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length()==0) {
            return res;
        }
        int[] letterLastPos = new int[26];
        for(int i=0; i<s.length();i++) {
            letterLastPos[s.charAt(i)-'a'] = i;
        }
        int j = 0, start = 0;
        for(int i=0;i<s.length();i++) {
            j = Math.max(j, letterLastPos[s.charAt(i)-'a']);
            if (i==j) {
                res.add(i-start+1);
                start = i+1;
            }
        }
        return res;
    }

    public static void main(String args[]) {
        LabelPartition lp = new LabelPartition();
        System.out.println("\nInput: ababcbacadefegdehijhklij \nOutput: " + lp.partitionLabels("ababcbacadefegdehijhklij").toString());
        System.out.println("\nInput: aaab \nOutput: " + lp.partitionLabels("aaab").toString());

        System.out.println("\nInput: aaaa \nOutput: " + lp.partitionLabels("aaaa").toString());
    }
}
