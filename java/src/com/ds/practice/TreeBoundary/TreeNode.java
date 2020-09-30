package com.ds.practice.TreeBoundary;

public class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode() {

    }
    TreeNode(int val) {
        this.value = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.value = val;
        this.left = left;
        this.right = right;
    }
}
