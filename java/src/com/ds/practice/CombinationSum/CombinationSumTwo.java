package com.ds.practice.CombinationSum;

import java.util.*;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note: The solution set must not contain duplicate combinations.
 */
public class CombinationSumTwo {

    public void dfsTraversal(int remainingTarget, int[] candidates, LinkedList<Integer> combinations, int start, List<List<Integer>> result) {
        if(remainingTarget < 0) {
            return;  // no combination found
        }
        if (remainingTarget == 0) { // combination sum found
            result.add(new ArrayList<Integer>(combinations));
            return;
        } else {
            for(int i=start; i<candidates.length; i++) {
                // same number in consecutive position
                if (i>start && candidates[i] == candidates[i-1]) {
                    continue;
                }
                combinations.add(candidates[i]);
                this.dfsTraversal(remainingTarget - candidates[i], candidates, combinations, i+1, result);
                combinations.removeLast();
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        LinkedList<Integer> combinations = new LinkedList<>();
        Arrays.sort(candidates);
        this.dfsTraversal(target, candidates, combinations, 0, result);
        return result;
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
        CombinationSumTwo cs = new CombinationSumTwo();
        //List<List<Integer>>  result = cs.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
        List<List<Integer>>  result = cs.combinationSum2(new int[]{1,10,2,7,6,1,5}, 8);
        //List<List<Integer>>  result = cs.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
        System.out.println("\nInput: [10,1,2,7,6,1,5] target: 8");
        cs.print(result);


        List<List<Integer>>  result2 = cs.combinationSum2(new int[]{1}, 1);
        System.out.println("\nInput: [1] target: 1");
        cs.print(result2);

        List<List<Integer>>  result3 = cs.combinationSum2(new int[]{1,2}, 1);
        System.out.println("\nInput: [1,2] target: 1");
        cs.print(result3);

        List<List<Integer>>  result4 = cs.combinationSum2(new int[]{1,2}, 3);
        System.out.println("\nInput: [1,2] target: 3");
        cs.print(result4);


        List<List<Integer>>  result5 = cs.combinationSum2(new int[]{4,4,2,1,4,2,2,1,3}, 6);
        System.out.println("\nInput: [4,4,2,1,4,2,2,1,3] target: 6");
        cs.print(result5);

        List<List<Integer>>  result6 = cs.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
        System.out.println("\nInput: [10,1,2,7,6,1,5] target: 8");
        cs.print(result6);
    }
}
