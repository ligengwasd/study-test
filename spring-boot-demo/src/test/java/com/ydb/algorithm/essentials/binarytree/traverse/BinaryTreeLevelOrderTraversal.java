package com.ydb.algorithm.essentials.binarytree.traverse;

import com.ydb.algorithm.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<TreeNode>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<TreeNode>> result = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<TreeNode> level = new ArrayList<>();
            for (int i=0; i<levelSize; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    level.add(poll.left);
                }
                if (poll.right != null) {
                    level.add(poll.right);
                }
                level.add(poll);
            }
            result.add(level);
        }

        return result;
    }
}
