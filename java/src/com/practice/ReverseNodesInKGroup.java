package com.practice;

import com.ds.practice.common.Node;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 *
 * Could you solve the problem in O(1) extra memory space?
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 *
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 */
public class ReverseNodesInKGroup {

    public static Node reverseK(Node head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        Node preHead = new Node(-1);
        Node reversed = preHead, groupReversed = null, current = head, temp = null, previous = null, firstNode = null;
        int groupSize = 0;
        while(current != null) {
            temp = current.next;
            if (groupSize < k-1) {
                // update local reversed list
                previous = groupReversed;
                groupReversed = current;
                groupReversed.next = previous;
                if (groupSize == 0){
                    firstNode = groupReversed;
                }
                groupSize++;
            }
            else if (groupSize == k-1) { // reset group

                previous = groupReversed;
                groupReversed = current;
                groupReversed.next = previous;

                reversed.next = groupReversed; // add the reversed list to result
                reversed = firstNode;
                // reset reversed list
                firstNode = null;
                groupReversed = null;
                groupSize = 0;
            }
            current = temp;
        }
        if (groupReversed != null) {
            Node rrev = null;
            while(groupReversed != null) {
                Node t = groupReversed.next;
                previous = rrev;
                rrev = groupReversed;
                rrev.next = previous;
                groupReversed = t;
            }
            reversed.next = rrev;
        }
        return preHead.next;
    }

    public static void print(Node head) {
        StringBuilder sb = new StringBuilder();
        Node curr = head;
        while(curr != null) {
            sb.append(curr.value);
            if (curr.next != null) {
                sb.append(" -> ");
            }
            curr = curr.next;
        }

        System.out.print(sb.toString());
    }
    public static void main(String args[]) {
        Node list1 = new Node(1, new  Node(4, new Node(5, new Node(9))));
        System.out.println("\nInput: ");
        ReverseNodesInKGroup.print(list1);
        System.out.print(", k=2\n");
        Node res = ReverseNodesInKGroup.reverseK(list1, 4);
        ReverseNodesInKGroup.print(res);

        Node list2 = new Node(1, new  Node(3, new Node(5, new Node(7 , new Node(9)))));
        System.out.println("\nInput: ");
        ReverseNodesInKGroup.print(list2);
        System.out.println("");
        Node res1 = ReverseNodesInKGroup.reverseK(list2, 2);
        ReverseNodesInKGroup.print(res1);
        System.out.print(", k=2\n");

        Node list3 = new Node(1, new  Node(3, new Node(5, new Node(7 , new Node(9)))));
        Node res2 = ReverseNodesInKGroup.reverseK(list3, 3);
        System.out.println("");
        ReverseNodesInKGroup.print(res2);
        System.out.print(", k=3\n");
    }
}
