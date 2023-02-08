package com.ydb.algorithm.essentials.binarytree.recursion;

import com.ydb.algorithm.leetcode.TreeNode;

public class LCABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            // 走到这里，说明p和q正好在上一层的root节点的左右两边。
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left !=null && right !=null) {
            return root;
        }
        if (left != null) {
            return left;
        } else {
            return right;
        }
    }
}
