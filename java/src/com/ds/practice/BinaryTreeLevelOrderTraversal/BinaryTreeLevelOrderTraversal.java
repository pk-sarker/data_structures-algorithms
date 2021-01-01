package com.ds.practice.BinaryTreeLevelOrderTraversal;

import com.ds.practice.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return result;
        }
        traverse(root, 0);
        return result;
    }

    public void traverse(TreeNode root, int level) {
        // start the current level
        if (result.size()==level) {
            result.add(new ArrayList<Integer>());
        }
        // fulfil the current level
        result.get(level).add(root.value);

        // process child nodes for the next level
        if (root.left!=null) {
            traverse(root.left, level+1);
        }
        if (root.right!=null) {
            traverse(root.right, level+1);
        }
    }

    public static void main(String args[]) {
        BinaryTreeLevelOrderTraversal obj = new BinaryTreeLevelOrderTraversal();
        TreeNode root = new TreeNode(5, new TreeNode(3, new TreeNode(1), new TreeNode(4)), new TreeNode(7, new TreeNode(6), new TreeNode(8)));
        List<List<Integer>> res = obj.levelOrder(root);
        System.out.println(res);
    }
}
