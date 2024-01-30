package com.ydb.algorithm.essentials.greed;

import javax.validation.constraints.Max;

public class Q55_JumpGame {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,3,1,1,4}));
    }
    public static boolean canJump(int[] nums) {
        int reach=1;
        // i从1开始，i表示第i-1个节点
        for (int i = 1; i <= nums.length; i++) {
            // 最大能到的距离小于i（i是从0开始的距离），说明无法走到节点i
            if (i > reach) {
                return false;
            }
            reach = Math.max(reach, i + nums[i-1]);
        }
        return reach >= nums.length;

    }
}
