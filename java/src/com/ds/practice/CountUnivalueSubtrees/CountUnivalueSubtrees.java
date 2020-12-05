package com.ds.practice.CountUnivalueSubtrees;

public class CountUnivalueSubtrees {
    public int count = 0;

    public int countUnivalSubtrees(TreeNode root) {
        count = 0;
        checkUnivalue(root);
        return count;
    }

    private boolean checkUnivalue(TreeNode node) {
        if (node.left == null && node.right == null) {
            count++;
            return true;
        }
        boolean isUniValue = true;
        if (node.left != null) {
            isUniValue = checkUnivalue(node.left) && isUniValue && node.left.val ==  node.val;
        }

        if (node.right != null) {
            isUniValue = checkUnivalue(node.right) && isUniValue && node.right.val ==  node.val;
        }
        if (!isUniValue) {
            return false;
        }
        count++;
        return true;
    }

    public static  void main(String args[]) {
        CountUnivalueSubtrees unvs  = new CountUnivalueSubtrees();
        TreeNode root = new TreeNode(5, new TreeNode(1, new TreeNode(5), new TreeNode(5)), new TreeNode(5, null, new  TreeNode(5)));
        System.out.println("Number of Unival Subtree: " + unvs.countUnivalSubtrees(root));



        TreeNode root2 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, null, new  TreeNode(6)));
        System.out.println("Number of Unival Subtree: " + unvs.countUnivalSubtrees(root2));
    }
}
