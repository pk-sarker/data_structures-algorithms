package com.practice;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        if (intervals.length<2) {
            return intervals;
        }
        LinkedList<int[]> merged = new LinkedList<>();
        for(int[] interval : intervals) {
            if (merged.isEmpty()) {
                merged.add(interval);
            } else {
                if (interval[0] > merged.getLast()[1]) {
                    merged.add(interval);
                } else {
                    merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
                }
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String args[]) {
        int[][] intervals = new int[][]{{1,3}, {2,6}, {8,10}, {15,18}};
        int[][] result = MergeIntervals.merge(intervals);
        System.out.print("\nInput: [[1,3],[2,6],[8,10],[15,18]] \nOutput: ");
        for(int[] interval :  result) {
            System.out.print(Arrays.toString(interval));
        }
    }
}
