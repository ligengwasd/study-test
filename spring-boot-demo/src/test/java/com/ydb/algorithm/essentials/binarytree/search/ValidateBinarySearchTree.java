package com.ydb.algorithm.essentials.binarytree.search;

import com.ydb.algorithm.leetcode.TreeNode;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {

    }

    public static boolean isValidBSF(TreeNode root) {
        return root.val > root.left.val && root.val< root.right.val
                && isValidBSF(root.left)
                && isValidBSF(root.right);
    }
}
