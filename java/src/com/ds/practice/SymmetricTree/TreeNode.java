package com.ds.practice.SymmetricTree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.val = value;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.val = value;
        this.left = left;
        this.right = right;
    }
}
