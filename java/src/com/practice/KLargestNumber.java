package com.practice;

import java.util.Random;

/**
 * Find the kth largest element in an unsorted array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 */
public class KLargestNumber {
    int[] nums;
    public int findKthLargest(int[] nums, int k){
        this.nums = nums;
        return quickSelect(0, nums.length-1, nums.length-k);
    }

    public void swap(int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public int partition(int left, int right,  int pivot_index) {
        int pivot = nums[pivot_index];
        // move the pivot to right, considering this is the largest element in the array
        swap(pivot_index, right);

        int store_index = left;

        for(int i=left; i<=right; i++) {
            if (nums[i] < pivot) {
                swap(i, store_index);
                store_index++;
            }
        }
        swap(store_index, right);
        return store_index;
    }
    /**
     *
     * @param left
     * @param right
     * @param  kth largest is (N - k)th smallest
     * @return
     */
    public int quickSelect(int left, int right, int smallestPos) {


        // if array contains only one element
        if (left==right) {
            return nums[left];
        }
        // select a random pivot_index
        Random rand = new Random();
        int pivot_index = left + rand.nextInt(right-left);

        pivot_index = partition(left, right, pivot_index);

        if (smallestPos == pivot_index) {
            return nums[smallestPos];
        } else if(smallestPos < pivot_index) {
            return quickSelect(left, pivot_index-1, smallestPos);
        } else {
            return quickSelect(pivot_index+1, right, smallestPos);
        }
    }


    public static void main(String args[]) {
        KLargestNumber obj = new KLargestNumber();

        System.out.println("\nInput: [3,2,1,5,6,4], k = 2\nOutput: " + obj.findKthLargest(new int[]{3,2,1,5,6,4}, 2));

        System.out.println("\nInput: [3,2,1,5,6,4], k = 2\nOutput: " + obj.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }
}
