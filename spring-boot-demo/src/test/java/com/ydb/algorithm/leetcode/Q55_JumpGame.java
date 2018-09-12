package com.ydb.algorithm.leetcode;

/**
 * @Author ligeng
 * @Date 18/9/12
 * @Time 上午10:00
 */
public class Q55_JumpGame {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,3,1,1,4}));
    }
    public static boolean canJump(int[] nums) {
        int reach=0;
        for (int i=0; i<nums.length; i++) {
            if (i>reach || reach>=nums.length-1) break;
            reach = Math.max(reach, i+nums[i]);
        }
        return reach >= nums.length-1;
    }
}
