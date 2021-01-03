package com.ds.practice.CopyListWithRandomPointer;

import java.util.HashMap;

public class CopyListWithRandomPointer {
    HashMap<Node,Node> visitedNodes = new HashMap<>();

    public Node deepCopy(Node head) {
        if (head == null) {
            return null;
        }

        if (visitedNodes.containsKey(head)) {
            return visitedNodes.get(head);
        }

        Node node = new Node(head.value, null, null);

        visitedNodes.put(head, node);

        node.next = deepCopy(head.next);
        node.random = deepCopy(head.random);

        return node;
    }

    public Node deepCopyItr(Node head) {
        HashMap<Node, Node> visited = new HashMap<>();
        if (head == null) {
            return null;
        }
        Node orgNode = head;
        Node clone = new Node(head.value);
        visited.put(orgNode, clone);
        while (orgNode != null) {
            if (orgNode.random != null) {
                if (!visited.containsKey(orgNode.random)) {
                    Node rand = new Node(orgNode.random.value);
                    visited.put(orgNode.random, rand);
                }
                clone.random = visited.get(orgNode.random);
            }

            if (orgNode.next != null) {
                if (!visited.containsKey(orgNode.next)) {
                    Node rand = new Node(orgNode.next.value);
                    visited.put(orgNode.next, rand);
                }
                clone.next = visited.get(orgNode.next);
            }

            orgNode = orgNode.next;
            if (clone.next != null) {
                clone = clone.next;
            }
        }

        return visited.get(head);
    }


    public void printll(Node head) {
        StringBuilder sb = new StringBuilder();
        while(head != null) {
            sb.append("["+head.value+",");
            if (head.random!=null) {
                sb.append(head.random.value+"] -> ");
            } else {
                sb.append("null]");
            }
            if (head.next!= null) {
                sb.append(" -> ");
            }
            head = head.next;
        }

        System.out.println(sb.toString());
    }
    public static void main(String args[]) {
        CopyListWithRandomPointer copy = new CopyListWithRandomPointer();

        Node node1 = new Node(2);
        Node node2 = new Node(5);
        Node node3 = new Node(1);
        Node node4 = new Node(7);
        // [2,5] -> [1,null] -> [7,1] -> [5,2]
        // 2 -> 1 -> 7 -> 5

        node1.next = node3;
        node1.random = node2;
        node3.next = node4;
        node3.random = null;
        node4.next = node2;
        node4.random = node3;
        node2.next = null;
        node2.random = node1;
        copy.printll(node1);
        Node deepCopy = copy.deepCopy(node1);
        copy.printll(deepCopy);

        Node deepCopy1 = copy.deepCopyItr(node1);
        copy.printll(deepCopy1);
    }
}
