package com.practice;

import com.ds.practice.common.Node;

public class PalindromicLinkedList {

    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        // find middle of the linked list
        Node slow = head, fast = head;
        while(fast != null && fast.next !=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the linked list after middle
        Node secondHalf = reverse(slow);
        Node copyHeadSecondHalf = secondHalf;
        boolean result = true;
        while(head != null && secondHalf != null) {
            if (head.value != secondHalf.value) {
                result = false;
                break;
            }
            head = head.next;
            secondHalf = secondHalf.next;
        }
        reverse(copyHeadSecondHalf);
        return result;
    }

    public static Node reverse(Node middle) {
        Node current = middle;
        Node previous = null;
        while (current != null) {
            Node t = current.next;
            current.next = previous;
            previous = current;
            current = t;
        }
        return previous;
    }

    public static void main(String args[]) {
        //
        // 3 -> 5 -> 7 -> 5 -> 3
        Node head1 = new Node(3, new Node(5, new Node(7, new Node(5, new Node(3)))));
        System.out.println("\nInput: 3 -> 5 -> 7 -> 5 -> 3 \nOutput: " + PalindromicLinkedList.isPalindrome(head1));

        // 3 -> 5 -> 7 -> 7 -> 5 -> 3
        Node head2 = new Node(3, new Node(5, new Node(7, new Node(7, new Node(5, new Node(3))))));
        System.out.println("\nInput: 3 -> 5 -> 7 -> 7 -> 5 -> 3 \nOutput: " + PalindromicLinkedList.isPalindrome(head2));

        // 3 -> 5 -> 7 -> 8 -> 5 -> 3
        Node head3 = new Node(3, new Node(5, new Node(7, new Node(8, new Node(5, new Node(3))))));
        System.out.println("\nInput: 3 -> 5 -> 7 -> 8 -> 5 -> 3 \nOutput: " + PalindromicLinkedList.isPalindrome(head3));

        System.out.println("\nInput: 1 -> 1 -> 2 -> 1 \nOutput: " + PalindromicLinkedList.isPalindrome(new Node(1, new Node(1, new Node(2, new Node(1))))));
    }
}
