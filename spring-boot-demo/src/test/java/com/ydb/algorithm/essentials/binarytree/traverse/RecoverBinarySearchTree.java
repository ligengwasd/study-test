package com.ydb.algorithm.essentials.binarytree.traverse;

import com.ydb.algorithm.leetcode.TreeNode;

/**
 * 文章详解：
 * https://blog.csdn.net/level_code/article/details/90679983
 */
public class RecoverBinarySearchTree {
    private TreeNode pre;
    private TreeNode first;
    private TreeNode second;
    public static void main(String[] args) {
    }

    private void solution(TreeNode root) {
        this.inOrder(root);
        //swap val
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    //找到第一次降序的第一个node，和最后一次降序的第二个node
    void inOrder(TreeNode root) {
        inOrder(root.left);
        // pre是之前的root。
        if (pre != null && pre.val > root.val) {
            if (first == null) {//第一次降序
                first = pre;
            }
            second = root;//每次降序都记下第二个元素
        }
        pre = root;
        inOrder(root.right);
    }

}
