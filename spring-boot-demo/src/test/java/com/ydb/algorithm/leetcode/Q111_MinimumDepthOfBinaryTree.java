package com.ydb.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author ligeng
 * @Date 18/9/1
 * @Time 下午4:33
 */
public class Q111_MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = Q108_SortedArrayToBST.solution(new Integer[]{3,9,20,null,null,15,7});
        System.out.println(minDepth(root));
    }


    public static int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        Queue<TreeNode> que = new LinkedList<>();
        int level =1;
        que.add(root);
        while(!que.isEmpty()){
            int size = que.size();
            while(size>0){
                TreeNode node =que.poll();
                if(node.left == null && node.right ==null)
                    return level;
                if(node.left != null)
                    que.add(node.left);
                if(node.right != null)
                    que.add(node.right);
                size--;
            }
            level++;
        }
        return level;
    }
}
