package com.ds.practice.MergeIntervals;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals.length <=0) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        LinkedList<int []> merged =  new LinkedList<>();

        for(int[] interval : intervals) {
            if(merged.isEmpty() || (merged.getLast()[1]  < interval[0])) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String args[]) {
        MergeIntervals mi = new MergeIntervals();
        int [][] intervals = new int[][] {
                {1,3}, {2,6}, {8,10}, {15, 18}};
        int[][] merged = mi.merge(intervals);

        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for(int[]  intv: merged) {
            sb.append("[");
            sb.append(intv[0]+","+intv[1]);
            sb.append("]");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}
