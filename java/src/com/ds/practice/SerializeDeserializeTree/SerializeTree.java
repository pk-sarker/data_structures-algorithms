package com.ds.practice.SerializeDeserializeTree;

public class SerializeTree {

    public StringBuilder traverse(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
        } else {
            sb.append(String.valueOf(root.value) + ",");
            sb = traverse(root.left, sb);
            sb = traverse(root.right, sb);
        }
        return sb;
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb = traverse(root, sb);
        sb.setLength(sb.length()-1);
        return sb.toString();
    }
}
