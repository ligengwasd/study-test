package com.ydb.algorithm.essentials.binarytree;

import com.ydb.algorithm.leetcode.TreeNode;

public class RecoverBinarySearchTree {
    private TreeNode pre;
    private TreeNode first;
    private TreeNode second;
    public static void main(String[] args) {

    }

    void inOrder(TreeNode root) {
        inOrder(root.left);
        if (pre != null && pre.val > root.val) {

        }
        inOrder(root.right);
    }


}
