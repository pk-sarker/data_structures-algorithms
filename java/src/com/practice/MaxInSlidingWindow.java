package com.practice;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * You are given an array of integers nums, there is a sliding window of
 * size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding
 * window moves right by one position.
 *
 * Return the max sliding window.
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 * Input: nums = [1,-1], k = 1
 * Output: [1,-1]
 *
 * Input: nums = [9,11], k = 2
 * Output: [11]
 *
 */
public class MaxInSlidingWindow {

    // brute force - Time Limit Exceeded
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n-k+1];
        int max = Integer.MIN_VALUE;
        int start=0;

        for(int i=0; i<n; i++) {
            max = Math.max(max, nums[i]);
            if (i<k) {
                if (i==k-1) {
                    result[start] = max;
                }
                continue;
            }
            start++;
            max = nums[start];
            for(int j=start+1; j<start+k; j++) {
                max = Math.max(max, nums[j]);
            }
            result[start] = max;
         }

        return result;
    }

    // Time Limit Exceeded
    public static int[] maxSlidingWindowHeap(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a, b) -> b-a);

        int n = nums.length;
        int[] result = new int[n-k+1];
        int count = 0;

        // initialize heap
        for(int i=0; i<k; i++) {
            heap.add(nums[i]);
        }
        result[count++] = heap.peek();
        for(int i=k; i<n; i++) {
            int idx_window_first = i-k;
            heap.remove(nums[idx_window_first]);
            heap.add(nums[i]);
            result[count++] = heap.peek();
        }
        return result;
    }

    // ------ Acceptable -------
    /* *
     * queue is a double-ended queue
     * Maintain the queue such that index of maximum value
     * observed so far in the current window is at the top/first
     * of the queue.
     *
     * To do this, when a new index comes in:
     *  - it will first check if the current maximum is still in the window or outside
     *    if outside then remove that from the queue
     *  - it will compare all the elements in the queue with current value,
     *    and remove any value which is less than current value. This ensures
     *    ordering of the values in the queue.
     *    For example: ar = [5, 3, 2, 4]
     *      q at 3rd iteration: [0, 1, 2] => value = [5, 3, 2]
     *      q at 4th iteration: [0, 3] => value = [5, 4]
     */
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    int[] numbers;
    /* *
     *
     */
    public void update_queue(int i, int k) {

        if (!queue.isEmpty() && queue.getFirst() == i-k) {
            queue.removeFirst();
        }

        // remove all the indices whose values are
        // smaller than current value

        while(!queue.isEmpty() && numbers[i] > numbers[queue.getLast()]) {
            queue.removeLast();
        }

    }

    public int[] maxSlidingWindowDqueue(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;

        this.numbers = nums;

        int[] result = new int[n-k+1];
        int idx_max = 0;
        for (int i=0; i<k; i++) {
            this.update_queue(i, k);
            this.queue.addLast(i);

            if (nums[i]>nums[idx_max]) {
                idx_max = i;
            }
        }

        result[0] = nums[idx_max];

        for(int i=k; i<n; i++)  {
            this.update_queue(i, k);
            this.queue.addLast(i);
            result[i-k+1] = nums[this.queue.getFirst()];
        }
        return result;
    }


    public static void main(String args[]) {
        System.out.println("\nInput: [1,3,-1,-3,5,3,6,7], k = 3 \nOutput: " +
                Arrays.toString(MaxInSlidingWindow.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
        System.out.println("\nInput: [1,3,-1,-3,5,3,6,7], k = 3 \nOutput: " +
                Arrays.toString(MaxInSlidingWindow.maxSlidingWindowHeap(new int[]{1,3,-1,-3,5,3,6,7}, 3)));

        System.out.println("\nInput: [1,3,-1,-3,5,3,6,7], k = 8 \nOutput: " +
                Arrays.toString(MaxInSlidingWindow.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 8)));

        System.out.println("\nInput: [1], k = 1 \nOutput: " +
                Arrays.toString(MaxInSlidingWindow.maxSlidingWindow(new int[]{1}, 1)));
        System.out.println("\nInput: [1,-1], k = 1 \nOutput: " +
                Arrays.toString(MaxInSlidingWindow.maxSlidingWindow(new int[]{1,-1}, 1)));
        System.out.println("\nInput: [9,11], k = 2 \nOutput: " +
                Arrays.toString(MaxInSlidingWindow.maxSlidingWindow(new int[]{9,11}, 2)));
        System.out.println("\nInput: [4,-4], k = 2 \nOutput: " +
                Arrays.toString(MaxInSlidingWindow.maxSlidingWindow(new int[]{4,-4}, 2)));


        MaxInSlidingWindow msw = new MaxInSlidingWindow();
        System.out.println("\nInput: [1,3,-1,-3,5,3,6,7], k = 3 \nOutput: " +
                Arrays.toString(msw.maxSlidingWindowDqueue(new int[]{1,3,-1,-3,5,3,6,7}, 3)));


    }
}
