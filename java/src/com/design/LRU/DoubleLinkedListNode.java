package com.design.LRU;

public class DoubleLinkedListNode {
    int value;
    int key;
    DoubleLinkedListNode next;
    DoubleLinkedListNode prev;

    DoubleLinkedListNode(){

    }
    DoubleLinkedListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
