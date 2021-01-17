package com.ds.practice.MoveZeros;

public class MoveZeros {

    public void pushZeros(int nums[]) {
        int lastNonZeroPos = 0;

        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[lastNonZeroPos];
                nums[lastNonZeroPos] = tmp;
                lastNonZeroPos++;
            }
        }
        System.out.println(nums.toString());
        StringBuilder sb = new StringBuilder();
        for(int i =0 ; i< nums.length; i++) {
            sb.append(i);
            if (i<nums.length-1) {
                sb.append(", ");
            }
        }
        System.out.println(sb.reverse().toString());
    }
    public static void main(String args[]) {
        MoveZeros mz = new MoveZeros();
        mz.pushZeros(new int[]{1,2,0,3,4});
    }
}
