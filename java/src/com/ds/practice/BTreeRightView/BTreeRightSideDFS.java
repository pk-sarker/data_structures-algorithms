package com.ds.practice.BTreeRightView;

import java.util.List;
import java.util.ArrayList;

public class BTreeRightSideDFS {
    private List<Integer> result = new ArrayList<>();

    public void helper(TreeNode root, int level) {
        if (level == result.size()) {
            result.add(root.value);
        }
        if (root.right != null) {
            helper(root.right, level+1);
        }
        if (root.left != null) {
            helper(root.left, level+1);
        }

    }
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return result;
        }
        helper(root, 0);

        return result;
    }

    public void printList(List<Integer> result) {
        StringBuilder sb = new StringBuilder();
        result.forEach(node -> {
            sb.append(node);
            sb.append(",");
        });
        sb.setLength(sb.length()-1);
        System.out.println("\nOutput: [" + sb.toString() + "]");
    }

    public static void main(String args[]) {
        BTreeRightSideDFS bt = new BTreeRightSideDFS();

        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4)), new TreeNode(3));
        List<Integer> result = bt.rightSideView(root);
        System.out.println("Input:\n"+
                "         1\n" +
                "       /  \\\n" +
                "      2    3\n" +
                "     /\n"+
                "    4\n");
        bt.printList(result);

    }
}
