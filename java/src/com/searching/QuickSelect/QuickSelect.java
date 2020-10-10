package com.searching.QuickSelect;

public class QuickSelect {

    public int select(int[] arr, int left, int right, int k) {
        // base case
        if (arr.length <=0){
            return 0;
        }
        // If there is only one element in the array
        // return that
        if (left == right) {
            return arr[left];
        }

        int pivot = partition(arr, left, right);

        if (pivot == k)  {
            return arr[pivot];
        } else if (pivot < k) { // check in right of the pivot if k is greater than the pivot.
            return select(arr, pivot+1, right, k);
        } else {  // check in left of the pivot if k is less than the pivot.
            return select(arr,  left, pivot-1, k);
        }
    }


    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high], pivotLoc = low;
        for(int j = low; j< arr.length; j++) {
            if (arr[j] < pivot) {
                int tmp = arr[pivotLoc];
                arr[pivotLoc] = arr[j];
                arr[j] = tmp;
                pivotLoc++;
            }
        }
        int tmp = arr[high];
        arr[high] = arr[pivotLoc];
        arr[pivotLoc] = tmp;

        return pivotLoc;
    }

    public int partition1 (int[] arr, int low, int high)
    {
        int pivot = arr[high], pivotloc = low;
        for (int i = low; i <= high; i++)
        {
            // inserting elements of less value
            // to the left of the pivot location
            if(arr[i] < pivot)
            {
                int temp = arr[i];
                arr[i] = arr[pivotloc];
                arr[pivotloc] = temp;
                pivotloc++;
            }
        }

        // swapping pivot to the final pivot location
        int temp = arr[high];
        arr[high] = arr[pivotloc];
        arr[pivotloc] = temp;

        return pivotloc;
    }


    static void print(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    public static void main(String args[]) {
        QuickSelect qs = new QuickSelect();
        int[] arr = new int[]{5, 9, 3, 8, 4, 7, 1};
        int second = qs.select(arr, 0, arr.length-1, 2);
        System.out.println("Input: [5, 9, 3, 8, 4, 7, 1], k=2 \n kth: "+second);
        print(arr);
        
        int fourth = qs.select(arr, 0, arr.length-1, 4);
        System.out.println("Input: [5, 9, 3, 8, 4, 7, 1], k=4 \n kth: "+fourth);
        print(arr);
    }
}
