package com.practice;

import com.ds.practice.common.TreeNode;

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 *  - The left subtree of a node contains only nodes with keys less than the node's key.
 *  - The right subtree of a node contains only nodes with keys greater than the node's key.
 *  - Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        //return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValid(TreeNode root, Integer lowerBound, Integer upperBound) {
        if (root == null) {
            return true;
        }
        if (root.value <= lowerBound || root.value >= upperBound) {
            return false;
        }
        // left sub tree is not valid BST
        if (!isValid(root.left, lowerBound, root.value)) {
            return false;
        }
        // right sub-tree is not valid BST
        if (!isValid(root.right, root.value, upperBound)) {
            return false;
        }
        return true;
    }

    public static void main(String args[]) {
        ValidateBinarySearchTree bst = new ValidateBinarySearchTree();
        TreeNode root1 = new TreeNode(5, new TreeNode(3, new TreeNode(1), new TreeNode(4)), new TreeNode(7, new TreeNode(6), new TreeNode(8)));
        System.out.println("\nInput:");
        System.out.println("     5");
        System.out.println("   /   \\");
        System.out.println("  3     7");
        System.out.println(" / \\   / \\");
        System.out.println("1   4 6   8");
        System.out.println("Output: "+ bst.isValidBST(root1));
        //System.out.println("Output: "+ bst.isValidBSTItr(root1));
    }
}
