package com.ds.practice.KthLargestElement;
import java.util.PriorityQueue;
public class KthLargestElement {

    public int findKthLargestElement(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a, b) -> a-b);
        for(int i = 0; i<arr.length; i++){
            heap.add(arr[i]);
            if (heap.size()>k) {
                heap.poll();
            }
        }
        return heap.poll();
    }
    public static void main(String args[]) {
        KthLargestElement klg = new KthLargestElement();
        int[] arr = new int[]{5, 9, 1, 4, 2, 8};
        System.out.println("Input: [5, 9, 1, 4, 2, 8], k=2\nOutput: "+ klg.findKthLargestElement(arr, 2));
        System.out.println("Input: [3,2,1,5,6,4], k=2\nOutput: "+ klg.findKthLargestElement(new int[]{3,2,1,5,6,4}, 2));
        System.out.println("Input: [3,2,3,1,2,4,5,5,6], k=4\nOutput: "+ klg.findKthLargestElement(new int[]{3,2,3,1,2,4,5,5,6}, 4));

        // Using Quick Select
        KthLargestElementWithQuickSelect kl = new KthLargestElementWithQuickSelect();

        System.out.println("Input: [5, 9, 1, 4, 2, 8], k=2\nOutput: "+ kl.findKthLargestElement(arr, 2));
        System.out.println("Input: [3,2,1,5,6,4], k=2\nOutput: "+ kl.findKthLargestElement(new int[]{3,2,1,5,6,4}, 2));
        System.out.println("Input: [3,2,3,1,2,4,5,5,6], k=4\nOutput: "+ kl.findKthLargestElement(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
}
