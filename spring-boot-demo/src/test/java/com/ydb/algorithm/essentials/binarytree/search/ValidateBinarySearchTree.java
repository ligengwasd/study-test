package com.ydb.algorithm.essentials.binarytree.search;

import com.ydb.algorithm.leetcode.TreeNode;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {

    }

    public static boolean isValidBSF(TreeNode root, TreeNode left, TreeNode right) {
        return root.val > left.val && root.val< right.val
                && isValidBSF(left, left.left, left.right)
                && isValidBSF(right, right.left, right.right);
    }
}
