package com.ydb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author ligeng
 * @Date 18/9/1
 * @Time 上午10:35
 */
public class Q107_BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node11 = new TreeNode(11);
        TreeNode node12 = new TreeNode(12);
        TreeNode node21 = new TreeNode(21);
        TreeNode node22 = new TreeNode(22);
        TreeNode node23 = new TreeNode(23);

        root.left = node11;
        root.right = node12;

        node11.left= node21;
        node11.right = node22;

        node12.left = node23;

        levelOrderBottom(root);
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

        if(root == null) return wrapList;

        queue.offer(root);

        while (!queue.isEmpty()) {
            int size=queue.size();
            List<Integer> subList = new ArrayList<>();
            for (int i=0; i<size; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                subList.add(queue.poll().val);
            }
            wrapList.add(subList);

        }
        return wrapList;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        public String toString() {
            return val+"";
        }
    }
}
