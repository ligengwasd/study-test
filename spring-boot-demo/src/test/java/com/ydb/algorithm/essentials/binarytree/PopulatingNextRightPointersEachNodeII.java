package com.ydb.algorithm.essentials.binarytree;

public class PopulatingNextRightPointersEachNodeII {

    public void connect(TreeLinkNode root) {
        while (root !=null ) {
            TreeLinkNode next = null; // the first node of next level
            TreeLinkNode prev = null; // previous node on the same level
            for (; root !=null; root = root.next) {
                TreeLinkNode left = root.left;
                TreeLinkNode right = root.right;
                if (next == null) {
                    next = (left != null ? left : right);
                }
                if (left != null) {
                    if (prev !=null) {
                        prev.next = left;
                    }
                    prev = left;
                }
                if (right != null) {
                    if (prev !=null) {
                        prev.next = right;
                    }
                    prev = right;
                }
                root = next;
            }
        }
    }
}
