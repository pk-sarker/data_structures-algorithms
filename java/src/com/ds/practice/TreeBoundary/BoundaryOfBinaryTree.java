package com.ds.practice.TreeBoundary;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class BoundaryOfBinaryTree {

    public List<Integer> findBoundary(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        if (!isLeaf(root)) {
            result.add(root.value);
        }
        TreeNode l = root.left;
        while(l != null) {
            if (!isLeaf(l)) {
                result.add(l.value);
            }
            if (l.left != null) {
                l = l.left;
            } else {
                l = l.right;
            }
        }
        traverseLeaves(result, root);

        Stack<Integer> stack = new Stack<>();

        TreeNode r = root.right;
        while(r!= null) {
            if(!isLeaf(r)) {
                stack.push(r.value);
            }
            if (r.right != null) {
                r = r.right;
            } else {
                r = r.left;
            }
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    public void traverseLeaves(List<Integer> result, TreeNode root) {
        if (isLeaf(root)) {
            result.add(root.value);
        } else {
            if (root.left != null) {
                traverseLeaves(result, root.left);
            }
            if (root.right != null) {
                traverseLeaves(result, root.right);
            }
        }
    }

    public boolean isLeaf(TreeNode t) {
        return t.left == null && t.right == null;
    }

    public void print(List<Integer> boundaries) {
        StringBuilder sb = new StringBuilder();
        boundaries.forEach( boundary -> {
            sb.append(boundary);
            sb.append(", ");
        });

        System.out.println("Output: [" + sb.toString()+"]");

    }
    public static void main(String args[]) {
        BoundaryOfBinaryTree bbt = new BoundaryOfBinaryTree();
        /**
         *     ____1_____
         *    /          \
         *   2            3
         *  / \          /
         * 4   5        6
         *    / \      / \
         *   7   8    9  10
         */
        TreeNode leftSubTree = new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(7), new TreeNode(8)));
        TreeNode rightSubTree = new TreeNode(3, new TreeNode(6, new TreeNode(9), new TreeNode(10)), null );
        TreeNode root = new TreeNode(1, leftSubTree, rightSubTree);

        List<Integer> boundaries = bbt.findBoundary(root);
        bbt.print(boundaries);
    }
}
