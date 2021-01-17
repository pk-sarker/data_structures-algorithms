package com.ds.practice.Permutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Permutation {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> numList = new ArrayList<>();
        for(int num: nums) {
            numList.add(num);
        }
        int n = nums.length;
        this.dfsTraversal(n, numList, 0, result);
        return result;
    }

    public void dfsTraversal(int n, ArrayList<Integer> nums, int start, List<List<Integer>> result) {
        if (start==n) {
            result.add(new ArrayList<>(nums));
        }
        for(int i=start; i<n; i++) {;

            // place i-th number first
            Collections.swap(nums, start, i);
            // use next integers to complete the permutations
            this.dfsTraversal(n, nums, start+1, result);
            // backtrack
            Collections.swap(nums, start, i);
        }
    }
    public void print(List<List<Integer>> result) {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        if (result!=null) {
            result.forEach(res -> {
                sb.append("[");
                res.forEach(item -> {
                    sb.append(item+",");
                });
                sb.setLength(sb.length()-1);
                sb.append("],");
            });
        }
        if (sb.length()>1) {
            sb.setLength(sb.length()-1);
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static void main(String args[]) {
        Permutation p = new Permutation();
        System.out.println("\nInput: [1,2,3]");
        List<List<Integer>> result = p.permute(new int[]{1,2,3});
        p.print(result);
    }
}
