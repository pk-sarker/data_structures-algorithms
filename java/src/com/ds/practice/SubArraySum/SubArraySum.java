package com.ds.practice.SubArraySum;

import java.util.HashMap;

public class SubArraySum {

    public int subarraySumBruteForce(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length, count = 0;
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<=n;j++) {
                int sum = 0;
                // calculate sum between i and j
                for(int l=i; l<j; l++) {
                    sum += nums[l];
                }
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Store the sums in a array and use it
     */
    public int subarraySumOpt1(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length, count = 0;
        int[] sums = new int[n+1];
        sums[0] = 0;
        for(int i=1; i<=n; i++) {
            sums[i] = sums[i-1]+nums[i-1];
        }

        for(int i=0; i<n; i++) {
            for (int j=i+1; j<=n; j++) {
                if (sums[j]-sums[i] ==  k) {
                    count++;
                }
            }
        }

        return count;
    }


    /**
     * Remove extra spaces
     */
    public int subarraySumOpt2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length, count = 0;

        //int sume = 0;
        for(int i=0; i<n; i++) {
            int sum = 0;
            for (int j=i; j<n; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }



    public int subarraySumOptHashMap(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) +  1);
        }
        return count;
    }

    public static void main(String args[]) {
        SubArraySum sas = new SubArraySum();
        System.out.println("\nInput: [1,1,1] k=2 \nOutput: "+sas.subarraySumBruteForce(new int[]{1,1,1}, 2));
        System.out.println("\nInput: [1,2,3] k=3 \nOutput: "+sas.subarraySumBruteForce(new int[]{1,2,3}, 3));
        System.out.println("\nInput: [0,1,2,3,4] k=4 \nOutput: "+sas.subarraySumBruteForce(new int[]{0,1,2,3,4}, 4));
        System.out.println("\nInput: [0,1,3,2,2,4] k=4 \nOutput: "+sas.subarraySumBruteForce(new int[]{0,1,3,2,2,4}, 4));

        System.out.println("\nInput: [0,1,3,2,2,4] k=4 \nOutput: "+sas.subarraySumOpt1(new int[]{0,1,3,2,2,4}, 4));

        System.out.println("\nInput: [0,1,3,2,2,4] k=4 \nOutput: "+sas.subarraySumOptHashMap(new int[]{0,1,3,2,2,4}, 4));
        System.out.println("\nInput: [0,1,3,2,2,4] k=4 \nOutput: "+sas.subarraySumOptHashMap(new int[]{0,1,3,2,2,4}, 4));



    }
}
