package com.ydb.algorithm.leetcode;

import com.ydb.sort.Tree;

/**
 * @Author ligeng
 * @Date 18/9/1
 * @Time 下午3:52
 */
public class TreeNode {
    Integer val;
    TreeNode left;
    TreeNode right;
    TreeNode(Integer x) { val = x; }

    public String toString() {
        return val+"";
    }

    public TreeNode(Integer data, TreeNode left, TreeNode right) {
        this.val = data;
        this.left = left;
        this.right = right;
    }
}
