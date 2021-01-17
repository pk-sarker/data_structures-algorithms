package com.practice;

import com.ds.practice.common.Node;

/**
 * Given the head of a Singly LinkedList, write a method to modify the
 * LinkedList such that the nodes from the second half of the LinkedList
 * are inserted alternately to the nodes from the first half in reverse order.
 *
 * So if the LinkedList has nodes 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null,
 * your method should return 1 -> 6 -> 2 -> 5 -> 3 -> 4 -> null.
 *
 * Input: 2 -> 4 -> 6 -> 8 -> 10 -> 12 -> null
 * Output: 2 -> 12 -> 4 -> 10 -> 6 -> 8 -> null
 *
 * Input: 2 -> 4 -> 6 -> 8 -> 10 -> null
 * Output: 2 -> 10 -> 4 -> 8 -> 6 -> null
 *
 */
public class RearrangeList {

    public static void reorder(Node head) {
        if (head == null) {
            return;
        }

        // Find middle of the linked list
        Node slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the second half
        Node reversed2ndHalfHead = reverse(slow);
        Node firstHalfHead = head;
        while(firstHalfHead != null && reversed2ndHalfHead != null) {
            Node t = firstHalfHead.next;
            firstHalfHead.next = reversed2ndHalfHead;
            firstHalfHead = t;

            t = reversed2ndHalfHead.next;
            reversed2ndHalfHead.next = firstHalfHead;
            reversed2ndHalfHead = t;
        }

        if (firstHalfHead != null)
            firstHalfHead.next = null;
    }

    public static Node reverse(Node middle) {
        Node current = middle;
        Node previous = null;

        while(current != null) {
            Node t = current.next;
            current.next = previous;
            previous = current;
            current = t;
        }
        return previous;
    }

    public static void printList(Node head) {
        StringBuilder sb = new StringBuilder();
        Node cur = head;
        while(cur != null) {
            sb.append(cur.value);
            if (cur.next != null) {
                sb.append(" -> ");
            }
            cur = cur.next;
        }
        System.out.println(sb.toString());
    }

    public static void main(String args[]) {
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, new Node(6))))));
        //Node head = new Node(2, new Node(4, new Node(6, new Node(8, new Node(10, new Node(12))))));
        printList(head);
        RearrangeList.reorder(head);
        printList(head);
        System.out.println("---- ----");
        Node head1 = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5)))));
        printList(head1);
        RearrangeList.reorder(head1);
        printList(head1);
    }
}
