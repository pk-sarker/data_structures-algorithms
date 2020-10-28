package com.ds.practice.TopKFrequentElements;

import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Comparator;


public class TopKFrequentElements {

    public int[] getTopKFrequentElements(int[] nums, int k) {
        // if k is equal to number list then return all the elements
        if (nums.length == k) {
            return nums;
        }
        Map<Integer, Integer> hashMap = new HashMap<>();

        // Count frequency and add in hash map. Complexity O(n)
        for(int i=0;i<nums.length;i++) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0)+1);
        }
        // Creating a heap
        PriorityQueue<Integer> heap= new PriorityQueue<Integer>((a, b) -> hashMap.get(a) - hashMap.get(b));

        // PriorityQueue<Integer> heap= new PriorityQueue<>(Comparator.comparingInt(hashMap::get));
        // Adding elements in heap, complexity O(n log k), O(log k) for inserting an element in heap of size k,
        // we will add n elements in the heap.
        for(int count : hashMap.keySet()) {
            heap.add(count);
            if (heap.size()>k) {
                heap.poll();
            }
        }

        int[] topK = new int[k];
        // O(k) for iteration and each poll will be O(1)
        for(int i = k -1; i>=0; i--) {
            topK[i] = heap.poll();
        }
        return topK;
    }

    public void print(int[] ar) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<ar.length; i++) {
            sb.append(ar[i]);
            if (i < ar.length -1) {
                sb.append(", ");
            }
        }
        System.out.println("Output: [" + sb.toString() + "]");
    }

    public static void main(String args[]) {
        System.out.println("Input: [1,1,1,2,2,3] k=2");
        TopKFrequentElements kfe = new TopKFrequentElements();
        int[] topK = kfe.getTopKFrequentElements(new int[] {1,1,1,2,2,3}, 2);
        kfe.print(topK);

        System.out.println("\nInput: [3,1,4,4,5,2,6,1] k=2");
        topK = kfe.getTopKFrequentElements(new int[] {3,1,4,4,5,2,6,1}, 2);
        kfe.print(topK);

        System.out.println("\nInput: [1,3,2,4] k =2");
        topK = kfe.getTopKFrequentElements(new int[] {1,3,2,4}, 2);
        kfe.print(topK);

        System.out.println("\nInput: [1,3,2,4] k =4");
        topK = kfe.getTopKFrequentElements(new int[] {1,3,2,4}, 4);
        kfe.print(topK);
        //
    }
}
