package com.practice;

import com.ds.practice.common.Node;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 */
public class IntersectionOf2LinkedList {

    public static Node getIntersectionNode(Node headA, Node headB) {

        if (headA == null || headB == null) {
            return null;
        }

        Node ptr1 = headA, ptr2 = headB, intersection = null;
        int llAloopCount = 0, llBloopCount = 0;

        while(ptr1 != null || ptr2 != null) {
            if (ptr1 == null) {
                if (llAloopCount <=1) {
                    ptr1 = headB;
                    llAloopCount++;
                } else {
                    return null;
                }
            }
            if (ptr2 == null) {
                if (llBloopCount <=1) {
                    ptr2 = headA;
                    llBloopCount++;
                } else {
                    return null;
                }
            }
            if (ptr1 == ptr2) {
                intersection = ptr1;
                break;
            }
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return intersection;
    }

    public static void main(String args[]){
        Node node4 = new Node(4, new Node(5, new Node(6)));
        Node head1 = new Node(1, new Node(2, new Node(3, node4)));
        Node head2 = new Node(7, new Node(8, node4));
        Node result = IntersectionOf2LinkedList.getIntersectionNode(head1, head2);
        System.out.println("Intersection at "+ result.value);

        Node node5 = new Node(5, new Node(-1, new Node(6)));
        Node head3 = new Node(1, new Node(2, new Node(3, node5)));
        Node head4 = new Node(7, new Node(8, new Node(9, node5)));
        Node result1 = IntersectionOf2LinkedList.getIntersectionNode(head3, head4);
        System.out.println("Intersection at "+ result1.value);

        Node node9 = new Node(9, new Node(3, new Node(6)));
        Node head5 = new Node(1, new Node(2, new Node(3, node9)));
        Node head6 = new Node(7, new Node(8, new Node(9)));
        Node result2 = IntersectionOf2LinkedList.getIntersectionNode(head5, head6);
        System.out.println("Intersection at " + result2);
    }
}
