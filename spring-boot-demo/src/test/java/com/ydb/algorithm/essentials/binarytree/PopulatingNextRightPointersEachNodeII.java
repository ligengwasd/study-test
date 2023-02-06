package com.ydb.algorithm.essentials.binarytree;

public class PopulatingNextRightPointersEachNodeII {

    public void connect(TreeLinkNode root) {
        while (root != null) {
            TreeLinkNode next = null; // the first node of next level
            TreeLinkNode prev = null; // previous node on the same level
            for (; root != null; root = root.next) {
                TreeLinkNode left = root.left;
                TreeLinkNode right = root.right;
                // 1.维护next指针
                if (next == null) {
                    next = (left != null ? left : right);
                }
                // 2.左节点，关联上链表
                if (left != null) {
                    if (prev != null) {
                        prev.next = left;
                    } else {
                        prev = left;
                    }
                }
                // 3.右节点，关联上链表
                if (right != null) {
                    if (prev != null) {
                        prev.next = right;
                    } else {
                        prev = right;
                    }
                }
            }
            root = next;
        }
    }
}
