package com.ydb.javastructures.binarytree;

public class MaxDeep {
    public static Integer getMaxDeep(Node node) {
        if (node == null) {
            return 0;
        }
        Integer leftDeep = getMaxDeep(node.leftChild);
        Integer rightDeep = getMaxDeep(node.rightChild);
        return Math.max(leftDeep, rightDeep) + 1;
    }
}
