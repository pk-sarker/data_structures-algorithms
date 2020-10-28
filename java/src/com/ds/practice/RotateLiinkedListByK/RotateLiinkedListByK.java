package com.ds.practice.RotateLiinkedListByK;

public class RotateLiinkedListByK {

    public ListNode rotateK(ListNode head, int k) {
        int nodeCount = 0;
        if (k == 0 || head == null) {
            return head;
        }
        ListNode current = head;
        ListNode tail = null;

        while (current != null) {
            nodeCount++;
            if (current.next == null) {
                tail = current;
            }
            current = current.next;
        }
        // creating a circle
        tail.next = head;

        // tail position
        int newTailPos = nodeCount -   k % nodeCount - 1;
        for(int i = 0; i<newTailPos; i++) {
            head = head.next;
        }
        ListNode newHead = head.next;
        head.next = null;
        return newHead;
    }

    public void printLL(ListNode head) {
        StringBuffer sb = new StringBuffer();
        while(head != null ) {
            sb.append(head.val);
            if (head.next != null) {
                sb.append("->");
            }
            head = head.next;
        }
        System.out.println(sb.toString());
    }

    public static void main(String args[]) {
        RotateLiinkedListByK rll = new RotateLiinkedListByK();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println("Input 1:");
        rll.printLL(head);
        ListNode result = rll.rotateK(head, 2);
        rll.printLL(result);

        System.out.println("Input 2:");
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        rll.printLL(head1);
        ListNode result1 = rll.rotateK(head1, 6);
        rll.printLL(result1);

    }
}
