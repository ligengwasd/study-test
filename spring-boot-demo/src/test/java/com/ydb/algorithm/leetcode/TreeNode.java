package com.ydb.algorithm.leetcode;

import com.ydb.sort.Tree;

/**
 * @Author ligeng
 * @Date 18/9/1
 * @Time 下午3:52
 */
public class TreeNode {
    public Integer val;
    public TreeNode left;
    public TreeNode right;


    TreeNode() {}
    public TreeNode(Integer x) { val = x; }

    public String toString() {
        return val+"";
    }

    public TreeNode(Integer data, TreeNode left, TreeNode right) {
        this.val = data;
        this.left = left;
        this.right = right;
    }

    public static TreeNode getTree() {
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

        return root;
    }
}
