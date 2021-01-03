package com.ds.practice.KClosestPointsToOrigin;

import java.util.*;

public class KClosestPointsToOrigin {

    public int[][] kClosest1(int[][] points, int K) {
        int n = points.length;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for(int i=0; i<n; i++) {
            int sq = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            System.out.println("i="+i+", sq="+sq);
            treeMap.put(sq, i);
        }
        System.out.println(treeMap);
        int[][] result = new int[K][2];
        int count = 0;
        for(int i=0; i<K; i++) {
            Integer key = treeMap.firstKey();
            int index = treeMap.get(key);
            System.out.println("Index: "+index+" key:"+key);
            result[count][0] = points[index][0];
            result[count][1] = points[index][1];
            count++;
            treeMap.remove(key);
        }

        return  result;
    }

    public int[][] kClosest2(int[][] points, int K) {
        int n = points.length;
        TreeMap<Integer, TreeSet<Integer>> treeMap = new TreeMap<>();
        for(int i=0; i<n; i++) {
            int sq = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            System.out.println("i="+i+", sq="+sq);
            if (!treeMap.containsKey(sq)) {
                TreeSet<Integer> s = new TreeSet<>();
                s.add(i);
                treeMap.put(sq, s);
            } else {
                treeMap.get(sq).add(i);
            }
        }
        System.out.println(treeMap);
        int[][] result = new int[K][2];
        int count = 0;
       // for(int i=0; i<=K; i++) {
        while(count < K) {
            Integer key = treeMap.firstKey();
            TreeSet<Integer> indices = treeMap.get(key);
            while(!indices.isEmpty() && count<K) {
                Integer lowestIndex = indices.pollFirst();
                System.out.println("Index: "+lowestIndex+" key:"+key);
                result[count][0] = points[lowestIndex][0];
                result[count][1] = points[lowestIndex][1];
                count++;
            }
            System.out.println(indices);
            System.out.println(treeMap);
            if (indices.isEmpty()) {
                treeMap.remove(key);
            }
            System.out.println("i="+count);
        }
        return  result;
    }

    public int[][] kClosest(int[][] points, int K) {
        int N = points.length;
        int[] dists = new int[N];
        for (int i = 0; i < N; ++i)
            dists[i] = points[i][0]*points[i][0] + points[i][1]*points[i][1];

        Arrays.sort(dists);
        int distK = dists[K-1];

        int[][] ans = new int[K][2];
        int t = 0;
        for (int i = 0; i < N; ++i) {
            Integer cdist = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            if (cdist <= distK) {
                ans[t++] = points[i];
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        KClosestPointsToOrigin obj = new KClosestPointsToOrigin();

        int[][] res = obj.kClosest(new int[][]{{1,3},{1,1},{-2,2},{-1,-1}}, 3);
        for(int[] point: res) {
            System.out.print("("+point[0]+","+point[1]+") ");
        }

        System.out.println("\n\nInput: [[6,10],[-3,3],[-2,5],[0,2]] K=3 \nOutput: ");
        int[][] res1 = obj.kClosest(new int[][]{{6,10},{-3,3},{-2,5},{0,2}}, 3);
        for(int[] point: res1) {
            System.out.print("("+point[0]+","+point[1]+") ");
        }
    }

}
