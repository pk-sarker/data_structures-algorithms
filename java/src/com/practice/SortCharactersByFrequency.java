package com.practice;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Given a string, sort it in decreasing order based on the frequency of characters.
 *
 * Input: "tree"
 *
 * Output: "eert"
 *
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 *
 */
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for(int i=0; i< s.length(); i++) {
            hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0)+1);
        }
        PriorityQueue<Character> heap = new PriorityQueue<Character>((c1, c2) -> {
            if (hashMap.get(c1) == hashMap.get(c2)) {
                return c1.compareTo(c2);
            } else {
                return hashMap.get(c2)-hashMap.get(c1);
            }
        });
        StringBuilder sb = new StringBuilder();

        for(Character c: hashMap.keySet()) {
            heap.offer(c);
        }
        while(!heap.isEmpty()) {
            char c = heap.poll();
            int frequency = hashMap.get(c);
            for(int i=0; i<frequency; i++) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String args[]) {
        SortCharactersByFrequency obj = new SortCharactersByFrequency();

        System.out.println("\nInput: tree \nOutput: " + obj.frequencySort("tree"));
    }
}
