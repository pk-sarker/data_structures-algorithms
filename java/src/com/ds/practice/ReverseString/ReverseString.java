package com.ds.practice.ReverseString;

public class ReverseString {
    public char[] reverse(char[] c) {
        int n = c.length;
        int start = 0, end = n -1;
        while(start <= end) {
            char tmp = c[start];
            c[start] = c[end];
            c[end] = tmp;
            start++;
            end--;
        }
        return c;
    }

    public static void main(String args[]) {
        ReverseString rs = new ReverseString();

        char[] chr = rs.reverse(new char[]{'a', 'b', 'c', 'd', 'e'});
        System.out.println(chr.toString());
    }
}
