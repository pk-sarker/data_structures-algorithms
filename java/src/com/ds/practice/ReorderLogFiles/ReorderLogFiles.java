package com.ds.practice.ReorderLogFiles;
import com.ds.practice.ReverseLinkedList.ListNode;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderLogFiles {

    public String[] reorder(String[] logs) {
        Comparator<String> comp = new Comparator<String>() {
            public int compare(String s1, String s2){
                String[] s1Split = s1.split(" ", 2);
                String[] s2Split = s2.split(" ", 2);

                boolean isDigit1 = false, isDigit2 = false;
                isDigit1 = Character.isDigit(s1Split[1].charAt(0));
                isDigit2 = Character.isDigit(s2Split[1].charAt(0));
                if (!isDigit1 && !isDigit2) {
                    int comRes = s1Split[1].compareTo(s2Split[1]);
                    if (comRes != 0) {
                        return comRes;
                    }
                    // logs of same content, compare the identifiers
                    return s1Split[0].compareTo(s2Split[0]);
                }

                if (!isDigit1 && isDigit2) {
                    // the letter-log comes before digit-logs
                    return -1;
                } else if (isDigit1 && !isDigit2) {
                    return 1;
                } else {
                    // case 3). both logs are digit-log
                    return 0;
                }
            }
        };

        Arrays.sort(logs, comp);
        return logs;
    }

    public void compare1(){
        Comparator<Integer> comp1 = new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {

                if (a>b) {
                    return 1;
                } else {
                    return -1;
                }
            }
        };

        Comparator<Integer> comp2 = new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        };

        //Integer[] list1 = new Integer[]{1,2,3,4,5};
        Integer[] list1 = new Integer[]{1,2,3,4,5};
        Arrays.sort(list1, comp1);
        //System.out.print(list1.toString());
        for(int i=0; i<list1.length;i++) {
            System.out.print(list1[i]+", ");
        }

        Arrays.sort(list1, comp2);
        for(int i=0; i<list1.length;i++) {
            System.out.print(list1[i]+", ");
        }
    }
    public static void main(String args[]) {
        ReorderLogFiles rlf = new ReorderLogFiles();
        String[] logs = new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        String[] result = rlf.reorder(logs);
        for(int i=0;i<result.length;i++) {
            System.out.println(result[i]);
        }
    }
}
