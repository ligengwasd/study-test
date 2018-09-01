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
        TreeNode e = new   TreeNode(5);
        TreeNode g = new   TreeNode(7);
        TreeNode h = new   TreeNode(8);

        TreeNode l = new   TreeNode(12);
        TreeNode m = new   TreeNode(13);
        TreeNode n = new   TreeNode(14);
        TreeNode k = new   TreeNode(11, n, null);
        TreeNode j = new   TreeNode(10, l, m);
        TreeNode i = new   TreeNode(9, j, k);
        TreeNode d = new   TreeNode(4, null, g);

        TreeNode f = new   TreeNode(6, h, i);
        TreeNode b = new   TreeNode(2, d, e);
        TreeNode c = new   TreeNode(3, f, null);

        TreeNode root = new   TreeNode(1, b, c);


        levelOrderBottom(root);
    }

    public static List<List> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List> wrapList = new LinkedList<List>();

        if(root == null) return wrapList;

        queue.offer(root);

        while (!queue.isEmpty()) {
            int size=queue.size();
            List subList = new ArrayList<>();
            for (int i=0; i<size; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                subList.add(queue.poll().val);
            }
            wrapList.add(0,subList);

        }
        return wrapList;
    }
}
