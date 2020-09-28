package com.ds.practice.TreeBoundary;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]) {
        Boundary boundary = new Boundary();

//        TreeNode leftSubTree = new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(7), new TreeNode(8)));
//        TreeNode rightSubTree = new TreeNode(3, new TreeNode(6, new TreeNode(9), new TreeNode(10)), null );
//
//        TreeNode root = new TreeNode(1, leftSubTree, rightSubTree);
//
//        boundary.extractLeftBoundary(root);
//        boundary.extractRightBoundary(root);
//        boundary.extractLeafs(root);
//        List<Integer> lb = boundary.getLeftBoundary();
//        List<Integer> rb = boundary.getRightBoundary();
//        List<Integer> lf = boundary.getLeaves();
//
//        System.out.println("Left Boundary: ");
//        lb.forEach(node -> System.out.print(node + ", "));
//        System.out.println("\nRight Boundary: ");
//        rb.forEach(node -> System.out.print(node + ", "));
//
//        System.out.println("\nLeafs: ");
//        lf.forEach(node -> System.out.print(node + ", "));
//
//        lb.addAll(lf);
//        lb.addAll(rb);
//        lb.remove(lb.size()-1);
//        System.out.println("\nBoundary: ");
//        lb.forEach(node -> System.out.print(node + ", "));
//

        System.out.println("\n-------------------------------------------------\n");
        TreeNode root2 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), new TreeNode(4)));

        boundary = new Boundary();
        List<Integer> lb1 = new ArrayList<Integer>();
        if (root2.left != null) {
            boundary.extractLeftBoundary(root2);
        } else {
            lb1.add(root2.value);
        }

        boundary.extractRightBoundary(root2.right);
        boundary.extractLeafs(root2);
        lb1.addAll(boundary.getLeftBoundary());
        List<Integer> rb1 = boundary.getRightBoundary();
        List<Integer> lf1 = boundary.getLeaves();

        System.out.println("Left Boundary: ");
        lb1.forEach(node -> System.out.print(node + ", "));
        System.out.println("\nRight Boundary: ");
        rb1.forEach(node -> System.out.print(node + ", "));

        System.out.println("\nLeafs: ");
        lf1.forEach(node -> System.out.print(node + ", "));

        lb1.addAll(lf1);
        lb1.addAll(rb1);
        System.out.println("\nBoundary: ");
        lb1.forEach(node -> System.out.print(node + ", "));


        // -------------------------------------------------
        System.out.println("\n-------------------------------------------------\n");
        TreeNode root3 = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4),null), null), null);

        boundary = new Boundary();
        List<Integer> lb2 = new ArrayList<Integer>();
        if (root3.left != null) {
            boundary.extractLeftBoundary(root3);
        } else {
            lb2.add(root3.value);
        }

        if (root3.right != null) {
            boundary.extractRightBoundary(root3.right);
        }

        boundary.extractLeafs(root3);
        lb2.addAll(boundary.getLeftBoundary());
        List<Integer> rb2 = boundary.getRightBoundary();
        List<Integer> lf2 = boundary.getLeaves();

        System.out.println("Left Boundary: ");
        lb2.forEach(node -> System.out.print(node + ", "));
        System.out.println("\nRight Boundary: ");
        rb2.forEach(node -> System.out.print(node + ", "));

        System.out.println("\nLeafs: ");
        lf2.forEach(node -> System.out.print(node + ", "));

        lb2.addAll(lf2);
        lb2.addAll(rb2);
        System.out.println("\nBoundary: ");
        lb2.forEach(node -> System.out.print(node + ", "));


        System.out.println("\n-------------------------------------------------\n");
        TreeNode root4 = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4))));

        boundary = new Boundary();
        List<Integer> lb3 = new ArrayList<Integer>();
        if (root4.left != null) {
            boundary.extractLeftBoundary(root4);
        } else {
            lb3.add(root4.value);
        }

        if (root4.right != null) {
            boundary.extractRightBoundary(root4.right);
        }

        boundary.extractLeafs(root4);
        lb3.addAll(boundary.getLeftBoundary());
        List<Integer> rb3 = boundary.getRightBoundary();
        List<Integer> lf3 = boundary.getLeaves();

        System.out.println("Left Boundary: ");
        lb3.forEach(node -> System.out.print(node + ", "));
        System.out.println("\nRight Boundary: ");
        rb3.forEach(node -> System.out.print(node + ", "));

        System.out.println("\nLeafs: ");
        lf3.forEach(node -> System.out.print(node + ", "));

        lb3.addAll(lf3);
        lb3.addAll(rb3);
        System.out.println("\nBoundary: ");
        lb3.forEach(node -> System.out.print(node + ", "));


        System.out.println("\n-------------------------------------------------\n");
        // TreeNode root4 = new TreeNode(7, TreeNode(), new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4))));
    }
}
