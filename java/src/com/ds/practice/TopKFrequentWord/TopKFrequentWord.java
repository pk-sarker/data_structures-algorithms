package com.ds.practice.TopKFrequentWord;

import java.util.*;

public class TopKFrequentWord {

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        List<String> res = new ArrayList<>();
        if (words.length == 0) {
            return res;
        }

        for(int i=0; i<words.length; i++) {
            hashMap.put(words[i], hashMap.getOrDefault(words[i],0 )+1);
        }
        List<String> candidates = new ArrayList(hashMap.keySet());
        Collections.sort(candidates, (String w1, String w2) -> {
            if (hashMap.get(w1).equals(hashMap.get(w2))) {
                return w1.compareTo(w2);
            } else {
                return hashMap.get(w2) - hashMap.get(w1);
            }
        });

        return candidates.subList(0, k);
    }


    public List<String> topKFrequentWithHeap(String[] words, int k) {
        List<String> res = new ArrayList<>();
        int n = words.length;
        if (n == 0) {
            return res;
        }
        HashMap<String, Integer> hashMap = new HashMap<>();
        // O(n)
        for(int i=0; i<n; i++) {
            hashMap.put(words[i], hashMap.getOrDefault(words[i], 0)+1);
        }
        PriorityQueue<String> heap = new PriorityQueue<String>((w1, w2) -> {
           if (hashMap.get(w1) == hashMap.get(w2)) {
               return w2.compareTo(w1);
           } else {
               return hashMap.get(w1) - hashMap.get(w2);
           }
        });

        // O(n)
        for(String word : hashMap.keySet()) {
            heap.offer(word); // O(log n)
            if (heap.size()>k) {
                heap.poll();
            }
        }

        // O(k)
        while(!heap.isEmpty()) {
            res.add(heap.poll());
        }
        Collections.reverse(res); // O(n)
        return res;
    }

    public static void main(String args[]) {
        TopKFrequentWord tkfw = new TopKFrequentWord();

        System.out.println("\nInput: [\"i\", \"love\", \"leetcode\", \"i\", \"love\", \"coding\"] k=2 \nOutput:"+tkfw.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
        System.out.println("\nInput: [\"i\", \"love\", \"leetcode\", \"i\", \"love\", \"coding\"] k=3 \nOutput:"+tkfw.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 3));

        System.out.println("\nInput: [\"i\", \"love\", \"leetcode\", \"love\", \"i\", \"love\", \"coding\"] k=2 \nOutput:"+tkfw.topKFrequentWithHeap(new String[]{"i", "love", "leetcode", "love", "i", "love", "coding"}, 2));
        System.out.println("\nInput: [\"i\", \"love\", \"leetcode\", \"love\", \"i\", \"love\", \"coding\"] k=2 \nOutput:"+tkfw.topKFrequentWithHeap(new String[]{"i", "love", "leetcode", "love", "i", "love", "coding"}, 2));

        System.out.println("\nInput: [\"love\", \"i\", \"coding\", \"i\", \"love\", \"coding\", \"i\", \"love\", \"design\"] k=3 \nOutput:"+tkfw.topKFrequentWithHeap(new String[]{"love", "i", "coding", "i", "love", "coding", "i", "love", "design"}, 3));

    }
}
