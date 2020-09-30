package com.ds.practice.TreeBoundary;
import java.util.ArrayList;
import java.util.List;

public class Boundary {
    private List<Integer> leftBoundary = new ArrayList<>();
    private List<Integer> rightBoundary = new ArrayList<>();
    private List<Integer> leaves = new ArrayList<>();

    public void extractLeftBoundary(TreeNode root) {

        if (root == null) {
            return ;
        }
        this.leftBoundary.add(root.value);
        if (root.left != null) {
            this.extractLeftBoundary(root.left);
        } else {
            this.extractLeftBoundary(root.right);
        }
    }

    public void extractRightBoundary(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.right != null) {
            this.extractRightBoundary(root.right);
            this.rightBoundary.add(root.value);
        } else {
            this.extractRightBoundary(root.left);
            this.rightBoundary.add(root.value);
        }

    }

    public void extractLeafs(TreeNode root) {
        if (root == null) {
            return ;
        }

        if (root.left == null && root.right == null && !this.leftBoundary.contains(root.value) && !this.rightBoundary.contains(root.value)) {
            this.leaves.add(root.value);
        }
        this.extractLeafs(root.left);
        this.extractLeafs(root.right);
    }

    public List<Integer> getLeftBoundary() {
        return this.leftBoundary;
    }

    public List<Integer> getRightBoundary() {
        return this.rightBoundary;
    }

    public List<Integer> getLeaves() {
        return this.leaves;
    }

}
