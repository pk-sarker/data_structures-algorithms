package com.ds.practice.ParenthesesRemoveMinimal;
import java.util.HashSet;
import java.util.Stack;
import java.lang.CharSequence;

public class ValidParentheses {

    /**
     * Complexity is O(4n)=O(n), there are four passes
     *  - 1 pass to  find the invalid closing parentheses
     *  - 1 pass to add the invalid opening  to remove set, when  stack is not empty
     *  - 1 pass to create a new StringBuilder without the invalid parentheses char
     *  - 1 pass to convert the StringBuilder to String
     * @param s
     * @return
     */
    public String minRemoveToMakeValid(String s) {
        if(s==null || s.length()==0)  {
            return "";
        }
        int n = s.length();

        HashSet<Integer> removeIndexSet = new  HashSet<>();
        Stack<Integer> stack = new Stack<>();
        StringBuffer sb =  new StringBuffer();
        boolean f;
        for(int i=0; i<n; i++) {
            if (s.charAt(i)=='(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
              if (stack.isEmpty()) {
                  removeIndexSet.add(i);
              } else {
                  stack.pop();
              }
            }
        }
        while(!stack.isEmpty()) {
            removeIndexSet.add(stack.pop());
        }

        for(int i=0; i<n; i++) {
            if (!removeIndexSet.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }


    public StringBuilder removeInvalidClosing(CharSequence s, char open, char close) {
        StringBuilder sb = new StringBuilder();
        int n = s.length(), balance = 0;
        for(int i=0;i<n;i++) {
            char c = s.charAt(i);
            if (c==open) {
                balance++;
            } else if (c==close) {
                if (balance == 0) {
                    continue;
                }
                balance--;
            }
            sb.append(c);
        }
        return sb;
    }

    public String minRemoveToMakeValidOptimization1(String s) {
        if(s==null || s.length()==0)  {
            return "";
        }
        StringBuilder sb = removeInvalidClosing(s,'(', ')');
        StringBuilder sbRev = removeInvalidClosing(sb.reverse(),')', '(');
        return sbRev.reverse().toString();
    }

    public String minRemoveToMakeValidOptimization2Pass(String s) {
        if(s==null || s.length()==0)  {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int n = s.length(), balance = 0, openCount = 0;
        for(int i=0; i<n; i++) {
            char c = s.charAt(i);
            if (c=='(') {
                balance++;
                openCount++;
            } else if (c==')') {
                if (balance == 0) {
                    continue;
                }
                balance--;
            }
            sb.append(c);
        }

        int validOpenCount = openCount - balance;
        StringBuilder res = new StringBuilder();
        for(int i=0; i<sb.length();i++) {
            if (sb.charAt(i)=='(') {
                validOpenCount--;
                if (validOpenCount < 0) {
                    continue;
                }
            }
            res.append(sb.charAt(i));
        }
        return res.toString();
    }



    public static void main(String args[]) {
        ValidParentheses vp = new ValidParentheses();

        System.out.println("\nInput: a((bc)de\nOutput: "+vp.minRemoveToMakeValid("a((bc)de"));
        System.out.println("\nInput: a((b)c(de\nOutput: "+vp.minRemoveToMakeValid("a((b)c(de"));
        System.out.println("\nInput: )(ab)c(\nOutput: "+vp.minRemoveToMakeValid(")(ab)c("));
        System.out.println("\nInput: ))(((\nOutput: "+vp.minRemoveToMakeValid("))((("));
        System.out.println("\nInput: abc\nOutput: "+vp.minRemoveToMakeValid("abc"));
        System.out.println("\nInput: \nOutput: "+vp.minRemoveToMakeValid(""));

        System.out.println(" - - - - - - - - - - - - - - - - -");
        System.out.println("\nInput: a((bc)de\nOutput: "+vp.minRemoveToMakeValidOptimization1("a((bc)de"));
        System.out.println("\nInput: a((b)c(de\nOutput: "+vp.minRemoveToMakeValidOptimization1("a((b)c(de"));
        System.out.println("\nInput: )(ab)c(\nOutput: "+vp.minRemoveToMakeValidOptimization1(")(ab)c("));
        System.out.println("\nInput: ))(((\nOutput: "+vp.minRemoveToMakeValidOptimization1("))((("));
        System.out.println("\nInput: abc\nOutput: "+vp.minRemoveToMakeValidOptimization1("abc"));
        System.out.println("\nInput: \nOutput: "+vp.minRemoveToMakeValidOptimization1(""));


        System.out.println(" - - - - - - - - - - - - - - - - -");
        System.out.println("\nInput: a((bc)de\nOutput: "+vp.minRemoveToMakeValidOptimization2Pass("a((bc)de"));
        System.out.println("\nInput: a((b)c(de\nOutput: "+vp.minRemoveToMakeValidOptimization2Pass("a((b)c(de"));
        System.out.println("\nInput: )(ab)c(\nOutput: "+vp.minRemoveToMakeValidOptimization2Pass(")(ab)c("));
        System.out.println("\nInput: ))(((\nOutput: "+vp.minRemoveToMakeValidOptimization2Pass("))((("));
        System.out.println("\nInput: (((a(((b\nOutput: "+vp.minRemoveToMakeValidOptimization2Pass("(((a(((b"));
        System.out.println("\nInput: (((a)(((b)\nOutput: "+vp.minRemoveToMakeValidOptimization2Pass("(((a)(((b)"));
        System.out.println("\nInput: abc\nOutput: "+vp.minRemoveToMakeValidOptimization2Pass("abc"));
        System.out.println("\nInput: )()(\nOutput: "+vp.minRemoveToMakeValidOptimization2Pass(")()("));

    }
}
