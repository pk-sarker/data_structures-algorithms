package com.sorting.Quicksort;

public class Quicksort {

    public void sort(int[] ar, int low, int high) {
        if (low < high) {
            int p = partition(ar, low, high);
            System.out.println("Partition " + p);
            sort(ar, low, p-1);
            sort(ar, p+1, high);
        }
    }

    /**
     *  Reorder the array so that all elements with values less than the pivot come before the pivot,
     *  while all elements with values greater than the pivot come after it (equal values can go either way).
     *  After this partitioning, the pivot is in its final position
     * @param ar
     * @param low
     * @param high
     * @return
     */
    public int partition(int[] ar, int low, int high) {
        // Pick an element, called a pivot
        int pivot = ar[high];

        int i = low;
        for(int j = low; j<high; j++) {
            if (ar[j] < pivot) {
                int tmp = ar[i];
                ar[i] = ar[j];
                ar[j] = tmp;
                i++;
            }
        }
        int tmp = ar[i];
        ar[i] = ar[high];
        ar[high] = tmp;
        return i;
    }
// 5,9,3,8,4,7,1
    static void print(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    public static void main(String args[]) {
        int[] ar = new int[]{10, 7, 8, 9, 1, 5};
        print(ar);
        Quicksort qs = new Quicksort();
        qs.sort(ar, 0, ar.length-1);
        System.out.println("Sorted array: ");
        print(ar);

        int[] arr = new int[]{5,9,3,8,4,7,1};
        qs.sort(arr, 0, arr.length-1);
        System.out.println("Sorted array: ");
        print(arr);

    }
}
