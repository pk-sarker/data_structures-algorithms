package com.ds.practice.SearchInRotatedArray;

public class SearchInRotatedArray {

    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n<=0) {
            return -1;
        }
        if (n == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }

        int start = 0, end = n-1;

        while(start <= end) {
            int mid = start + (end - start)/2;
            //System.out.print("mid: " + mid);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > nums[start]) {
                if (target>= nums[start] && target <= nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    if (mid != 0) {
                        end = mid - 1;
                    } else {
                        start++;
                    }
                }

            }
        }

        return -1;
    }
    public static void main(String args[]) {
        SearchInRotatedArray sira = new SearchInRotatedArray();
        System.out.println("\nInput: [4, 5, 6, 7, 9, 0, 1, 2, 3]");
        System.out.println(" Search 4 \n Output: "+sira.search(new int[]{4,5,6,7,9,0,1,2,3}, 4));
        System.out.println(" Search 5 \n Output: "+sira.search(new int[]{4,5,6,7,9,0,1,2,3}, 5));
        System.out.println(" Search 1 \n Output: "+sira.search(new int[]{4,5,6,7,9,0,1,2,3}, 1));

        System.out.println("\n [3, 1] Search 1 \n Output: "+sira.search(new int[]{3, 1}, 1));
        System.out.println("\n [3, 1] Search 3 \n Output: "+sira.search(new int[]{3, 1}, 3));
        System.out.println("\n [1, 3] Search 3 \n Output: "+sira.search(new int[]{1, 3}, 3));
        System.out.println("\n [1, 3] Search 1 \n Output: "+sira.search(new int[]{1, 3}, 1));
        System.out.println("\n [5,1,2,3,4] Search 1 \n Output: "+sira.search(new int[]{5,1,2,3,4}, 1));

    }
}
