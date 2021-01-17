package com.practice;

public class NodeRn {
    public int value;
    public NodeRn next;
    public NodeRn random;

    public NodeRn(){}
    public NodeRn(int value) {
        this.value = value;
    }

    public NodeRn(int value, NodeRn next) {
        this.value = value;
        this.next = next;
    }
}
