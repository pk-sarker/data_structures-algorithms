package com.practice;

import java.util.HashMap;

/**
 * A linked list is given such that each node contains an additional random pointer
 * which could point to any node in the list or null.
 *
 * Return a deep copy of the list.
 *
 * The Linked List is represented in the input/output as a list of n nodes.
 * Each node is represented as a pair of [val, random_index] where:
 *
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) where random pointer
 * points to, or null if it does not point to any node.
 */
public class CopyListWithRandomPointer {
    HashMap<NodeRn, NodeRn> visitedNode = new HashMap<>();

    public NodeRn copyRandomList(NodeRn head) {
        if (head == null) {
            return null;
        }
        if (visitedNode.containsKey(head)) {
            return visitedNode.get(head);
        }
        NodeRn node = new NodeRn(head.value);

        visitedNode.put(head, node);
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);

        return node;
    }

    public static void print(NodeRn head) {
        StringBuilder sb = new StringBuilder();
        NodeRn curr = head;
        while(curr != null) {
            sb.append("("+curr.value+", ");
            if (curr.random != null) {
                sb.append(curr.random.value+")");
            } else {
                sb.append("null)");
            }
            if (curr.next != null) {
                sb.append(" -> ");
            }
            curr = curr.next;
        }

        System.out.println(sb.toString());
    }
    public static void main(String  args[]) {
        NodeRn node1 = new NodeRn(1);
        NodeRn node2 = new NodeRn(2);
        NodeRn node3 = new NodeRn(3);
        NodeRn node4 = new NodeRn(4);
        NodeRn node5 = new NodeRn(5);

        node1.next = node2;
        node2.next  = node3;
        node3.next = node4;
        node3.random = node5;
        node4.next = node5;
        node4.random = node1;

        NodeRn head = node1;
        CopyListWithRandomPointer.print(head);

        CopyListWithRandomPointer cp = new  CopyListWithRandomPointer();
        NodeRn deepCopy = cp.copyRandomList(head);

        head.value = -1;
        CopyListWithRandomPointer.print(deepCopy);
        CopyListWithRandomPointer.print(head);
    }
}
