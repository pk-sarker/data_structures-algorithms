package com.ds.practice.MedianOfStream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedianOfStream {
    List<Integer> store = new ArrayList<>();
    List<Integer> store2 = new ArrayList<>();
    int median = -1;
    public void addNum(int num) {
        store.add(num);
    }

    public double findMedian() {
        Collections.sort(store);
        int n = store.size();
        if (n%2==1) {
            int i = n/2;
            return store.get(i);
        }
        int i = n/2;
        System.out.println("i="+i);
        return (store.get(i) + store.get(i-1))/2.0;
    }

    public void addNum2(int num) {
        System.out.println("add "+ num);
        if (store2.isEmpty()) {
            store2.add(num);
        } else {
            // insert
            int key = num;
            int j = store2.size()-1;
            while(j>=0 && store2.get(j) > key) {
                store2.add(j+1, store2.get(j));
                j--;
            }
            store2.add(j+1, key);
            System.out.println(store2);
        }

    }

    public double findMedian2() {
        int n = store2.size();
        if (n%2==1) {
            int i = n/2;
            return store2.get(i);
        }
        int i = n/2;
        System.out.println("i="+i);
        return (store2.get(i) + store2.get(i-1))/2.0;
    }



    public static void main(String args[]) {
        MedianOfStream ms = new MedianOfStream();
        ms.addNum(1);
        ms.addNum(2);
        System.out.println("\n"+ms.store+"\nMedian:"+ms.findMedian());
        ms.addNum(3);
        System.out.println("\n"+ms.store+"\nMedian:"+ms.findMedian());

        System.out.println("-- -- -- -- --");
        ms.addNum2(2);
        ms.addNum2(1);
        System.out.println("\n"+ms.store2+"\nMedian:"+ms.findMedian2());
        ms.addNum2(3);
        System.out.println("\n"+ms.store2+"\nMedian:"+ms.findMedian2());
        ms.addNum2(2);
        System.out.println("\n"+ms.store2+"\nMedian:"+ms.findMedian2());
    }
}
