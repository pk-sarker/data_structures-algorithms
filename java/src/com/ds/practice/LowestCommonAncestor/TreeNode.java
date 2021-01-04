package com.ds.practice.LowestCommonAncestor;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {

    }
    TreeNode(int val) {
        this.val = val;
    }
    public TreeNode(int val, TreeNode left) {
        this.val = val;
        this.left = left;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
