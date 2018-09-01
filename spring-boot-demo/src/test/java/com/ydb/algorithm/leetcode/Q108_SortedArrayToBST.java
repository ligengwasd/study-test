package com.ydb.algorithm.leetcode;

/**
 * @Author ligeng
 * @Date 18/9/1
 * @Time 下午3:54
 */
public class Q108_SortedArrayToBST {
    public static void main(String[] args) {
        TreeNode head = solution(new int[]{-10, -3, 0, 5, 9});
        System.out.println(head);
    }

    public static TreeNode solution(int[] nums) {
        if (nums.length==0){
            return null;
        }
        return helper(nums, 0, nums.length-1);

    }

    public static TreeNode helper(int[] num, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = (low+high)/2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = helper(num, low, mid-1);
        root.right = helper(num, mid+1, high);
        return root;
    }
}
