package com.ds.practice.MergeKSortedLinkedList;

/**
 * |-------------------------------------------|
 * | Lists                                     |
 * | List 0 List 1 List 2 List 3 List 4 List 5 |
 * |-------------------------------------------|
 *        +             +             +
 * |-------------------------------------------|
 * |    List 0        List 2        List 3     |
 * |-------------------------------------------|
 *               +
 * |-------------------------------------------|
 * |          List 0                List 3     |
 * |-------------------------------------------|
 *                        +
 * |-------------------------------------------|
 * |                   List 0                  |
 * |-------------------------------------------|
 */
public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {
        int numLists = lists.length;
        if (numLists<=0) {
            return null;
        }
        int interval = 1;

        while(interval < numLists) {
            for (int i = 0; i<numLists-interval; i = i+ interval*2) {
                lists[i] = this.mergeTwoList(lists[i], lists[i+interval]);
            }
            interval *= 2;
        }
        return lists[0];
    }

    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode prev = head;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l1;
                l1 = prev.next.next;
            }
            prev = prev.next;
        }

        if (l1 == null) {
            prev.next = l2;
        }
        if (l2 == null) {
            prev.next = l1;
        }

        return head.next;
    }


    private static void print(ListNode l) {
        StringBuilder sb = new StringBuilder();
        while(l != null) {
            sb.append(l.val);
            if (l.next != null) {
                sb.append(" -> ");
            }
            l = l.next;
        }

        System.out.println(sb.toString());
    }

    public static void main(String args[]) {
        ListNode l1 = new ListNode(1, new ListNode(3, new ListNode(5, null)));
        ListNode l2 = new ListNode(2, new ListNode(4, new ListNode(5, new ListNode(6, null))));
        ListNode l3 = new ListNode(0, new ListNode(2, new ListNode(8, null)));
        ListNode l4 = new ListNode(1, new ListNode(2, new ListNode(6, null)));
        ListNode l5 = new ListNode(0, new ListNode(7, null));

        ListNode[] lists =  new ListNode[] {l1, l2, l3, l4, l5};

        MergeKSortedList mkl = new MergeKSortedList();
        ListNode merged = mkl.mergeKLists(lists);
        System.out.println("Input: [[1->3->5], [2->4->5->6], [0->2->8->], [1->2->6], [0->7]]");
        mkl.print(merged);
    }
}
