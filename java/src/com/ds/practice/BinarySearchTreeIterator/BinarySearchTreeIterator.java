package com.ds.practice.BinarySearchTreeIterator;

import com.ds.practice.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeIterator {
    private List<Integer> flatList = new ArrayList<>();
    private int pointer = - 1;

    public BinarySearchTreeIterator(TreeNode root) {
        this.traverseInOrder(root);
    }
    /** @return the next smallest number */
    public int next() {
        return flatList.get(++this.pointer);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (this.pointer+1 >=flatList.size()) {
            return false;
        }
        return true;
    }

    private void traverseInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        this.traverseInOrder(root.left);
        this.flatList.add(root.value);
        this.traverseInOrder(root.right);
    }


    public static void main(String args[]) {
        TreeNode root = new TreeNode(6, new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(5)), new TreeNode(8, new TreeNode(7), new TreeNode(9, null, new TreeNode(10))));
        System.out.println("                 6");
        System.out.println("               /   \\");
        System.out.println("              4     8");
        System.out.println("            /  \\   / \\");
        System.out.println("           2    5 7   9");
        System.out.println("          / \\          \\");
        System.out.println("         1   3          10");
        BinarySearchTreeIterator iterator = new BinarySearchTreeIterator(root);

        System.out.println("iterator.next(): " + iterator.next());
        System.out.println("iterator.next(): " + iterator.next());
        System.out.println("iterator.hasNext(): " + iterator.hasNext());
        System.out.println("iterator.next(): " + iterator.next());
        System.out.println("iterator.next(): " + iterator.next());
        System.out.println("iterator.next(): " + iterator.next());
        System.out.println("iterator.next(): " + iterator.next());
        System.out.println("iterator.hasNext(): " + iterator.hasNext());
        System.out.println("iterator.next(): " + iterator.next());

    }
}
