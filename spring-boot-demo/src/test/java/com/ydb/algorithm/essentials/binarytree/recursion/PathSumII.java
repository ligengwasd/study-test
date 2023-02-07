package com.ydb.algorithm.essentials.binarytree.recursion;

import com.ydb.algorithm.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public static void main(String[] args) {

    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(res, root, new ArrayList<Integer>(), sum);
        return res;
    }
    public void helper(List<List<Integer>> res, TreeNode root, ArrayList<Integer> path, int sum) {
        //base case: leaf
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                path.add(root.val);
                res.add(new ArrayList<Integer>(path));
                path.remove(path.size() - 1);
            }
            return;
        }
        //recursion rule: non-leaf
        path.add(root.val);
        if (root.left != null) helper(res, root.left, path, sum - root.val);
        if (root.right != null) helper(res, root.right, path, sum - root.val);
        path.remove(path.size() - 1);
        return;
    }
}
