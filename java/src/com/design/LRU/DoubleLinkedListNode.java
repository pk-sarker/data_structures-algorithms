package com.design.LRU;

public class DoubleLinkedListNode {
    public int value;
    public int key;
    public DoubleLinkedListNode next;
    public DoubleLinkedListNode prev;

    public DoubleLinkedListNode(){

    }
    public DoubleLinkedListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
