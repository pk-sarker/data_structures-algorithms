package com.ds.practice.ReverseLinkedList;

public class ReverseLinkedList {

    public  ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }
    public ListNode reverseRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return prev;
    }
    public void printLL(ListNode head) {
        StringBuffer sb = new StringBuffer();
        while(head != null) {
            sb.append(head.val);
            if (head.next != null) {
                sb.append(" -> ");
            }
            head = head.next;
        }
        System.out.println(sb.toString());
    }
    public static void main(String args[]) {
        ReverseLinkedList rll = new ReverseLinkedList();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        rll.printLL(head);
        rll.printLL(rll.reverse(head));

        ListNode head2 = new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(7))));
        rll.printLL(head2);
        rll.printLL(rll.reverseRecursive(head2));

    }
}
