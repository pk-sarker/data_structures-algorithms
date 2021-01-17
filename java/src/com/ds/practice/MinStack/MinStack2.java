package com.ds.practice.MinStack;
import java.util.Stack;
public class MinStack2 {
    Stack<Integer> stack =  new Stack<>();
    Stack<int[]> minStack =  new Stack<>();

    public void push(int x) {
        // We always put the number onto the main stack.
        stack.push(x);
        // If the min stack is empty, or this number is smaller than
        // the top of the min stack, put it on with a count of 1.
        if (minStack.isEmpty() || x < minStack.peek()[0]) {
            minStack.push(new int[]{x, 1});

            // Else if this number is equal to what's currently at the top
            // of the min stack, then increment the count at the top by 1.
        } else if (x == minStack.peek()[0]) {
            minStack.peek()[1]++;
        }
    }

    public int pop() {
        if (stack.peek().equals(minStack.peek()[0])) {
            minStack.peek()[1]--;
        }

        if (minStack.peek()[1]==0) {
            minStack.pop();
        }
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peek() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek()[0];
    }

    public static void main(String args[]) {
        MinStack2 ms = new MinStack2();
        ms.push(3);
        ms.push(5);
        ms.push(4);
        ms.push(1);
        ms.push(7);
        ms.push(6);
        System.out.println("Peek: "+ms.peek() + " Min: " + ms.getMin());
        System.out.println("Pop: " + ms.pop() + " Min: " + ms.getMin());
        System.out.println("Pop: " + ms.pop() + " Min: " + ms.getMin());
        System.out.println("Pop: " + ms.pop() + " Min: " + ms.getMin());
        System.out.println("Pop: " + ms.pop() + " Min: " + ms.getMin());
    }
}
