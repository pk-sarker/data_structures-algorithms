package com.ds.practice.SerializeDeserializeTree;

public class SerializeDeserializeTree {

    public static void main(String args[]) {

        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(7))), new TreeNode(3, new TreeNode(6)));
        SerializeTree s = new SerializeTree();
        String serialized = s.serialize(root);
        System.out.println(serialized);
        DeserializeTree d = new DeserializeTree();

        TreeNode deserialized = d.deserialize(serialized);
        String serialized2 = s.serialize(deserialized);
        System.out.println(serialized2);

    }
}
