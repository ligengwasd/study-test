package com.ydb.algorithm.leetcode;


public class Q99_RecoverBinarySearchTree {
    public static void main(String[] args) {

    }

    TreeNode first;
    TreeNode second;
    TreeNode pre;// 前一个节点，就是根节点
    public void recoverTree(TreeNode root) {
        recoverTree(root.left);
        if (pre != null && root.val < pre.val ) {
            //第一次遇到逆序对
            if (first==null){
                first = pre;
                second = root;
            //第二次遇到逆序对
            }else{
                second = root;
            }
        }
        pre = root;
        recoverTree(root.right);
    }
}
