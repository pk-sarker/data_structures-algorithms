package com.ds.practice.CombinationSum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Problem:
 * Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen numbers
 * sum to target. You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times.
 * Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 *
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 *
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 *
 * Input: candidates = [2], target = 1
 * Output: []
 *
 * Input: candidates = [1], target = 1
 * Output: [[1]]
 */
public class CombinationSumOne {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result =  new ArrayList<List<Integer>>();
        LinkedList<Integer> combinations = new LinkedList<>();
        this.dfsTraversal(target, candidates, combinations, 0, result);
        return result;
    }

    public void dfsTraversal(int remainingTarget, int[] candidates, LinkedList<Integer> combinations, int start, List<List<Integer>> result){
        if (remainingTarget == 0) {
            result.add(new ArrayList<>(combinations));
            return;
        } else if (remainingTarget < 0) { // no combination found, reached at the leaf node
            return;
        }
        for(int i=start; i<candidates.length; i++) {
            int newRemainingTarget = remainingTarget - candidates[i];
            combinations.add(candidates[i]);
            this.dfsTraversal(newRemainingTarget, candidates, combinations, i, result);
            // reached at the leaf node or a combination is found
            // so remove the last entry in combination and try next
            // [2,3,6,7], [2,3] -> 2+3 = 5
            // now remove 3 and try others, like [2,6], [2,7]
            // or at leaf node [2,2,2,2], now  try [2,2,2,3]
            combinations.removeLast();
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
        CombinationSumOne cs = new CombinationSumOne();
        List<List<Integer>>  result = cs.combinationSum(new int[]{1,6,3,2,7}, 5);
        System.out.println("\nInput: [1,6,3,2,7] target: 5");
        cs.print(result);
    }
}
