package com.ds.practice.BTreeRightView;
import com.ds.practice.common.TreeNode;

import java.util.List;
import java.util.ArrayList;
import java.util.ArrayDeque;

public class BTreeRightSide {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>(){{ offer(root); }};

        while(!queue.isEmpty()) {
            int levelSpan = queue.size();

            for(int i=0; i<levelSpan; i++) {
                TreeNode node = queue.poll();
                if (i == levelSpan-1) {
                    result.add(node.value);
                }

                if (node.left!= null) {
                    if (node.value == 5) {
                        System.out.print(queue);
                    }
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
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

    public static void main(String args[]){
        BTreeRightSide bt = new BTreeRightSide();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4)), new TreeNode(3));
        List<Integer> result = bt.rightSideView(root);
        System.out.println("Input:\n"+
         "         1\n" +
         "       /  \\\n" +
         "      2    3\n" +
         "     /\n"+
         "    4\n");
        bt.printList(result);

        System.out.println("\n Input:\n"+
                "         1\n" +
                "       /\n" +
                "      2\n" +
                "     /\n"+
                "    3\n");
        TreeNode root2 = new TreeNode(1, new TreeNode(2, new TreeNode(3)));
        List<Integer> result2 = bt.rightSideView(root2);
        bt.printList(result2);



        System.out.println("\n Input:\n"+
                "         1\n" +
                "       /   \\\n" +
                "      2     3\n" +
                "     /     / \n"+
                "    4     5   \n" +
                "         / \\  \n" +
                "        6   7   \n" +
                "       /         \n" +
                "      8           \n");

        TreeNode root3 = new TreeNode(1, new TreeNode(2, new TreeNode(4)), new TreeNode(3, new TreeNode(5, new TreeNode(6, new TreeNode(8)), new TreeNode(7))));
        List<Integer> result3 = bt.rightSideView(root3);
        bt.printList(result3);
    }
}
