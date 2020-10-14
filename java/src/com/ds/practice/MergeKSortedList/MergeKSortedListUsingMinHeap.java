package com.ds.practice.MergeKSortedList;
import java.util.PriorityQueue;
import java.util.Comparator;

public class MergeKSortedListUsingMinHeap {

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode head = null, tail = null;
        // Create a min heap
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });

        for(int i=0; i<lists.length;i++) {
            minHeap.add(lists[i]);
        }

        while(!minHeap.isEmpty()) {
            ListNode top = minHeap.peek(); // get top element of the min heap
            minHeap.remove(); // delete top element from the min heap

            if (top.next != null) {
                minHeap.add(top.next);
            }

            if (head == null) {
                head = top;
                tail = top;
            } else {
                tail.next = top;
                tail = tail.next;
            }
        }

        return head;
    }

    public void printLL(ListNode head) {
        StringBuilder sb = new StringBuilder();
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

        ListNode l1 = new ListNode(1, new ListNode(3, new ListNode(5, null)));
        ListNode l2 = new ListNode(2, new ListNode(4, new ListNode(5, new ListNode(6, null))));
        ListNode l3 = new ListNode(0, new ListNode(2, new ListNode(8, null)));
        ListNode l4 = new ListNode(1, new ListNode(2, new ListNode(6, null)));
        ListNode l5 = new ListNode(0, new ListNode(7, null));

        ListNode[] lists =  new ListNode[] {l1, l2, l3, l4, l5};
        MergeKSortedListUsingMinHeap mkl = new MergeKSortedListUsingMinHeap();
        mkl.printLL(l1);
        mkl.printLL(l2);
        mkl.printLL(l3);
        mkl.printLL(l4);
        mkl.printLL(l5);
        ListNode merged = mkl.mergeKLists(lists);
        System.out.println("\nOutput:");
        mkl.printLL(merged);

    }
}
