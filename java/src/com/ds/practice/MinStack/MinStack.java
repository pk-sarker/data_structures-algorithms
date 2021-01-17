package com.ds.practice.MinStack;
import java.util.Stack;

public class MinStack {
    Stack<int[]> stack = new Stack<>();

    public void push(int x) {
        int min = x;
        if (!stack.isEmpty()) {
            min = Math.min(stack.peek()[1], x);
        }
        stack.push(new int[]{x,min});
    }

    public int pop() {
        return stack.pop()[0];
    }

    public int peek() {
        return stack.peek()[0];
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }

    public static void main(String args[]) {
        MinStack ms = new MinStack();
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
