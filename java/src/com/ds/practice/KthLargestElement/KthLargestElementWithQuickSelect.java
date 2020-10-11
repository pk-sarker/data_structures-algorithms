package com.ds.practice.KthLargestElement;

public class KthLargestElementWithQuickSelect {

    public int findKthLargestElement(int[] arr, int k) {
        int kthMax = arr.length - k;

        return quickSelect(arr, 0, arr.length-1, kthMax);
    }

    private int quickSelect(int[] arr, int left, int right, int k) {
        if(arr.length ==0 ) {
            return 0;
        }
        if (left == right) {
            return arr[left];
        }

        int pivot = partition(arr, left, right);

        if (k==pivot) {
            return arr[k];
        } else if(k > pivot) {
            return quickSelect(arr, pivot+1, right, k);
        } else {
            return quickSelect(arr, left, pivot-1, k);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // initial value of the pivot
        int pivotIndex = low;  // final position of the pivot

        for(int i=low; i<arr.length; i++) {
            if (arr[i] < pivot){
                int tmp = arr[pivotIndex];
                arr[pivotIndex] = arr[i];
                arr[i] = tmp;
                pivotIndex++;
            }
        }
        int tmp = arr[high];
        arr[high] = arr[pivotIndex];
        arr[pivotIndex] = tmp;

        return pivotIndex;
    }
}
