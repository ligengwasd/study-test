package com.ydb.algorithm.essentials.binarytree;

import com.ydb.algorithm.leetcode.TreeNode;

public class ConstructBinaryTreeFromPreorder {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return preIn(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    public static TreeNode preIn(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preorder.length == 0) {
            return null;
        }
        // 创建根节点
        TreeNode root = new TreeNode(preorder[preLeft]);
        root.left = null;
        root.right = null;
        // 存储左子树的长度
        int leftLength = 0;
        // 存储右子树的长度
        int rightLength = 0;
        // 寻找左右子树长度
        for (int i = inLeft; i < inRight+1; i++) {
            if (inorder[i] == root.val) {
                leftLength = i- inLeft;
                rightLength = inRight - inLeft + 1 - leftLength -1;
                break;
            }
        }
        if (leftLength > 0) {
            root.left = preIn(preorder, preLeft+1, preLeft+1+leftLength-1, inorder, inLeft, inLeft+leftLength-1);
        }
        if (rightLength > 0) {
            root.right = preIn(preorder, preLeft+1+leftLength, preRight, inorder, inLeft+leftLength-1+2, inRight);
        }
        return root;
    }

}
