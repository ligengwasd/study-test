package com.ydb.algorithm.essentials.binarytree._build;

import com.ydb.algorithm.leetcode.TreeNode;

public class ConstructBinaryTreeFromPreorder {

    public static void main(String[] args) {
        int[] preorder = new int[]{};
        int[] inorder = new int[]{};
        buildTree(preorder, inorder, 0, 0, inorder.length-1);
    }

    /**
     * @param preorder
     * @param inorder
     * @param rootPreorderIndex 前序数组，根节点的下标
     * @param start  中序数组里的开始位置
     * @param end  中序数组里的结束位置
     * @return
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder, int rootPreorderIndex , int start, int end) {
        if (start > end) {
            return null;
        }
        // 创建根节点
        TreeNode root = new TreeNode(preorder[rootPreorderIndex]);
        // 根节点在中序数组中的位置
        int inOrderIndex = findInorderIndex(inorder, start, end, preorder[rootPreorderIndex]);
        // 根节点左侧的节点长度，即左子树的节点数
        int leftTreeSize = inOrderIndex - start;
        // 前序：根->左->右，所以根节点的下一个节点就是该根节点的左节点。左节点作为左子树的根节点，继续搜索。
        root.left =  buildTree(preorder, inorder, rootPreorderIndex + 1, start, inOrderIndex-1);
        // 前序：根->左->右，所以根节点的位置+左子树的长度+1，就是右节点的位置。右节点作为右子树的根节点，继续搜索。
        root.right = buildTree(preorder, inorder, rootPreorderIndex+leftTreeSize+1, inOrderIndex+1, end);
        return root;
    }

    // 在inorder中的下标start到下标end中，寻找 key的下标
    private static int findInorderIndex(int[] inorder, int start, int end, int key) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == key)
                return i;
        }
        return -1;
    }

}
