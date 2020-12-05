package com.ds.practice.meetingroom;
import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoom {

    public boolean canAttendMeetings(int meetings[][]) {
        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        //
        for(int i=0; i < meetings.length-1; i++ ){
            if ((meetings[i][0] >= meetings[i+1][0] && meetings[i][0] < meetings[i+1][1]) ||
                    (meetings[i+1][0] >= meetings[i][0] && meetings[i+1][0] < meetings[i][1])) {
                return false;
            }
        }
        return true;
    }

    public boolean canAttendMeetings2(int meetings[][]) {
        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        //
        for(int i=0; i < meetings.length-1; i++ ){
            if (meetings[i+1][0] < meetings[i][1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        MeetingRoom mr = new MeetingRoom();
        int [][] meetings = new int[][]{{0, 30},{5, 10},{15, 20}};
        System.out.println("Input: [[0, 30],[5, 10],[15, 20]]\nOutput: "+mr.canAttendMeetings(meetings));

        System.out.println("Input: [[0, 10],[10, 11],[12, 15]]\nOutput: "+mr.canAttendMeetings(new int[][]{{0, 10},{10, 11},{12, 15}}));
        System.out.println("Input: [[0, 10],[10, 11],[12, 15]]\nOutput: "+mr.canAttendMeetings2(new int[][]{{0, 10},{10, 11},{12, 15}}));
    }
}
