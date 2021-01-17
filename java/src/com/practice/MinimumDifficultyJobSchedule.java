package com.practice;

import java.util.Arrays;

/**
 * You want to schedule a list of jobs in d days. Jobs are dependent
 * (i.e To work on the i-th job, you have to finish all the jobs j where 0 <= j < i).
 *
 * You have to finish at least one task every day. The difficulty of a job schedule
 * is the sum of difficulties of each day of the d days.
 * The difficulty of a day is the maximum difficulty of a job done in that day.
 *
 * Given an array of integers jobDifficulty and an integer d.
 * The difficulty of the i-th job is jobDifficulty[i].
 *
 * Return the minimum difficulty of a job schedule. If you cannot
 * find a schedule for the jobs return -1.
 *
 * Input: jobDifficulty = [6,5,4,3,2,1], d = 2
 * Output: 7
 * Explanation: First day you can finish the first 5 jobs, total difficulty = 6.
 * Second day you can finish the last job, total difficulty = 1.
 * The difficulty of the schedule = 6 + 1 = 7
 *
 * Input: jobDifficulty = [9,9,9], d = 4
 * Output: -1
 * Explanation: If you finish a job per day you will still have a free day.
 * you cannot find a schedule for the given jobs.
 *
 * Input: jobDifficulty = [1,1,1], d = 3
 * Output: 3
 * Explanation: The schedule is one job per day. total difficulty will be 3.
 *
 * Input: jobDifficulty = [7,1,7,1,7,1], d = 3
 * Output: 15
 *
 * Input: jobDifficulty = [11,111,22,222,33,333,44,444], d = 6
 * Output: 843
 * 11,111 ,22,222, 33,333, 44,444
 *
 * 11, 111 ,22, 222, 33, 333,44,444 = 843
 *
 * 11, 111,22,222, 33, 333, 44, 444
 *
 *
 * [[0, 0, 0, 0, 0, 0],
 * [inf, inf, inf, inf, inf, inf]]
 */
public class MinimumDifficultyJobSchedule {

    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (d > n) { // number of jobs are less than the numbrer of days
            return -1; // we can't place a job in each day
        }
        // dp[i][j] means if we want to complete first (j+1) jobs using exact (i+1) days,
        // the minimum difficulty we can get.
        // dp[0][j] means we want to finish first (j+1) jobs using exactly 1 day
        int[][] dp = new int[d+1][n];

        // Initialize the dp table with -1;
//        for(int i=0; i<d+1; i++) {
//            for(int j=0; j<n; j++) {
//                dp[i][j] = -1;
//            }
//        }
        for(int[] p : dp) Arrays.fill(p, -1);
        int res = dfs(jobDifficulty, d, dp, 0);
        return res;
    }

    public int dfs(int[] jobDifficulty, int d, int[][] dp, int idx) {
        if (d == 1){
            int max = 0;
            while(idx < jobDifficulty.length) {
                max = Math.max(max, jobDifficulty[idx++]);
            }
            return max;
        }

        if (dp[d][idx] != -1) {
            return dp[d][idx];
        }
        int max = 0, res = Integer.MAX_VALUE;

        for(int i=idx; i < jobDifficulty.length - d + 1; i++) {
            max = Math.max(max, jobDifficulty[i]);
            res = Math.min(res, max + dfs(jobDifficulty, d-1, dp, i+1));
        }
        return dp[d][idx] = res;
    }

    public static void main(String args[]) {
        MinimumDifficultyJobSchedule obj = new MinimumDifficultyJobSchedule();
        //System.out.println("\nInput: [7, 1, 7, 1, 7, 1], \nOutput: " + obj.minDifficulty(new int[]{7, 1, 7, 1, 7, 1}, 5));

        System.out.println("\nInput: [6, 5, 4, 3, 2, 1], 2 \nOutput: " + obj.minDifficulty(new int[]{6, 5, 4, 3, 2, 1}, 3));
    }
}
