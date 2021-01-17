package com.practice;

import com.ds.practice.common.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 */
public class AddTwoNumbers {

    public static ListNode add(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode current = head;

        ListNode p1 = l1, p2 = l2;
        int carry = 0;

        while(p1!= null || p2!= null) {
            int digit1 = p1 != null ? p1.val:0;
            int digit2 = p2 != null ? p2.val:0;
            int sum = carry + digit1 + digit2;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (p1 != null) {
                p1 = p1.next;
            }

            if (p2 != null) {
                p2 = p2.next;
            }
        }

        if (carry>0) {
            current.next = new ListNode(carry);
        }
        return head.next;
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
        ListNode num1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode num2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        AddTwoNumbers.print(num1);
        System.out.println("+");
        AddTwoNumbers.print(num2);
        System.out.println("=");
        ListNode res = AddTwoNumbers.add(num1, num2);
        AddTwoNumbers.print(res);
    }

}
