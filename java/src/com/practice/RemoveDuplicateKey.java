package com.practice;

/**
 * Given an array nums and a value val, remove all instances
 * of that value in-place and return the new length.
 *
 * Do not allocate extra space for another array, you must do this
 * by modifying the input array in-place with O(1) extra memory.
 *
 * The order of elements can be changed. It doesn't matter what you
 * leave beyond the new length.
 *
 * Input: nums = [3,2,2,3], val = 3
 * Output: 2, nums = [2,2]
 * Explanation: Your function should return length = 2, with the first two elements of nums being 2.
 * It doesn't matter what you leave beyond the returned length.
 * For example if you return 2 with nums = [2,2,3,3] or nums = [2,2,0,0],
 * your answer will be accepted.
 *
 * Input: nums = [0,1,2,2,3,0,4,2], val = 2
 * Output: 5, nums = [0,1,4,0,3]
 * Explanation: Your function should return length = 5, with the first five elements
 * of nums containing 0, 1, 3, 0, and 4. Note that the order of those five elements
 * can be arbitrary. It doesn't matter what values are set beyond the returned length.
 *
 */
public class RemoveDuplicateKey {

    public static int remove(int[] nums, int key) {
        if (nums.length ==0) {
            return 0;
        }
        int start = 0;
        for(int end=0; end<nums.length;end++) {
            if (nums[end] != key) {
                nums[start] = nums[end];
                start++;
            }
        }

        return start;

    }
    public static void main(String args[]) {

        int[] arr = new int[] { 3, 2, 3, 6, 3, 10, 9, 3 };
        System.out.println(RemoveDuplicateKey.remove(arr, 3));

        arr = new int[] { 2, 11, 2, 2, 1 };
        System.out.println(RemoveDuplicateKey.remove(arr, 2));

    }
}
