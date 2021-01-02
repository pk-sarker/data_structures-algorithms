package com.ds.practice.BinaryTreeZigzagLevelOrder;

import com.ds.practice.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> results = new ArrayList<List<Integer>>();

        // add the root element to kick off the BFS loop
        LinkedList<TreeNode> node_queue = new LinkedList<>();
        node_queue.addLast(root);
        node_queue.addLast(null); // null identifies that all the nodes in current level has been explored

        // Store the result order of each level
        LinkedList<Integer> level_list = new LinkedList<Integer>();
        boolean is_order_left = true;

        while (node_queue.size() > 0) {
            // Retrieves and removes the first element of the node_queue
            TreeNode curr_node = node_queue.pollFirst();
            if (curr_node != null) {
                if (is_order_left) {
                    level_list.addLast(curr_node.value);
                } else {
                    level_list.addFirst(curr_node.value);
                }

                if (curr_node.left != null) {
                    node_queue.addLast(curr_node.left);
                }
                if (curr_node.right != null) {
                    node_queue.addLast(curr_node.right);
                }
            } else {
                // if current node is null then it means that all the nodes have been explored
                results.add(level_list);
                level_list = new LinkedList<>();
                // prepare for the next level
                if (node_queue.size() > 0)
                    node_queue.addLast(null);
                is_order_left = !is_order_left;
            }
        }
        return results;
    }
    
    public static void main(String args[]) {
        BinaryTreeZigzagLevelOrder bz = new BinaryTreeZigzagLevelOrder();
        TreeNode root = new TreeNode(6, new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(5)), new TreeNode(8, new TreeNode(7), new TreeNode(9, null, new TreeNode(10))));
        System.out.println("                 6");
        System.out.println("               /   \\");
        System.out.println("              4     8");
        System.out.println("            /  \\   / \\");
        System.out.println("           2    5 7   9");
        System.out.println("          / \\          \\");
        System.out.println("         1   3          10");
        List<List<Integer>> res = bz.zigzagLevelOrder(root);
        System.out.println(res);
    }
}
