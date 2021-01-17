package com.practice;

import java.util.PriorityQueue;

/**
 * Design a class to find the kth largest element in a stream. Note that it is the kth largest
 * element in the sorted order, not the kth distinct element.
 *
 * Implement KthLargest class:
 *
 *  - KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
 *  -   int add(int val) Returns the element representing the kth largest element in the stream.
 *
 * Input
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * Output
 * [null, 4, 5, 5, 8, 8]
 */
public class KthLargestElementInStream {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> a - b);
    int k;
    public KthLargestElementInStream(int k, int[] nums) {
        this.k = k;
        for(int num: nums) {
            add(num);
        }
    }

    public int add(int val) {
        maxHeap.offer(val);
        if (maxHeap.size()>this.k) {
            maxHeap.poll();
        }
        return maxHeap.peek();
    }

    public static void main(String args[]) {
        KthLargestElementInStream obj = new KthLargestElementInStream(3, new int[] {4, 5, 8, 2});
        System.out.println("add(3) : " + obj.add(3));
        System.out.println("add(5) : " + obj.add(5));
        System.out.println("add(10) : " + obj.add(10));
        System.out.println("add(9) : " + obj.add(9));
        System.out.println("add(4) : " + obj.add(4));
    }
}
