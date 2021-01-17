package com.ds.practice.ReverseInteger;

public class ReverseInteger {

    public int reverse(int x) {
        int rev = 0;
        while(x!=0) {
            int t = x%10;
            x = x/10;
            // positive limit
            // 2^32-1 = 2,147,483,647
            if (rev > Integer.MAX_VALUE/10 || (rev==Integer.MAX_VALUE/10 && t>7)) {
                return 0;
            }
            // negative limit
            // -2^32 = -2,147,483,648
            if(rev < Integer.MIN_VALUE/10 || (rev==Integer.MIN_VALUE/10 && t <  -8)) {
                return 0;
            }
            rev = rev*10+t;
        }
        return rev;
    }

    public static void main(String args[]){
        ReverseInteger ri = new ReverseInteger();
        System.out.println(ri.reverse(1534236469));
    }
}
