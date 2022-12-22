package com.ydb.javastructures.binarytree;

/**
 * 判断一棵树是否是另一棵树的子树
 */
public class IsSubtree {
    public boolean isSubtree(Node root, Node subRoot) {
        if(root==null){//判断root是否为空
            return false;
        }
        if(isSameTree(root,subRoot)){
            //判断subRoot的根结点是否为root 的根结点
            return true;
        }
        if (isSubtree(root.leftChild, subRoot)){
            //subRoot的根结点是否为root 的左孩子
            return true;
        }
        if(isSubtree(root.rightChild,subRoot)){
            //subRoot的根结点是否为root 的右孩子
            return true;
        }
        return false;
    }

    public static boolean isSameTree(Node p, Node q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.iData != q.iData) {
            return false;
        }
        return isSameTree(p.leftChild, q.leftChild) && isSameTree(p.rightChild, q.rightChild);
    }
}
