package com.ds.practice.CopyListWithRandomPointer;

public class Node {
    int value;
    Node next;
    Node random;
    public Node(){
        next = null;
        random = null;
    }

    public Node(int value){
        this.value = value;
        this.next = null;
        this.random = null;
    }

    public Node(int value,  Node next, Node random) {
        this.value = value;
        this.next = next;
        this.random = random;
    }
}
