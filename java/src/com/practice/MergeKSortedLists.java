package com.practice;

import com.ds.practice.common.Node;

import java.util.PriorityQueue;

public class MergeKSortedLists {

    /**
     * Using divide and conquer.
     * This approach walks alongside the one above but is improved a lot.
     * We don't need to traverse most nodes many times repeatedly
     *  - Pair up k lists and merge each pair.
     *  - After the first pairing, k lists are merged into k/2 lists with average 2N/k length, then k/4, k/8 and so on.
     *  - Repeat this procedure until we get the final sorted linked list.
     *
     *  Thus, we'll traverse almost N nodes per pairing and merging, and repeat this procedure about log_{2}k times.
     *
     *  Time Complexity: O(N log k), where k is the number of linked lists.
     *  Space Complexity: O(1)
     * @param lists
     * @return
     */
    public static Node mergeKLists(Node[] lists) {
        int n = lists.length;
        int interval = 1;
        while (interval < n) {
            for(int i=0; i<n-interval; i += interval*2) {
                lists[i] = MergeKSortedLists.mergeTwoList(lists[i], lists[i+interval]);
            }
            interval = interval * 2;
        }
        return lists[0];
    }

    public static Node mergeTwoList(Node l1, Node l2){
        Node prehead = new Node(-1);
        Node current = prehead;
        while(l1 != null && l2 != null) {
            if (l1.value < l2.value) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 == null) {
            current.next = l2;
        }
        if (l2 == null) {
            current.next = l1;
        }
        return prehead.next;
    }

    /**
     * we have to find the smallest element of all the input lists, we have to compare only the smallest
     * (i.e. the first) element of all the lists. Once we have the smallest element, we can put it in
     * the merged list. Following a similar pattern, we can then find the next smallest element of all
     * the lists to add it to the merged list.
     *
     * The best data structure that comes to mind to find the smallest number among a set of ‘K’ numbers is a Heap. Let’s see how can we use a heap to find a better algorithm.
     *
     *  - We can insert the first element of each array in a Min Heap.
     *  - After this, we can take out the smallest (top) element from the heap and add it to the merged list.
     *  - After removing the smallest element from the heap, we can insert the next element of the same list into the heap.
     *  - We can repeat steps 2 and 3 to populate the merged list in sorted order.
     * @param lists
     * @return
     */
    public static Node mergeKListsUsingHeap(Node[] lists) {
        // create a min-heap
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.value-b.value);
        int n = lists.length;
        for(int i = 0; i<n; i++) {
            if(lists[i] != null) {
                minHeap.add(lists[i]);
            }
        }
        Node resultHead = new Node(-1);
        Node current = resultHead;

        while (!minHeap.isEmpty()) {
            Node minNode = minHeap.poll();
            current.next = minNode;
            current = current.next;

            if (minNode.next != null) {
                minHeap.add(minNode.next);
            }
        }
        return resultHead.next;
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
        Node list1 = new Node(1, new  Node(4, new Node(5)));
        Node list2 = new Node(1, new  Node(3, new Node(4)));
        Node list3 = new Node(2, new  Node(6));
        Node list4 = new Node(0, new  Node(2, new Node(9)));
        Node list5 = new Node(8);
        System.out.println("\nInput Lists: ");
        MergeKSortedLists.print(list1);
        MergeKSortedLists.print(list2);
        MergeKSortedLists.print(list3);
        MergeKSortedLists.print(list4);
        MergeKSortedLists.print(list5);
        Node result = MergeKSortedLists.mergeKLists(new Node[]{list1, list2, list3, list4, list5});
        System.out.println("\nUsing Divide & Conquer:");
        MergeKSortedLists.print(result);

        Node list6 = new Node(1, new  Node(4, new Node(5)));
        Node list7 = new Node(1, new  Node(3, new Node(4)));
        Node list8 = new Node(2, new  Node(6));
        Node list9 = new Node(0, new  Node(2, new Node(9)));
        Node list10 = new Node(8);


        Node result2 = MergeKSortedLists.mergeKListsUsingHeap(new Node[]{list6, list7, list8, list9, list10});
        System.out.println("\nUsing Heap:");
        MergeKSortedLists.print(result2);
    }
}
