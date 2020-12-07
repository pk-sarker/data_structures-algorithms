package com.ds.practice.BinarySearchTreeValidate;

import com.ds.practice.common.TreeNode;

import java.util.LinkedList;

public class BinarySearchTree {

    public boolean isValidBST(TreeNode root) {
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

    LinkedList<TreeNode> stack = new LinkedList<>();
    LinkedList<Integer> upperBounds = new LinkedList<>();
    LinkedList<Integer> lowerBounds = new LinkedList<>();

    public void update(TreeNode node, Integer lower, Integer upper) {
        stack.add(node);
        upperBounds.add(upper);
        lowerBounds.add(lower);
    }
    public boolean isValidBSTItr(TreeNode root) {
        Integer lowerBound = null, upperBound = null;
        update(root, lowerBound, upperBound);

        while(!stack.isEmpty()) {
            root = stack.poll();
            lowerBound = lowerBounds.poll();
            upperBound = upperBounds.poll();

            if (root == null) {
                continue;
            }
            if (lowerBound != null && root.value <= lowerBound) {
                return false;
            }
            if (upperBound != null && root.value >= upperBound) {
                return false;
            }
            update(root.left, lowerBound, root.value);
            update(root.right, root.value, upperBound);

        }
        return true;
    }

    public static void main(String args[]) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println("\nInput:");
        System.out.println("    2");
        System.out.println("   / \\");
        System.out.println("  1   3");
        System.out.println("Output: "+ bst.isValidBST(root));

        TreeNode root1 = new TreeNode(5, new TreeNode(3, new TreeNode(1), new TreeNode(4)), new TreeNode(7, new TreeNode(6), new TreeNode(8)));
        System.out.println("\nInput:");
        System.out.println("     5");
        System.out.println("   /   \\");
        System.out.println("  3     7");
        System.out.println(" / \\   / \\");
        System.out.println("1   4 6   8");
        System.out.println("Output: "+ bst.isValidBST(root1));
        System.out.println("Output: "+ bst.isValidBSTItr(root1));

        TreeNode root2 = new TreeNode(5, new TreeNode(3, new TreeNode(1), new TreeNode(4)), new TreeNode(7, new TreeNode(4), new TreeNode(8)));
        System.out.println("\nInput:");
        System.out.println("     5");
        System.out.println("   /   \\");
        System.out.println("  3     7");
        System.out.println(" / \\   / \\");
        System.out.println("1   4 4   8");
        System.out.println("Output: "+ bst.isValidBST(root2));
        System.out.println("Output: "+ bst.isValidBSTItr(root2));



    }
}
