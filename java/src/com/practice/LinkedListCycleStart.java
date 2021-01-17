package com.practice;

import com.ds.practice.common.Node;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 *
 */
public class LinkedListCycleStart {
    public static Node detectCycle(Node head) {
        Node fast = head, slow = head;
        int cycleLength = 0;
        while(fast != null && slow != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                cycleLength = findCycleLength(slow);
                break;
            }
        }
        if (cycleLength == 0 ) {
            return null;
        }
        Node ptr1 = head, ptr2 = head;
        while(cycleLength > 0) {
            ptr2 = ptr2.next;
            cycleLength--;
        }
        while(ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1;
    }

    public static int findCycleLength(Node slow) {
        Node current = slow;
        int len = 0;
        do {
            current = current.next;
            len++;
        } while(current != slow);

        return len;
    }
    // 3 -> 4 -> 5 -> 6 -> 2 -> 0 -> -3 -> 7
    //                ^--------------------^

    public static void main(String[] args) {
        Node head = new Node(3);
        head.next = new Node(4);
        head.next.next = new Node(5);
        head.next.next.next = new Node(6);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(0);
        head.next.next.next.next.next.next = new Node(-3);
        Node node7 = new Node(7, head.next.next.next);
        head.next.next.next.next.next.next.next = node7;
        Node res = LinkedListCycleStart.detectCycle(head);
        System.out.println(res.value);
    }
}
