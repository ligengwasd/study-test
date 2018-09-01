package com.ydb.algorithm.leetcode;

/**
 * @Author ligeng
 * @Date 18/9/1
 * @Time 下午4:11
 */
public class Q110_BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode root = Q108_SortedArrayToBST.solution(new int[]{-10, -3, 0, 5, 9});
        System.out.println(isBalanced(root));
    }
    // 第一种解法
    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(depth(root.left)-depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right) ;
    }
    public static int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right))+1;
    }

    // 第二种解法



}
