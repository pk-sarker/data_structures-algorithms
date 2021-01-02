package com.ds.practice.DecodeString;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DecodeString {

    public String decode(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int n = s.length();

        Stack<Character> stack = new Stack<>();
        for(int i=0; i<n; i++) {
            char c = s.charAt(i);
            if (c != ']') {
                stack.push(c);
            } else {
                List<Character> decodeStr = new ArrayList<>();
                while (stack.peek()!='[') {
                    decodeStr.add(stack.pop());
                }

                // pop [
                stack.pop();
                // get k
                int base = 1, k = 0;
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    k = k + base * (stack.pop()-'0');
                    base = base * 10;
                }

                while(k != 0) {
                    for(int j=decodeStr.size()-1; j>=0; j--) {
                        stack.push(decodeStr.get(j));
                    }
                    k--;
                }
            }
        }
        char[] res = new char[stack.size()];
        for(int i=stack.size()-1; i>=0; i--) {
            res[i] = stack.pop();
        }

        return new String(res);
    }

    public static void main(String args[]) {
        DecodeString ds = new DecodeString();
        System.out.println("\nInput: \"3[a]2[bc]\" \nOutput: "+ds.decode("3[a]2[bc]"));

        System.out.println("\nInput: \"2[2[a]1[c]]2[x]y3[z]\" \nOutput: "+ds.decode("2[2[a]1[c]]2[x]y3[z]"));
        System.out.println("\nInput: \"10[abc]\" \nOutput: "+ds.decode("10[abc]"));
    }
}
