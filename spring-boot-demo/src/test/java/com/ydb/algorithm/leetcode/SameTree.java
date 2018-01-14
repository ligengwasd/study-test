package com.ydb.algorithm.leetcode;

import java.util.Stack;

/**
 * Created by ligeng on 18/1/14.
 * 两棵树是否完全一模一样
 */
public class SameTree {
    public class TreeNode {
       int val;
       public TreeNode left;
       public TreeNode right;
       TreeNode(int x) { val = x; }
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // recurision method
        if (p == null && q == null) return true;
        if (p == null && q != null || p != null && q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSameTree2(TreeNode p, TreeNode q) {
        // iteration method
        if (p == null && q == null) return true;
        if (p == null && q != null || p != null && q == null) return false;
        Stack<TreeNode> stackP = new Stack<>();
        Stack<TreeNode> stackQ = new Stack<>();
        stackP.add(p);
        stackQ.add(q);
        while (!stackP.isEmpty() && !stackQ.isEmpty()) {
            TreeNode tmpP = stackP.pop();
            TreeNode tmpQ = stackQ.pop();
            if (tmpP.val != tmpQ.val) return false;
            if (tmpP.left != null && tmpQ.left != null) {
                stackP.push(tmpP.left);
                stackQ.push(tmpQ.left);
            } else if (tmpP.left == null && tmpQ.left == null) {
            } else {
                return false;
            }
            if (tmpP.right != null && tmpQ.right != null) {
                stackP.push(tmpP.right);
                stackQ.push(tmpQ.right);
            } else if (tmpP.right == null && tmpQ.right == null) {
            } else {
                return false;
            }
        }
        if (!stackP.isEmpty() || !stackQ.isEmpty()) return false;
        return true;
    }
}
