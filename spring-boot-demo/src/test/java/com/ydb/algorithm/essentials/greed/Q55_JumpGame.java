package com.ydb.algorithm.essentials.greed;

import javax.validation.constraints.Max;

public class Q55_JumpGame {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,3,1,1,4}));
    }
    public static boolean canJump(int[] nums) {
        // 从第0个元素出发，能到达的最远距离
        int reach = 1;
        // 到达第0个元素，需要0步
        // 到达第1个元素，需要1步
        // 到达第i个元素，需要i步
        for (int i = 0; i < nums.length; i++) {
            // reach表示能到达的最远距离，如果reach刚好等于i，那么走到第i个元素的时候，剩余步数是0，无法前进。
            if (i >= reach) {
                return false;
            }
            // 从第i个元素触发，能到达的最远距离是i + nums[i] + 1，
            // 注意reach表达的是距离，从第0个元素触发，能到的最远距离是 1+nums[0]，所以需要加1
            reach = Math.max(reach, i + nums[i] + 1);
        }
        return reach > nums.length-1;
    }
}
