package com.design.LRU;
import java.util.Map;
import java.util.HashMap;
import java.lang.StringBuilder;

public class LRUCacheDoubleLinkedList {
    private int capacity;
    private int size;
    private Map<Integer, DoubleLinkedListNode> cache = new HashMap<>();
    private DoubleLinkedListNode head, tail;

    public LRUCacheDoubleLinkedList(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.head = new DoubleLinkedListNode();
        this.tail = new DoubleLinkedListNode();
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        System.out.println("> GET " + key);
        DoubleLinkedListNode node = cache.get(key);
        if (node != null) {
            moveNodeToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        System.out.println("> PUT (" + key + "," + value + ")");
        DoubleLinkedListNode node = cache.get(key);
        if (node == null) {
            node = new DoubleLinkedListNode(key, value);
            addNewNode(node);
            cache.put(key, node);
            this.size++;
            if (this.size>this.capacity) {
                DoubleLinkedListNode lastNode = this.popNode();
                cache.remove(lastNode.key);
                --this.size;
            }
        } else {
            moveNodeToHead(node);
        }
    }

    public DoubleLinkedListNode popNode() {
        DoubleLinkedListNode lastNode = tail.prev;
        this.removeNode(lastNode);
        return lastNode;
    }

    public void moveNodeToHead(DoubleLinkedListNode node) {
        removeNode(node);
        addNewNode(node);
    }
    public void addNewNode(DoubleLinkedListNode node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    public void removeNode(DoubleLinkedListNode node) {
        DoubleLinkedListNode prev = node.prev;
        DoubleLinkedListNode next = node.next;
        prev.next = next;
        next.prev = prev;

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
}
