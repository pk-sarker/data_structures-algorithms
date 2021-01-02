package com.ds.practice.CombinationSum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
 *  - Only numbers 1 through 9 are used.
 *  - Each number is used at most once.
 *
 * Return a list of all possible valid combinations. The list must not contain the same combination twice,
 * and the combinations may be returned in any order.
 *
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Explanation:
 * 1 + 2 + 4 = 7
 * There are no other valid combinations.
 *
 * Input: k = 3, n = 9
 * Output: [[1,2,6],[1,3,5],[2,3,4]]
 * Explanation:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * There are no other valid combinations.
 *
 * Input: k = 4, n = 1
 * Output: []
 * Explanation: There are no valid combinations. [1,2,1] is not valid because 1 is used twice.
 *
 * Input: k = 3, n = 2
 * Output: []
 * Explanation: There are no valid combinations.
 */
public class CombinationSumThree {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> combinations = new LinkedList<>();
        this.dfsTraversal(n, k, combinations, 0, result);
        return result;
    }

    public void dfsTraversal(int remainingTarget, int k, LinkedList<Integer> combinations, int start, List<List<Integer>> result) {
        if (remainingTarget==0 && k==combinations.size()) {
            result.add(new ArrayList<>(combinations));
            return;
        } else if (remainingTarget < 0 || combinations.size()>=k) {
            return;
        }
        for(int i=start; i<9; i++) {
            combinations.add(i+1);
            this.dfsTraversal(remainingTarget-i-1, k, combinations, i+1, result);
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
        CombinationSumThree cs = new CombinationSumThree();
        List<List<Integer>> res = cs.combinationSum3(3,7);
        System.out.println("\nInput: k=3 n=7");
        cs.print(res);

        List<List<Integer>> res1 = cs.combinationSum3(3,9);
        System.out.println("\nInput: k=3 n=9");
        cs.print(res1);

    }
}
