package com.ds.practice.CombinationSum;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class CombinationSum {

    public List<List<Integer>> combine(int[] candidates, int target){
        List<List<Integer>>  results = new ArrayList<List<Integer>>();
        LinkedList<Integer> combination = new LinkedList<>();

        this.backtrack(target, combination, 0, candidates, results);

        return results;
    }

    public void backtrack(int remaining, LinkedList comb, int  start, int[] candidates, List<List<Integer>> results) {
        // if  full filled
        if (remaining ==0) {
            results.add(new ArrayList<Integer>(comb));
            return ;
        } else if (remaining < 0) {
            return ;
        }

        for(int i = start; i<candidates.length; i++) {
            comb.add(candidates[i]);
            this.backtrack(remaining - candidates[i], comb, i, candidates,  results);
            // backtrack, remove the number from the combination
            comb.removeLast();
        }
    }

    public static void main(String args[]) {
        CombinationSum cs = new CombinationSum();
        List<List<Integer>>  result = cs.combine(new int[]{1,6,3,2,7}, 5);
        System.out.println("Input: [1,6,3,2,7,0] target=5");
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        result.forEach(res -> {
            sb.append("[");
            res.forEach(item -> {
                sb.append(item+",");
            });
            sb.setLength(sb.length()-1);
            sb.append("]");
        });
        sb.append("]");
        System.out.println(sb.toString());


    }
}
