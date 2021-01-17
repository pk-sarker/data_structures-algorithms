package com.practice;

import java.util.Arrays;
import java.util.Comparator;

/**
 * You have an array of logs.  Each log is a space delimited string of words.
 *
 * For each log, the first word in each log is an alphanumeric identifier.  Then, either:
 *
 *  - Each word after the identifier will consist only of lowercase letters, or;
 *  - Each word after the identifier will consist only of digits.
 *  - We will call these two varieties of logs letter-logs and digit-logs.
 * It is guaranteed that each log has at least one word after its identifier.
 *
 * Reorder the logs so that all of the letter-logs come before any digit-log.
 * The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.
 *
 * Return the final order of the logs.
 *
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 * Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 */
public class ReorderLogFiles {
    public static String[] reorderLogs(String[] logs ) {
        Comparator<String> comparator = new Comparator<String>() {
            public int compare(String s1, String s2) {
                String[] s1Split = s1.split(" ", 2);
                String[] s2Split = s2.split(" ", 2);

                boolean s1digit = Character.isDigit(s1Split[1].charAt(0));
                boolean s2digit = Character.isDigit(s2Split[1].charAt(0));

                if (!s1digit && !s2digit) {
                    int com = s1Split[1].compareTo(s2Split[1]);
                    if (com!=0) {
                        return com;
                    }
                    return s1Split[0].compareTo(s2Split[0]);
                }
                if (!s1digit && s2digit) {
                    return -1;
                } else if(s1digit && !s2digit) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };

        Arrays.sort(logs, comparator);
        return logs;
    }
    public static void main(String args[]) {
        String[] logs = new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        System.out.println(Arrays.toString(logs));
        String[] logs1 = ReorderLogFiles.reorderLogs(logs);
        System.out.println(Arrays.toString(logs1));
    }
}
