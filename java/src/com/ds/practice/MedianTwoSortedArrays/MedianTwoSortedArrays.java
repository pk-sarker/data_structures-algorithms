package com.ds.practice.MedianTwoSortedArrays;

/**
            A              m                        B                   n
|--------------------------|        |-----------------------------------|
|          | i |           |        |               | j |               |
|--------------------------|        |-----------------------------------|

 (A+B)/2  =>  A/2 + B/2
 st = 0, end = m
 init i = A/2 => m-0/2

 i+j = m-i+n-j = m-i + n-j + 1
 2j = m+n+1 - 2i
 j = (m+n+1)/2 - i
 * to keep j positive make sure to n > m
 *
 * len(A[0:i-1] + B[0:j-1]) = len(A[i:m]+B[j:n])
 * max(A[0:i-1] + B[0:j-1]) <= min(A[i:m]+B[j:n])
 *
 * To ensure max(A[0:i-1] + B[0:j-1]) <= min(A[i:m]+B[j:n])
 *  B[j-1]<=A[i] and A[i-1] <= B[j]
 *
 *  // i is small, move i to right to have a bigger number(because numbers in A and B are sorted)
 *  // so the new range is imin=i+1 to imax=m
 *  if B[j-1]>A[i] :
 *      imin = i + 1
 *
 *  // i is bigger, move i to left  to have smaller element to satisfy A[i-1] <= B[j]
 *  // the new range is imin=imin to imax=i-1;
 *  if A[i-1] > B[j]:
 *      imax = i - 1
 *
 */
public class MedianTwoSortedArrays {

    public double findMedian(int num1[], int[] num2) {
        int m = num1.length, n = num2.length;

        if (m>n) { // swap m and n so that n > m
            int temp = m;
            m = n;
            n = temp;
            int[] num = num1;
            num1 = num2;
            num2 = num;
        }

        int iMin = 0, iMax = m;
        int half = (m+n+1)/2;

        while(iMin<=iMax) {
            int i = (iMin+iMax)/2;
            int j = half - i;

            if (i<iMax && num2[j-1]>num1[i]) {
                iMin = i + 1;
            } else if (i>iMin && num1[i-1] > num2[j]) {
                iMax = i - 1;
            } else {
                int leftMax = 0;
                if (i == 0) {
                    leftMax = num2[j-1];
                } else if (j == 0) {
                    leftMax = num1[i-1];
                } else {
                    leftMax = Math.max(num1[i-1], num2[j-1]);
                }

                if ((m+n)%2==1) {
                    return leftMax;
                }

                int rightMin = 0;
                if (i == m) {
                    rightMin = num2[j];
                } else if (j == n) {
                    rightMin = num1[i];
                } else {
                    rightMin = Math.min(num1[i], num2[j]);
                }
                return (leftMax+rightMin)/2.0;
            }
        }
        return 0.0;
    }

    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
    public static void main(String args[]) {
        MedianTwoSortedArrays mtsa = new MedianTwoSortedArrays();

        System.out.println("\nInput: A=[1,3] B=[2]\nMedian:"+ mtsa.findMedian(new int[]{1,3},new int[]{2}));
        System.out.println("\nInput: A=[1,2] B=[3,4]\nMedian:"+ mtsa.findMedian(new int[]{1,2},new int[]{3,4}));

        System.out.println("-------------------------------------------------");
        System.out.println("\nInput: A=[1,2] B=[3,4]\nMedian:"+ mtsa.findMedianSortedArrays(new int[]{1,2},new int[]{3,4}));


    }
}
