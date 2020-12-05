package com.ds.practice.SumOfThree;
import java.util.*;

public class SumOfThree {

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();
        Map<Integer, Integer> seen = new HashMap<>();

        for(int i = 0; i<nums.length; i++) {
            if (duplicates.add(nums[i])) { // if not added before /no duplicate
                for(int j =i+1; j<nums.length; j++) {
                    int complement = -1* (nums[i]+nums[j]);
                    if (seen.containsKey(complement) && seen.get(complement) == i) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                        Collections.sort(triplet);
                        result.add(triplet);
                    }
                    seen.put(nums[j], i);
                }
            }
        }

        return new ArrayList(result);
    }
    public static void main(String args[]) {

        int[] nums = new int[]{-1,0,1,2,-1,-4};
        SumOfThree s = new SumOfThree();
        List<List<Integer>> res = s.threeSum(nums);

        res.forEach(list -> {
            list.forEach(num -> System.out.print(num+","));
            System.out.println("");
        });


    }
}
