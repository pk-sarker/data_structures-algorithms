package com.ds.practice.LowestCommonAncestor;

public class LowestCommonAncestor {
    TreeNode ancestor = null;

    private boolean traverse(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) { // reached a the leaf node, end of the current branch
            return false;
        }

        int foundInLeftSubtree = traverse(root.left, p, q) ? 1:0; // check p,q in left subtree
        int foundInRightSubtree = traverse(root.right, p, q) ? 1:0; // check p,q in right subtree
        int foundInCurrent = 0; // If the current node is one of p or q
        if (root.val == p.val || root.val == q.val) {
            foundInCurrent = 1;
        }
        // If any two of the flags left, right or mid become True
        if (foundInLeftSubtree+foundInRightSubtree+foundInCurrent >= 2) {
            ancestor = root;
            //return true;
        }
        // Return true if any one of the three bool values is True.
        return (foundInLeftSubtree+foundInRightSubtree+foundInCurrent) > 0;
    }

    public TreeNode lowestCommonAncestorRecursive(TreeNode root, TreeNode p, TreeNode q) {
        traverse(root, p, q);
        return this.ancestor;

    }
    public static void main(String args[]) {
        LowestCommonAncestor lca = new LowestCommonAncestor();
        TreeNode root = new TreeNode(5, new TreeNode(3, new TreeNode(1), new TreeNode(4)), new TreeNode(7, new TreeNode(2, new TreeNode(9, new TreeNode(10))), new TreeNode(8)));
        TreeNode lcancestor = lca.lowestCommonAncestorRecursive(root, new TreeNode(3), new TreeNode(7));
        System.out.println("LCA of (3,7): " + lcancestor.val);

        TreeNode lcancestor1 = lca.lowestCommonAncestorRecursive(root, new TreeNode(1), new TreeNode(8));
        System.out.println("LCA of (1,8): " + lcancestor1.val);

        TreeNode lcancestor2 = lca.lowestCommonAncestorRecursive(root, new TreeNode(7), new TreeNode(10));
        System.out.println("LCA of (7,10): " + lcancestor2.val);

        TreeNode lcancestor3 = lca.lowestCommonAncestorRecursive(root, new TreeNode(1), new TreeNode(4));
        System.out.println("LCA of (1,4): " + lcancestor3.val);

        TreeNode lcancestor4 = lca.lowestCommonAncestorRecursive(root, new TreeNode(8), new TreeNode(9));
        System.out.println("LCA of (8,9): " + lcancestor4.val);

        TreeNode lcancestor5 = lca.lowestCommonAncestorRecursive(root, new TreeNode(9), new TreeNode(7));
        System.out.println("LCA of (7,9): " + lcancestor5.val);
    }
}
