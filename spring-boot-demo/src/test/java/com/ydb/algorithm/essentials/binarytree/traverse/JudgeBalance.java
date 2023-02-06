package com.ydb.algorithm.essentials.binarytree.traverse;

import com.ydb.algorithm.essentials.binarytree.Node;

/**
 * 判断是否是平衡树
 */
public class JudgeBalance {

    public static boolean isBalance(Node root) {
        if (root.leftChild == null && root.rightChild == null) {
            return true;
        }
        if (root.leftChild == null || root.rightChild == null) {
            return false;
        }
        Integer leftDeep = getMaxDeep(root.leftChild);
        Integer rightDeep = getMaxDeep(root.rightChild);
        return  Math.abs(leftDeep-rightDeep) <=1 && isBalance(root.leftChild) && isBalance(root.rightChild);
    }

    public static Integer getMaxDeep(Node node) {
        if (node == null) {
            return 0;
        }
        Integer leftDeep = getMaxDeep(node.leftChild);
        Integer rightDeep = getMaxDeep(node.rightChild);
        return Math.max(leftDeep, rightDeep) + 1;
    }

}
