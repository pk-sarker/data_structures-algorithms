package com.practice;

import java.util.*;

/**
 * Given a non-empty list of words, return the k most frequent elements.
 *
 * Your answer should be sorted by frequency from highest to lowest.
 * If two words have the same frequency, then the word with the
 * lower alphabetical order comes first.
 *
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 *     Note that "i" comes before "love" due to a lower alphabetical order.
 */
public class KFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String, Integer> frequencyCount = new HashMap<>();
        for(String w : words) {
            frequencyCount.put(w, frequencyCount.getOrDefault(w, 0)+1);
        }
        PriorityQueue<String> heap = new PriorityQueue<String>((w1, w2) ->
                frequencyCount.get(w1).equals(frequencyCount.get(w2)) ? w1.compareTo(w2) : frequencyCount.get(w1)-frequencyCount.get(w2));

        for(String key: frequencyCount.keySet()) {
            heap.offer(key);
            if (heap.size()> k) {
                heap.poll();
            }
        }

        List<String> res = new ArrayList<>();
        while(!heap.isEmpty()) {
            res.add(heap.poll());
        }
        Collections.reverse(res);
        return res;
    }
    public static void main(String args[]) {
        KFrequentWords obj = new KFrequentWords();
        List<String> res = obj.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2);

        System.out.println(res);
    }
}
