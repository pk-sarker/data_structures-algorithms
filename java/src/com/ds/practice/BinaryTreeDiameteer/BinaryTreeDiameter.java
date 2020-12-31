package com.ds.practice.BinaryTreeDiameteer;

import com.ds.practice.common.TreeNode;

public class BinaryTreeDiameter {

    private int result = -1;
    public int diameterOfBinaryTree(TreeNode root) {
        this.result = 1;
        this.traverse(root);
        return result-1;
    }

    private int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftPathLen = traverse(root.left);
        int rightPathLen = traverse(root.right);

        this.result = Math.max(this.result, leftPathLen+rightPathLen+1);

        return Math.max(leftPathLen, rightPathLen) + 1;
    }

    public static void main(String args[]) {
        BinaryTreeDiameter bt = new BinaryTreeDiameter();

        TreeNode root = new TreeNode(6, new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(5)), new TreeNode(8, new TreeNode(7), new TreeNode(9, null, new TreeNode(10))));
        System.out.println("                 6");
        System.out.println("               /   \\");
        System.out.println("              4     8");
        System.out.println("            /  \\   / \\");
        System.out.println("           2    3 7   9");
        System.out.println("          / \\          \\");
        System.out.println("         1   3          10");
        System.out.println("\nDiameter: "+bt.diameterOfBinaryTree(root));
    }
}
