package com.ds.practice.MinMeetingRoom;

import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Arrays;

public class MinMeetingRoom {


    public int minMeetingRooms(int[][] meetings) {
        // base case - If meetings array is empty.
        if (meetings.length <=0) {
            return 0;
        }

        // Create MinHeap
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(meetings.length, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });

        // Sort meetings by start time
        Arrays.sort(meetings, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        // Add first meetings end time in the heap
        minHeap.add(meetings[0][1]);

        for(int i = 1; i< meetings.length; i++) {
            if (meetings[i][0]>=minHeap.peek()) {
                minHeap.poll();
            }
            minHeap.add(meetings[i][1]);
        }
        return minHeap.size();
    }


    public static void main(String args[]) {
        int[][] meetings = new int[][]{{1, 10}, {2, 7}, {3, 19}, {8, 12}, {10, 20}, {11, 30}};

        MinMeetingRoom mmr = new MinMeetingRoom();

        System.out.println("Input: {1, 10}, {2, 7}, {3, 19}, {8, 12}, {10, 20}, {11, 30} \nOutput: " + mmr.minMeetingRooms(meetings));


        System.out.println("Input: {9, 11}, {11, 12}, {9, 13}, {8, 10}} \nOutput: " + mmr.minMeetingRooms(new int[][]{{9, 11}, {11, 12}, {9, 13}, {8, 10}}));
            // [[9, 11], [7, 9], [11, 12], [12, 13]]
        System.out.println("Input: {9, 11}, {7, 9}, {12, 13}, {11, 12}} \nOutput: " + mmr.minMeetingRooms(new int[][]{{9, 11}, {7, 9}, {12, 13}, {11, 12}}));

        System.out.println("Input: {9, 12}, {10, 11}, {10, 12}, {8, 11}} \nOutput: " + mmr.minMeetingRooms(new int[][]{{9, 12}, {10, 11}, {10, 12}, {8, 11}}));

    }
}
