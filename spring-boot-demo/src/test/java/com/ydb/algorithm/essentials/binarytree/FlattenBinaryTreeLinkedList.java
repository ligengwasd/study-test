package com.ydb.algorithm.essentials.binarytree;

import com.ydb.algorithm.leetcode.TreeNode;

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

        TreeNode node = root.right;
        root.right = root.left;
        root.left = null;
        while(root.right != null){
            root = root.right;
        }
        root.right = node;
    }
}
