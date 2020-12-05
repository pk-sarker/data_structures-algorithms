package com.ds.practice.MergeSortedLinkedList;

import com.ds.practice.common.Node;
import com.ds.practice.common.Utilities;

public class MergeSortedList {

    public Node mergeTwoLists(Node l1, Node l2) {

        if(l1==null) {
            return l2;
        } else if (l2==null) {
            return l1;
        } if (l1.value < l2.value) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String args[]) {
        MergeSortedList merge = new MergeSortedList();
        Node list1 = new Node(1, new Node(3, new Node(6, new Node(8))));
        System.out.print("List 1: ");
        Utilities.print(list1);
        Node list2 = new Node(2, new Node(3, new Node(7)));
        System.out.print("List 2: ");
        Utilities.print(list2);
        Node result = merge.mergeTwoLists(list1, list2);
        System.out.print("Merged List: ");
        Utilities.print(result);
    }
}
