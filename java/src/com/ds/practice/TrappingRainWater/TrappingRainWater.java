package com.ds.practice.TrappingRainWater;

public class TrappingRainWater {

    /**
     * Intuition
     *
     * Do as directed in question. For each element in the array, we find the maximum level of water it can trap after the rain,
     * which is equal to the minimum of maximum height of bars on both the sides minus its own height.
     *
     * Algorithm
     * 1. Initialize result=0
     * 2. Iterate the array from left to right:
     * 3.    Initialize left_max=0 and right_max=0
     * 4.    Iterate from the current element to the beginning of array updating:
     * 5.         left_max=max(left_max,height[j])
     * 6.    Iterate from the current element to the end of array updating:
     * 7.         right_max=max(right_max,height[j])
     * 8.    Add min(left_max,right_max)−height[i] to result
     *
     * @param height
     * @return
     */
    public int bruteForce(int[] height) {
        int res = 0;
        for(int i=0; i<height.length;i++) {
            int leftMax = 0;
            int rightMax = 0;
            for(int j=i;j>=0;j--) {
                leftMax =  Math.max(leftMax,  height[j]);
            }

            for(int k=i;k<height.length;k++) {
                rightMax =  Math.max(rightMax,  height[k]);
            }
            res = res + Math.min(leftMax,rightMax) - height[i];
        }
        return res;
    }

    /**
     * In the brute force approach we are iterating over all the left  elements of current  position and all the  elements to the right.
     * We can store  the  result and re-use,for example if you know  the maximum of first 2 elements(ar[0:2]) then to find the
     * maximum of first 3 elements will be just compare 3rd element with the  maximum of first 2 elements(ar[0:2]).
     *
     * The idea is to store the the max values at each position and reuse them to find the next maximum
     * For  example:
     * left_max of the first element = ar[0] -> stored  in left_max[0] = ar[0]
     * For  left_max[i] =  max(left_max[i-1], height[i])
     *
     * For right side
     * right_max[n-1]  = ar[n-1] // initialize
     * Loop n-2 to 0
     *   right_max[i] = max(right_max[i+1], height[i])
     *
     * Complexity analysis
     *
     * Time complexity: O(n).
     *
     * 	We store the maximum heights upto a point using 2 iterations of O(n)O(n) each.
     * 	We finally update result using the stored values in O(n).
     *
     * Space complexity: O(n) extra space.
     */
    public int dp(int[] height) {
        int n = height.length;
        if (n<=0) {
            return 0;
        }
        int[] leftMax =  new int[n];
        int[] rightMax = new int[n];
        int res = 0;
        leftMax[0] = height[0];
        for(int i=1; i<height.length; i++) {
            leftMax[i]  = Math.max(height[i], leftMax[i-1]);
        }
        rightMax[n-1] =  height[n-1];

        for(int i=n-2; i>=0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }
        for(int i=1; i<n; i++) {
            res = res + Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return res;
    }

    /**
     * Using stacks
     * Instead of storing the largest bar upto an index as in Approach 2, we can use stack
     * to keep track of the bars that are bounded by longer bars and hence, may store water.
     * Using the stack, we can do the calculations in only one iteration.
     *
     * We keep a stack and iterate over the array. We add the index of the bar to the stack
     * if bar is smaller than or equal to the bar at top of stack, which means that the current bar
     * is bounded by the previous bar in the stack. If we found a bar longer than that at the top,
     * we are sure that the bar at the top of the stack is bounded by the current bar and a previous bar in the stack,
     * hence, we can pop it and add resulting trapped water to \text{ans}ans.
     */

    public int twoPointer(int[] height) {
        int n = height.length;
        if (n<=0) {
            return 0;
        }
        int left = 0, right = n-1, res = 0;
        int leftMax = 0, rightMax = 0;

        while(left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax =  height[left];
                } else {
                    res = res + (leftMax - height[left]);
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    res = res + (rightMax-height[right]);
                }
                right--;
            }
        }

        return res;
    }
}
