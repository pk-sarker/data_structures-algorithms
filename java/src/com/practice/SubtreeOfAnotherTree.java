package com.practice;

import com.ds.practice.common.TreeNode;

/**
 * Given two non-empty binary trees s and t, check whether tree t
 * has exactly the same structure and node values with a subtree of s.
 * A subtree of s is a tree consists of a node in s and all of this node's descendants.
 * The tree s could also be considered as a subtree of itself.
 *
 * Example 1:
 * Given tree s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * Given tree t:
 *    4
 *   / \
 *  1   2
 * Return true, because t has the same structure and node values with a subtree of s.
 *
 *
 * Example 2:
 * Given tree s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 * Given tree t:
 *    4
 *   / \
 *  1   2
 * Return false.
 *
 */
public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s, t);
    }

    public boolean compare(TreeNode s, TreeNode t) {
        if (s==null && t==null) {
            return true;
        }

        if (s==null || t==null) {
            return false;
        }

        if (s.value == t.value) {

        }
        return s.value == t.value && compare(s.left, t.left) && compare(s.right, t.right);
    }
    public boolean traverse(TreeNode s, TreeNode t) {
        return s!=null && (compare(s, t) || traverse(s.left, t) || traverse(s.right, t));
    }

    public static void main(String  args[]) {
        TreeNode rootA = new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2)), new TreeNode(5));
        TreeNode rootB = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        SubtreeOfAnotherTree obj = new SubtreeOfAnotherTree();
        System.out.println(obj.isSubtree(rootA, rootB));

        TreeNode rootC = new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2, new TreeNode(0))), new TreeNode(5));
        TreeNode rootD = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        System.out.println(obj.isSubtree(rootC, rootD));
    }
}
