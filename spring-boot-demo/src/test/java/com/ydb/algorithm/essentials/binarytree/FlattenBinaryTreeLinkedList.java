package com.ydb.algorithm.essentials.binarytree;

import com.ydb.algorithm.leetcode.TreeNode;

/**
 * 文章详解：
 * https://blog.csdn.net/shadowkun/article/details/105210645
 */
public class FlattenBinaryTreeLinkedList {

    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        if(root.left != null){
            flatten(root.left);
        }
        if(root.right != null){
            flatten(root.right);
        }
        // 1.记录下右子树
        TreeNode oldRight = root.right;
        // 2.用左子树取代右子树
        root.right = root.left;
        // 3.左节点置空
        root.left = null;
        // 4.
        while(root.right != null){
            root = root.right;
        }
        // 5.
        root.right = oldRight;
    }
}
