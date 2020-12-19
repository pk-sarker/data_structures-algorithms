package com.ds.practice.StringCompression;

public class StringCompression {

    public int compress(char[] chars) {
        int anchor = 0;
        int writePos = 0;
        for(int read = 0; read < chars.length; read++) {
            // if at the end or change in seq
            if (read+1>=chars.length || chars[read] != chars[read+1]) {
                // write
                chars[writePos++] = chars[anchor];
                if (read>anchor) {
                    for (char c: ("" + (read-anchor +1)).toCharArray()) {
                        chars[writePos++] = c;
                    }
                }
                anchor = read+1;
            }
        }
        System.out.println(new String(chars));
        return writePos;
    }

    public static void main(String args[]) {
        StringCompression sc = new StringCompression();

        System.out.println(sc.compress(new char[]{'a','a','b','b','b','c','d','d','e'}));

        System.out.println(sc.compress(new char[]{'g','o','o','d'}));

        System.out.println(sc.compress(new char[]{'p','i','j','u','s'}));
    }
}
