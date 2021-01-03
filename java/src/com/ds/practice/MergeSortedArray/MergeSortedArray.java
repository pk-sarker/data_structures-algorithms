package com.ds.practice.MergeSortedArray;

public class MergeSortedArray {

    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        // copy nums1 to a temporary
        int[] num = new int[m];
        System.arraycopy(nums1, 0, num, 0, m);
        // pointers for the arrays:
        // p1 -> nums1, p2 -> nums2, p->num
        int p1  = 0, p2 = 0, p = 0;
        while((p1 < m) && (p2 < n)) {
            nums1[p++] = num[p1] < nums2[p2] ? num[p1++]:nums2[p2++];
        }

        // check for remaining
        if (p1 < m) {
            System.arraycopy(num, p1, nums1, p, m + n - p1 - p2);
        }
        if (p2 < n) {
            System.arraycopy(nums2, p2, nums1, p, m + n - p1 - p2);
        }

        return nums1;
    }

    public int[] merge1(int[] nums1, int m, int[] nums2, int n) {
        // Make a copy of nums1.
        int [] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);

        // Two get pointers for nums1_copy and nums2.
        int p1 = 0;
        int p2 = 0;

        // Set pointer for nums1
        int p = 0;

        // Compare elements from nums1_copy and nums2
        // and add the smallest one into nums1.
        while ((p1 < m) && (p2 < n))
            nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];

        // if there are still elements to add
        if (p1 < m)
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        if (p2 < n)
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);

        return nums1;
    }

    public String print(int[] num) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<num.length; i++) {
            sb.append(num[i]+", ");
        }

        return sb.toString();
    }
    public static void main(String args[]) {
        MergeSortedArray msa = new MergeSortedArray();
        //msa.merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5}, 2);
        //int[] num = msa.merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5}, 2);
        System.out.println("\nInput: [1,2,3,0,0,0] m=3 [2,5] n=2\nMerged: " +msa.print(msa.merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5}, 2)));
    }
}
