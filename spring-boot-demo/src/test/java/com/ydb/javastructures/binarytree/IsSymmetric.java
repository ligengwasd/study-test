package com.ydb.javastructures.binarytree;

/**
 * 判断是否是对称二叉树
 */
public class IsSymmetric {
    public boolean isSymmetricChild(Node leftTree, Node rightTree){
        if(leftTree==null&&rightTree!=null||leftTree!=null&&rightTree==null){
            return false;
        }
        if(leftTree==null&&rightTree==null){
            return true;
        }
        if (leftTree.iData!=rightTree.iData){
            return false;
        }
        return isSymmetricChild(leftTree.leftChild,rightTree.leftChild)&&isSymmetricChild(leftTree.rightChild,rightTree.leftChild);
    }
    public boolean isSymmetric(Node root) {
        if (root==null){
            return false;
        }
        return isSymmetricChild(root.leftChild,root.rightChild);
    }
}
