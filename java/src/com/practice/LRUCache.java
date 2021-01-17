package com.practice;

import com.design.LRU.DoubleLinkedListNode;

import java.util.HashMap;

public class LRUCache {
    int capacity = 0;
    public DoubleLinkedListNode head, tail;
    int size = 0;
    HashMap<Integer, DoubleLinkedListNode> hash = new HashMap<Integer, DoubleLinkedListNode>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new DoubleLinkedListNode();
        this.tail = new DoubleLinkedListNode();
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        if (hash.containsKey(key)) {
            DoubleLinkedListNode node = hash.get(key);
            if (node != null) {
                moveToHead(node);
                return node.value;
            }
        }
        return -1;
    }

    private void moveToHead(DoubleLinkedListNode node){
        remove(node);
        addNewNode(node);
    }

    private void remove(DoubleLinkedListNode node) {
        DoubleLinkedListNode prev = node.prev;
        DoubleLinkedListNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void addNewNode(DoubleLinkedListNode node) {
        node.next = this.head.next;
        node.prev = this.head;

        this.head.next.prev = node;
        this.head.next = node;
    }

    public void put(int key, int value) {
        if (hash.containsKey(key)) {
            moveToHead(hash.get(key));
        } else {
            DoubleLinkedListNode node = new DoubleLinkedListNode(key, value);
            addNewNode(node);
            this.size++;
            this.hash.put(key, node);
            if (this.size > this.capacity) {
                DoubleLinkedListNode lastNode = popNode();
                this.hash.remove(lastNode.key);
                --this.size;
            }
        }
    }

    private DoubleLinkedListNode popNode() {
        DoubleLinkedListNode lastNode = tail.prev;
        this.remove(lastNode);
        return lastNode;
    }

    public void printLinkedList() {
        DoubleLinkedListNode node = this.head.next;
        StringBuilder sb = new StringBuilder();
        while(node != null && node.next !=null){
            sb.append(node.value);
            if (node.next.next != null) {
                sb.append(" -> ");
            }
            node = node.next;
        }
        System.out.println(sb.toString());
    }
    public static void main(String args[]) {
        LRUCache lru = new LRUCache(2);
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
