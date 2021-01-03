package com.ds.practice.IntersectionOfTwoLinkedLists;

import java.util.HashSet;

public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> hashSet = new HashSet<>();
        ListNode res = null;
        while(headA != null && headB!=null) {
            if (hashSet.contains(headA)) {
                res = headA;
                return res;
            } else if (hashSet.contains(headB)) {
                res = headB;
                return res;
            }
            hashSet.add(headA);
            hashSet.add(headB);
            headA = headA.next;
            headB = headB.next;
        }
        return res;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        ListNode res = null;
        ListNode ptrA = headA;
        ListNode ptrB = headB;
        int llALoopCount = 0, llBLoopCount = 0;
        while(headA != null && headB!=null) {
            if (ptrA.equals(ptrB)) {
                res = ptrA;
                return res;
            }
            ptrA = ptrA.next;
            ptrB = ptrB.next;

            if (ptrA == null) {
                if (llALoopCount<1) {
                    ptrA = headB;
                    llALoopCount++;
                } else {
                    return null;
                }
            }

            if (ptrB == null) {
                if (llBLoopCount<1) {
                    ptrB = headA;
                    llBLoopCount++;
                } else {
                    return null;
                }
            }
        }
        return res;
    }

    public static void main(String args[]) {
        IntersectionOfTwoLinkedLists itll = new IntersectionOfTwoLinkedLists();
        ListNode common = new ListNode(9, new ListNode(11));
        ListNode llA = new ListNode(3, new ListNode(5, new ListNode(7, common)));
        ListNode llB = new ListNode(2, new ListNode(4, common));
        ListNode res = itll.getIntersectionNode(llA, llB);
        System.out.println("\nInput: A:3->5->7->9->11 B:2->4->9->11");
        System.out.println("Intersection: " + res != null ? res.val: null);

        ListNode common1 = new ListNode(9, new ListNode(11));
        ListNode llA1 = new ListNode(3, new ListNode(5, new ListNode(7, common1)));
        ListNode llB1 = new ListNode(2, new ListNode(4, common1));
        ListNode res1 = itll.getIntersectionNode2(llA1, llB1);
        System.out.println("\nInput: A:3->5->7->9->11 B:2->4->9->11");
        System.out.println("Intersection: " + res1 != null ? res1.val: null);

        // A:3->5->7->9->11
        // B:2->4->9->11
        // a1 + common
        // b1 + common
        // a1 + common + b1
        // b1 + common + a1

    }
}
