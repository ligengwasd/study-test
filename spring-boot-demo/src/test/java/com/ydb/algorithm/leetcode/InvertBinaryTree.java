package com.ydb.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author ligeng
 * @Date 19/8/20
 * @Time 下午4:41
 */
public class InvertBinaryTree {
    public static void main(String[] args) {
        InvertBinaryTree solution = new InvertBinaryTree();

    }

    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null) q.offer(node.left);
            if (node.right != null) q.offer(node.right);
        }

        return root;
    }

    public void invertTree2(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree2(root.left);
        invertTree2(root.right);
    }
}
