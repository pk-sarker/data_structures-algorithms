package com.ds.practice.LinkedlistCycle;

public class LinkedList {

    public boolean hasCycle(Node head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return false;
        }
        Node slowPointer = head;
        Node fastPointer = head.next;
        while (slowPointer != fastPointer) {
            System.out.println("> " + slowPointer.value + ", "  + fastPointer.value);
            if (fastPointer == null || fastPointer.next == null) {
                return false;
            }
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        return true;
    }

    public static void main(String args[]) {
        Node node1 = new Node(3);
        Node node2 = new Node(2);
        Node node3 = new Node(9);
        Node node4 = new Node(-5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        LinkedList ll = new LinkedList();
        System.out.println(ll.hasCycle(node1));

        // 3 -> 2 -> 9 -> -5
    }
}
