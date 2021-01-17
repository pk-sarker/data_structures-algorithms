package com.ds.practice.CoinChange;

import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (count[rem - 1] != 0) return count[rem - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }

    private int coinChangeDP(int[] coins, int amount) {
        return dp(coins, coins.length, amount);
    }

    private int dp(int coins[], int numCoins, int amount) {
        //Time complexity of this function: O(mn)
        //Space Complexity of this function: O(n)

        // table[i] will be storing the number of solutions
        // for value i. We need n+1 rows as the table is
        // constructed in bottom up manner using the base
        // case (n = 0)
        int[] table = new int[amount + 1];

        // Initialize all table values as 0
        Arrays.fill(table, 0);   //O(n)

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to
        // the value of the picked coin
        for (int i = 0; i < numCoins; i++){
            for (int j = coins[i]; j <= amount; j++) {
                table[j] += table[j - coins[i]];
                print(table);
            }
        }
        return table[amount];
    }

    public int coinChangeDP2(int[] coins, int amount) {
        int max = amount + 1;

        // table[i] will be storing the number of solutions
        // for value i. We need n+1 rows as the table is
        // constructed in bottom up manner using the base
        // case (n = 0)
        int[] dp = new int[amount + 1];
        // Initialize all table values as 0
        Arrays.fill(dp, max);
        // Base case (If given value is 0)
        dp[0] = 0;

        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to
        // the value of the picked coin
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                System.out.println("-> i="+i+", j="+j + " coins[j]="+coins[j]+", i-coins[j]="+(i-coins[j])+" dp[i]="+dp[i]);
                print(dp);
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    System.out.println("--> dp[i]="+dp[i]+" (dp[i-coins[j]]+1)" + (dp[i - coins[j]] + 1));
                }
            }
        }
        print(dp);
        return dp[amount] > amount ? -1 : dp[amount];
    }

    private void print(int[] table) {
        System.out.println("");
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int sum: table) {
            sb.append(sum +", ");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
    public static void main(String args[]) {
        CoinChange cc = new CoinChange();
//        System.out.println(cc.coinChange(new int[]{1,2,3}, 5));
//
//        System.out.println(cc.coinChangeDP(new int[]{1,2,3}, 5));
        System.out.println(cc.coinChangeDP2(new int[]{1,2,3}, 5));


    }
}
