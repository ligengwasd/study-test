package com.ydb.algorithm.essentials.binarytree.traverse;

import com.ydb.algorithm.leetcode.TreeNode;

/**
 * 文章详解：
 * https://blog.csdn.net/shadowkun/article/details/105210645
 */
public class FlattenBinaryTreeLinkedList {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            flatten(root.left);
        }
        if (root.right != null) {
            flatten(root.right);
        }
        // 1.记录下右子树
        TreeNode oldRight = root.right;
        // 2.用左子树取代右子树
        root.right = root.left;
        // 3.左节点置空
        root.left = null;
        // 4.root指针移到最右的节点上
        while (root.right != null) {
            root = root.right;
        }
        // 5.老的右子树挂到最右的节点上
        root.right = oldRight;
    }
}
