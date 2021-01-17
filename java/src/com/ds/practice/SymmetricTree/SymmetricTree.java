package com.ds.practice.SymmetricTree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    public boolean isMirror(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true; // if both nodes are null then symmetric
        }

        if (node1 == null || node2 == null) { // if one of the node is null
            return false;
        }

        return node1.val == node2.val && isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
    }

    public boolean  isSymmetricItr(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1==null &&  node2==null) {
                continue;
            }
            if (node1==null || node2==null) {
                return false;
            }
            if (node1.val!=node2.val) {
                return false;
            }
            queue.add(node1.left);
            queue.add(node2.right);
            queue.add(node1.right);
            queue.add(node2.left);
        }

        return true;
    }
    public static void main(String args[]) {
        SymmetricTree st = new SymmetricTree();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4),new TreeNode(3)));
        System.out.println(st.isSymmetric(root));

        TreeNode root2 = new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(2, new TreeNode(3),null));
        System.out.println(st.isSymmetric(root2));


        TreeNode root3 = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4),new TreeNode(3)));
        System.out.println(st.isSymmetricItr(root3));

        TreeNode root4 = new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(2, new TreeNode(3),null));
        System.out.println(st.isSymmetricItr(root4));

    }
}
