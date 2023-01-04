package com.ydb.algorithm.essentials.binarytree;

import com.ydb.algorithm.leetcode.TreeNode;
import com.ydb.sort.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            TreeNode left = curr.left;
            curr.left = curr.right;
            curr.right = left;
            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
        return root;
    }
}
