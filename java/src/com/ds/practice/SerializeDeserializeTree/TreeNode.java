package com.ds.practice.SerializeDeserializeTree;

public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int  value) {
        this.value = value;
    }
    public TreeNode(int value, TreeNode left) {
        this.value = value;
        this.left = left;
    }

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

}
