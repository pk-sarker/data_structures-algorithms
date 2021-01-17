package com.practice;

import com.ds.practice.common.ListNode;

/**
 * Given the head of a linked list, return the list after sorting it in ascending order.
 *
 * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
 */
public class SortLinkedList {

    public ListNode sort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMiddle(head);
        System.out.println("Head: " + head.val + " middle: "+(mid != null ? mid.val:mid));
        ListNode left = sort(head);
        ListNode right = sort(mid);

        return merge(left, right);
    }

    public ListNode getMiddle(ListNode head) {
        ListNode slow = null, fast = head;

        while(fast != null && fast.next != null) {
            slow = (slow == null) ? head : slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow.next;
        slow.next = null;
        return mid;
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode tail = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = (list1 != null) ? list1 : list2;
        return dummyHead.next;
    }

    public static void print(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode curr = head;
        while(curr != null) {
            sb.append(curr.val);
            if (curr.next != null) {
                sb.append(" -> ");
            }
            curr = curr.next;
        }

        System.out.println(sb.toString());
    }
    public static void main(String args[]) {
        ListNode num1 = new ListNode(2, new ListNode(4, new ListNode(3, new ListNode(1, new ListNode(5)))));
        ListNode num2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        SortLinkedList ob = new SortLinkedList();
        ListNode res = ob.sort(num1);
        SortLinkedList.print(res);

    }
}
