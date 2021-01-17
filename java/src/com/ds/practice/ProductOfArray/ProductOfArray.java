package com.ds.practice.ProductOfArray;

public class ProductOfArray {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param nums
     * @return
     */
    public int[] findProducts(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] leftProduct = new int[n];
        int[] rightProduct = new int[n];
        leftProduct[0]=1;
        for(int i=1; i<n; i++) {
            leftProduct[i] = nums[i-1] * leftProduct[i-1];
        }

        rightProduct[n-1]=1;
        for(int i=n-2; i>=0; i--) {
            rightProduct[i] = nums[i+1] * rightProduct[i+1];
        }

        for(int i=0; i<n; i++) {
            result[i] = leftProduct[i] * rightProduct[i];
        }
        return result;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @param nums
     * @return
     */
    public int[] findProductsConstantSpace(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[0]=1;
        for(int i=1; i<n; i++) {
            result[i] = nums[i-1] * result[i-1];
        }
        int rightNum = 1;
        for(int i=n-1; i>=0; i--) {
            result[i] = result[i] * rightNum;
            rightNum = rightNum * nums[i];
        }
        return result;
    }
    public static void main(String args[]) {
        ProductOfArray pa = new ProductOfArray();

    }
}
