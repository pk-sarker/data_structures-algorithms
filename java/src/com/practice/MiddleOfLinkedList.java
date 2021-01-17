package com.practice;

import com.ds.practice.common.Node;

/**
 * Given a non-empty, singly linked list with head node head,
 * return a middle node of linked list.
 *
 * If there are two middle nodes, return the second middle node.
 */
public class MiddleOfLinkedList {
    public static Node findMiddle(Node head) {
        Node slow = head, fast = head;
        while(fast != null && fast.next!= null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        Node head = new Node(3);
        head.next = new Node(4);
        head.next.next = new Node(5);
        head.next.next.next = new Node(6);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(0);
        head.next.next.next.next.next.next = new Node(-3);
        head.next.next.next.next.next.next.next = new Node(7);

        System.out.println("\nInput: 3 -> 4 -> 5 -> 6 -> 2 -> 0 -> -3 -> 7 \nMiddle Node: " + MiddleOfLinkedList.findMiddle(head).value);

        head.next.next.next.next.next.next = null;
        System.out.println("\nInput: 3 -> 4 -> 5 -> 6 -> 2 -> 0 -> -3 \nMiddle Node: " + MiddleOfLinkedList.findMiddle(head).value);
    }
}
