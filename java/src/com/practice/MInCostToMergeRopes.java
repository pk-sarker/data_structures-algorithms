package com.practice;

import java.util.PriorityQueue;

/**
 * Given ‘N’ ropes with different lengths, we need to connect these ropes into one big rope with minimum cost.
 * The cost of connecting two ropes is equal to the sum of their lengths.
 *
 * Input: [1, 3, 11, 5]
 * Output: 33
 * Explanation: First connect 1+3(=4), then 4+5(=9), and then 9+11(=20). So the total cost is 33 (4+9+20)
 *
 * Input: [3, 4, 5, 6]
 * Output: 36
 * Explanation: First connect 3+4(=7), then 5+6(=11), 7+11(=18). Total cost is 36 (7+11+18)
 *
 */
public class MInCostToMergeRopes {
    public static int minimumCostToConnectRopes(int[] ropeLengths) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a, b) -> a - b);
        for(int num: ropeLengths) {
            heap.offer(num);
        }
        int minCost = 0;
        while(!heap.isEmpty() && heap.size() > 1) {
            int n1 = heap.poll(), n2 = heap.poll();
            minCost += (n1+n2);
            if (!heap.isEmpty()) {
                heap.offer(n1+n2);
            }
        }
        if (!heap.isEmpty()) {
            minCost += heap.poll();
        }

        return minCost;
    }

    public static void main(String args[]) {
        int result = MInCostToMergeRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5 });
        System.out.println("Minimum cost to connect ropes: " + result);
//        result = MInCostToMergeRopes.minimumCostToConnectRopes(new int[] { 3, 4, 5, 6 });
//        System.out.println("Minimum cost to connect ropes: " + result);
//        result = MInCostToMergeRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5, 2 });
//        System.out.println("Minimum cost to connect ropes: " + result);
    }
}
