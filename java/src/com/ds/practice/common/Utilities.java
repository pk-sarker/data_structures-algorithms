package com.ds.practice.common;

public class Utilities {

    public static void print(Node l) {
        StringBuilder sb = new StringBuilder();
        while(l != null) {
            sb.append(l.value);
            if (l.next != null) {
                sb.append(" -> ");
            }
            l = l.next;
        }
        System.out.println(sb.toString());
    }
}
