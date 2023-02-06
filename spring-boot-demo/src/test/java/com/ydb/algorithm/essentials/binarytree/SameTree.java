package com.ydb.algorithm.essentials.binarytree;

/**
 * 判断两棵树是否相等
 */
public class SameTree {
    public static boolean isSame(Node p, Node q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.iData != q.iData) {
            return false;
        }
        return isSame(p.leftChild, q.leftChild) && isSame(p.rightChild, q.rightChild);
    }
}
