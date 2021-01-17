package com.practice;

import java.util.Arrays;
import java.util.Random;

public class KClosestToOrg {
    int[][] points;

    public int[][] kClosest(int[][] points, int K) {
        this.points = points;
        quickSelect(0, points.length-1, K);
        return Arrays.copyOfRange(this.points, 0, K);
    }

    public void quickSelect(int left, int right, int k) {
        if (left>=right) {
            return;
        }
        Random rand = new Random();
        int pivot_idx = left + rand.nextInt(right-left);

        pivot_idx = partition(left, right, pivot_idx);
        int left_len = pivot_idx - left + 1;
        if (k < left_len) {
            quickSelect(0, pivot_idx-1, k);
        } if (k > left_len) {
            quickSelect(pivot_idx+1, right, k);
        }
    }

    public int distance(int[] point) {
        return point[0]*point[0] + point[1]*point[1];
    }
    public int partition(int left, int right, int pivot_idx) {
        int[] pivot = points[pivot_idx];
        int pivot_dist = distance(pivot);

        // move the pivot to right, considering this is the largest element in the array
        swap(pivot_idx, right);

        int store_index = left;

        for(int i=left; i<=right; i++) {
            if (distance(points[i]) < pivot_dist) {
                swap(i, store_index);
                store_index++;
            }
        }
        swap(store_index, right);
        return store_index;
    }

    public void swap(int i, int j) {
        int t0 = points[i][0], t1 = points[i][1];
        points[i][0] = points[j][0];
        points[i][1] = points[j][1];
        points[j][0] = t0;
        points[j][1] = t1;
    }

    public static void main(String args[]) {
        KClosestToOrigin obj = new KClosestToOrigin();
        int[][] res = obj.kClosest(new int[][]{ {1,3}, {-2,2}},1);

        for(int i=0; i<res.length; i++) {
            System.out.print("[["+res[i][0] +","+ res[i][1] + "]");
        }
        System.out.print("]");

        System.out.println("--");

        int[][] res1 = obj.kClosest(new int[][]{ {3, -2}, {3,3}, {5,-1}, {-2, 4}, {-2,-1}},2);
        for(int i=0; i<res1.length; i++) {
            System.out.print("[["+res1[i][0] +","+ res1[i][1] + "]");
        }
        System.out.print("]");

        System.out.println("--");
        int[][] res2 = obj.kClosest(new int[][]{ {100,-16},{-31,45},{80,-47},{41,59},{-59,-34},{-34,-76},{-5,-77},{35,40},{58,-30},{31,-96},{40,14},{-25,50},{37,-38},{-54,-31}},8);
        for(int i=0; i<res2.length; i++) {
            System.out.print("[["+res2[i][0] +","+ res2[i][1] + "]");
        }
        System.out.print("]");



    }
}
