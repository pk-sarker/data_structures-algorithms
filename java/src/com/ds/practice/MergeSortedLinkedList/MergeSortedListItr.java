package com.ds.practice.MergeSortedLinkedList;

import com.ds.practice.common.Utilities;
import com.ds.practice.common.Node;

public class MergeSortedListItr {

    public Node  mergeTwoListsItr(Node l1, Node l2) {
        Node preHead = new Node(-1);
        Node prev = preHead;

        while(l1 != null && l2 != null) {
            if (l1.value <= l2.value) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;

        }

        prev.next = l1 == null ? l2 : l1;
        return preHead.next;
    }

    public static void main(String args[]) {
        MergeSortedListItr merge = new MergeSortedListItr();
        Node list1 = new Node(1, new Node(3, new Node(6, new Node(8))));
        System.out.print("List 1: ");
        Utilities.print(list1);
        Node list2 = new Node(2, new Node(3, new Node(7)));
        System.out.print("List 2: ");
        Utilities.print(list2);
        Node result = merge.mergeTwoListsItr(list1, list2);
        System.out.print("Merged List: ");
        Utilities.print(result);
    }
}