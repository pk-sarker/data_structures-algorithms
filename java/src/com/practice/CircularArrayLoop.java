package com.practice;

/**
 * You are given a circular array nums of positive and negative integers.
 * If a number k at an index is positive, then move forward k steps.
 * Conversely, if it's negative (-k), move backward k steps. Since the array is circular,
 * you may assume that the last element's next element is the first element, and
 * the first element's previous element is the last element.
 *
 * Determine if there is a loop (or a cycle) in nums. A cycle must start and end at
 * the same index and the cycle's length > 1. Furthermore, movements in a cycle must
 * all follow a single direction. In other words, a cycle must not consist of
 * both forward and backward movements.
 *
 * Input: [2,-1,1,2,2]
 * Output: true
 * Explanation: There is a cycle, from index 0 -> 2 -> 3 -> 0. The cycle's length is 3.
 *
 * Input: [-1,2]
 * Output: false
 * Explanation: The movement from index 1 -> 1 -> 1 ... is not a cycle,
 * because the cycle's length is 1. By definition the cycle's length must be greater than 1.
 *
 * Input: [-2,1,-1,-2,-2]
 * Output: false
 * Explanation: The movement from index 1 -> 2 -> 1 -> ... is not a cycle,
 * because movement from index 1 -> 2 is a forward movement, but movement
 * from index 2 -> 1 is a backward movement. All movements in a cycle must follow a single direction.
 *
 */
public class CircularArrayLoop {

    public static boolean loopExists(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            boolean isForward = arr[i] >= 0; // if moving forward or backward
            int slow = i, fast = i;

            // if slow or fast becomes '-1' this means we can't find cycle for this number
            do {
                slow = moveToNextIndex(arr, isForward, slow);
                fast = moveToNextIndex(arr, isForward, fast);
                if (fast != -1) {
                    fast = moveToNextIndex(arr, isForward, fast);
                }
            } while(slow != -1 && fast != -1 && slow != fast);

            if (slow != -1 && slow == fast) {
                return true;
            }
        }
        return false;
    }

    private static int moveToNextIndex(int[] arr, boolean isForward, int currentIndex) {
        boolean currentDirection = arr[currentIndex] >= 0;
        if (isForward != currentDirection) {
            return -1;
        }
        int nextIndex = (currentIndex + arr[currentIndex]) % arr.length;
        if (nextIndex < 0) {
            nextIndex += arr.length;
        }
        // one element cycle
        if (nextIndex == currentIndex) {
            return -1;
        }

        return nextIndex;
    }

    public static void main(String[] args) {
        System.out.println(CircularArrayLoop.loopExists(new int[] { 1, 2, -1, 2, 2 }));
        System.out.println(CircularArrayLoop.loopExists(new int[] { 2, 2, -1, 2 }));
        System.out.println(CircularArrayLoop.loopExists(new int[] { 2, 1, -1, -2 }));
    }
}
