package com.ds.practice.SerializeDeserializeTree;
import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

public class DeserializeTree {
    public TreeNode rdeserialize(List<String> nodeStr) {
        //System.out.print(nodeStr.get(0));
        if (nodeStr.get(0) == null || nodeStr.get(0).trim().equals("null")) {
            nodeStr.remove(0);
            return null;

        }
        //System.out.print(">> "+ nodeStr.get(0));
        TreeNode node = new TreeNode(Integer.valueOf(nodeStr.get(0).trim()));
        nodeStr.remove(0);
        node.left = rdeserialize(nodeStr);
        node.right = rdeserialize(nodeStr);
        return node;
    }
    public TreeNode deserialize(String tree) {
        String[] nodeAr = tree.split(",");
        List<String> nodeList = new LinkedList<String>(Arrays.asList(nodeAr));

        return rdeserialize(nodeList);
    }
}
