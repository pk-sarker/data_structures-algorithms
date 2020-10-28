package com.ds.practice.MergeSortedList;

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

    private static void print(Node l) {
        StringBuilder sb = new StringBuilder();
        while(l != null) {
            sb.append(l.value);
            if (l.next != null) {
                sb.append(" -> ");
            }
            l = l.next;
        }

        System.out.println(sb.toString());
    }

    public static void main(String args[]) {
        MergeSortedList merge = new MergeSortedList();
        Node list1 = new Node(1, new Node(3, new Node(6, new Node(8))));
        Node list2 = new Node(2, new Node(3, new Node(7)));
        Node result = merge.mergeTwoLists(list1, list2);
        print(result);
        Node result1 = merge.mergeTwoListsItr(list1, list2);
        print(result1);

    }
}
