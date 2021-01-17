package com.practice;

import com.ds.practice.common.Node;

public class Merge2SortedList {

    public static Node mergeTwoLists(Node l1, Node l2) {
        Node prehead = new Node(-1);
        Node previous= prehead;
        while(l1!=null && l2 != null) {

            if (l1.value <= l2.value) {
                previous.next = l1;
                l1 = l1.next;
            } else {
                previous.next = l2;
                l2 = l2.next;
            }
            previous = previous.next;
        }
        if (l1 == null) {
            previous.next = l2;
        }
        if (l2 == null) {
            previous.next = l1;
        }
        return prehead.next;
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

        System.out.println(sb.toString());
    }
    public static void main(String args[]) {
        Node list1 = new Node(2, new Node(4, new Node(9)));
        Node list2 = new Node(3, new Node(3, new Node(5, new Node(10))));
        Merge2SortedList.print(list1);
        Merge2SortedList.print(list2);
        System.out.print("After Merge: ");
        Node merge1 = Merge2SortedList.mergeTwoLists(list1, list2);
        Merge2SortedList.print(merge1);
    }
}
