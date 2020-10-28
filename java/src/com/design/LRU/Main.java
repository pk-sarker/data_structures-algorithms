package com.ds.practice.LRU;

public class Main {

    public static void main(String args[]) {
        LRUCacheDoubleLinkedList lru = new LRUCacheDoubleLinkedList(2);
        lru.put(1,5);
        lru.printLinkedList();
        lru.put(2,3);
        lru.printLinkedList();
        lru.put(3,7);
        lru.printLinkedList();
        lru.get(2);
        lru.printLinkedList();
        lru.put(4,2);
        lru.printLinkedList();
    }
}
