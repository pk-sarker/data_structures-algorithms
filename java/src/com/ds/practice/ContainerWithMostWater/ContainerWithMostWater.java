package com.ds.practice.ContainerWithMostWater;

public class ContainerWithMostWater {

    public int findMaxContainerSizeBruteForce(int[] heights) {
        int maxArea = 0;
        int n = heights.length;
        if (heights.length<=0) {
            return maxArea;
        }
        for(int i=0; i<n;i++) {
            for(int j=i+1; j<n;j++) {
                int area = (j-i) * Math.min(heights[i],heights[j]);
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }

    public int findMaxContainerSize(int[] heights) {
        int maxArea = 0;
        int n = heights.length;
        int start=0, end = n-1;


        while(start < n && end>start) {
            int area = (end-start) * Math.min(heights[start],heights[end]);
            maxArea = Math.max(area, maxArea);
            System.out.println("("+start+","+end+") -> " + maxArea);
            if (heights[start] < heights[end]) {
                start++;
            } else {
                end--;
            }
        }

        return maxArea;
    }

    public static void main(String args[]) {

        ContainerWithMostWater obj = new ContainerWithMostWater();
        System.out.println("Input:[1,8,6,2,5,4,8,3,7]\nOutput:"+obj.findMaxContainerSizeBruteForce(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println("Input:[1,8,6,2,5,4,8,3,7]\nOutput:"+obj.findMaxContainerSize(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println("Input:[3,9,6,2,5,11,8,3,7]\nOutput:"+obj.findMaxContainerSize(new int[]{3,15,6,2,5,20,8,3,7}));
    }
}
