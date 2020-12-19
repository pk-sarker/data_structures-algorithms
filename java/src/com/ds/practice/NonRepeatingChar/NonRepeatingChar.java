package com.ds.practice.NonRepeatingChar;

import java.util.HashMap;

public class NonRepeatingChar {

    public int findFirstNonRepeatingChar(String str) {
        int pos = -1;
        if (str == null || str == "") {
            return pos;
        }
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            int oc = 1;
            if (hashMap.containsKey(c)) {
                oc = hashMap.get(c)+1;
            }
            hashMap.put(c, oc);
        }

        for(int i=0; i<str.length(); i++) {
            if (hashMap.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return pos;
    }

    public static void main(String args[]) {
        NonRepeatingChar nrc = new NonRepeatingChar();

        System.out.println("\nInput: preparation \nOutput: " + nrc.findFirstNonRepeatingChar("preparation"));

        System.out.println("\nInput: knowledge \nOutput: " + nrc.findFirstNonRepeatingChar("knowledge"));
    }
}
