package com.practice;

import com.ds.practice.common.Node;

public class LinkedListReverse {
    public static Node reverse(Node head) {
        if (head == null) {
            return null;
        }
        Node reversed = null, current = head;
        while(current != null) {
            Node temp = current.next;
            Node previous = reversed;
            reversed = current;
            reversed.next = previous;
            current = temp;
        }
        return reversed;
    }

    public static void print(Node head) {
        StringBuilder sb = new StringBuilder();
        Node curr = head;
        while(curr != null) {
            sb.append(curr.value);
            if (curr.next != null) {
                sb.append(" -> ");
            }
            curr = curr.next;
        }

        System.out.println(sb.toString());
    }
    public static void main(String args[]) {
        Node list1 = new Node(1, new  Node(4, new Node(5, new Node(9))));
        LinkedListReverse.print(list1);
        Node res = LinkedListReverse.reverse(list1);
        LinkedListReverse.print(res);
    }
}
