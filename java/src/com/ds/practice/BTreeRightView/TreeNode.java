package com.ds.practice.BTreeRightView;


public class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode() {

    }
    TreeNode(int val) {
        this.value = val;
    }
    public TreeNode(int val, TreeNode left) {
        this.value = val;
        this.left = left;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.value = val;
        this.left = left;
        this.right = right;
    }


}