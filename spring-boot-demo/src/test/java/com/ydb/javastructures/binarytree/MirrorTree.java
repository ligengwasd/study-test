package com.ydb.javastructures.binarytree;

public class MirrorTree {

    public static Node mirror(Node root) {
        if (root == null) {
            return null;
        }
        Node node = new Node();
        node.iData = root.iData;
        node.leftChild = mirror(root.rightChild);
        node.rightChild = mirror(root.leftChild);
        return node;
    }

}
