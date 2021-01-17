package com.practice;
import com.ds.practice.common.Node;

/**
 * Given the head of a Singly LinkedList, write a function to
 * determine if the LinkedList has a cycle in it or not.
 */
public class LinkedListCycle {

    public static boolean hasCycle(Node head) {
       Node fastPtr = head, slowPtr = head;
        while (fastPtr != null && slowPtr != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if (fastPtr == slowPtr) {
                return true;
            }
        }
        return false;
    }

    /**
     * Given the head of a LinkedList with a cycle, find the length of the cycle.
     *
     * @param head
     * @return
     */
    public static int findCycleLength(Node head) {
        Node fastPtr = head, slowPtr = head;
        while (fastPtr != null && slowPtr != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if (fastPtr == slowPtr) {
                return LinkedListCycle.cycleLength(slowPtr);
            }
        }
        return 0;
    }

    public static int cycleLength(Node slow) {
        int length = 0;
        Node current = slow;

        do {
            current = current.next;
            length++;
        } while(current != slow);

        return length;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head) + " cycle length: " + LinkedListCycle.findCycleLength(head));

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head) + " cycle length: " + LinkedListCycle.findCycleLength(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head) + " cycle length: " + LinkedListCycle.findCycleLength(head));
    }
}
