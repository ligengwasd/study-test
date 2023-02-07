package com.ydb.algorithm.essentials.binarytree.search;

import com.ydb.algorithm.leetcode.TreeNode;

/**
 * https://blog.csdn.net/zangdaiyang1991/article/details/90107927
 */
public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        int[] num = {-10,-3,0,5,9};
        TreeNode treeNode = sortedArrayToBST(num, 0, num.length - 1);
        System.out.println(1);
    }

    private static TreeNode sortedArrayToBST(int[] num, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(num[start]);
        }

        int mid = (start + end + 1) >> 1;
        TreeNode root = new TreeNode(num[mid]);
        root.left = sortedArrayToBST(num, start, mid - 1);
        root.right = sortedArrayToBST(num, mid + 1, end);
        return root;

    }
}
