package com.ydb.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author ligeng
 * @Date 18/9/1
 * @Time 下午8:27
 */
public class Q112_PathSum {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.getTree();
        System.out.println(hasPathSum2(tree, 14));
    }

    public static boolean hasPathSum(TreeNode root, int sum){
        if (root == null) return false;
        if (root.left == null && root.right == null && sum-root.val == 0) return true;
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }

    public static boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) return false;

        Stack<TreeNode> path = new Stack<>();
        Stack<Integer> sub = new Stack<>();
        path.add(root);
        sub.add(root.val);

        while (!path.isEmpty()) {
            int levelSize = path.size();
            for (int i=0; i<levelSize; i++) {
                TreeNode node = path.pop();
                int temp = sub.pop();
                if (node.left == null && node.right == null) {
                    if (temp == sum) {
                        return true;
                    }
                }
                if (node.left != null) {
                    path.push(node.left);
                    sub.push(temp+node.left.val);
                }
                if (node.right != null) {
                    path.push(node.right);
                    sub.push(temp+node.right.val);
                }
            }
        }
        return false;

    }
}
