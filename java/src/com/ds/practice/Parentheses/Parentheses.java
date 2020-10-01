package com.ds.practice.Parentheses;
import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

public class Parentheses {

    public boolean isValid(String expression) {
        Map<Character, Character> parenthesesMap = new HashMap<>();
        parenthesesMap.put(')','(');
        parenthesesMap.put('}','{');
        parenthesesMap.put(']','[');

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<expression.length();i++) {
            char c = expression.charAt(i);

            if(parenthesesMap.containsKey(c)) {
                if(stack.isEmpty()) {
                    return false;
                }
                char topChar = stack.pop();
                if (topChar != parenthesesMap.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String args[]) {
        Parentheses p = new Parentheses();
        System.out.println(p.isValid("{(())()}"));
    }
}
