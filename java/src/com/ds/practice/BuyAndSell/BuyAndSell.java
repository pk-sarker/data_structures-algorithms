package com.ds.practice.BuyAndSell;

import javax.management.remote.JMXAddressable;

public class BuyAndSell {

    /**
     * Complexity is n^2
     *
     * @param price
     * @return
     */
    public int getMaxProfit(int[] price) {
        int maxProfit = 0;
        if (price.length == 0){
            return 0;
        }
        int i = 0, n = price.length;

        while(i<n) {
            int sellingPrixe = price[i];
            for(int j=0; j<i; j++) {
                if (price[j] < sellingPrixe) {
                    maxProfit = Math.max(maxProfit, sellingPrixe-price[j]);
                }
            }
            i++;
        }

        return maxProfit;
    }

    public int getMaxProfitSinglePass(int[] price) {
        int maxProfit = 0, n = price.length;
        int minPrice = Integer.MAX_VALUE; // 2^31-1
        for(int i=0;i<n;i++) {
            if (price[i]<minPrice) {
                minPrice = price[i];
            } else if (price[i]-minPrice > maxProfit) {
                maxProfit = price[i]-minPrice;
            }
        }

        return maxProfit;
    }

    public static void main(String args[]) {
        BuyAndSell bs = new  BuyAndSell();
        System.out.println("\nInput: [7,1,5,3,6,4,3]\nMax Profit: " + bs.getMaxProfit(new int[]{7,1,5,3,6,4,3}));
        System.out.println("\nInput: [7,6,5,3,2,1}]\nMax Profit: " + bs.getMaxProfit(new int[]{7,6,5,3,2,1}));
        System.out.println("\nInput: [1,2,3,4,5,6,7}]\nMax Profit: " + bs.getMaxProfit(new int[]{1,2,3,4,5,6,7}));
        System.out.println("\nInput: [1,1,1,1,1,1,1}]\nMax Profit: " + bs.getMaxProfit(new int[]{1,1,1,1,1,1,1}));
        System.out.println("--------- --------- --------- --------- --------- --------- ");
        System.out.println("\nInput: [7,1,5,3,6,4,3]\nMax Profit: " + bs.getMaxProfitSinglePass(new int[]{7,1,5,3,6,4,3}));
        System.out.println("\nInput: [7,6,5,3,2,1}]\nMax Profit: " + bs.getMaxProfitSinglePass(new int[]{7,6,5,3,2,1}));
        System.out.println("\nInput: [1,2,3,4,5,6,7}]\nMax Profit: " + bs.getMaxProfitSinglePass(new int[]{1,2,3,4,5,6,7}));
        System.out.println("\nInput: [1,1,1,1,1,1,1}]\nMax Profit: " + bs.getMaxProfitSinglePass(new int[]{1,1,1,1,1,1,1}));



    }
}
