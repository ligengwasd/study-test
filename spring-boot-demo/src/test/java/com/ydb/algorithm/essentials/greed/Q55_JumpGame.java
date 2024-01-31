package com.ydb.algorithm.essentials.greed;

import javax.validation.constraints.Max;

public class Q55_JumpGame {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{3,2,1,0}));
    }
    public static boolean canJump(int[] nums) {
        // 从第0个元素出发，能到达的最远距离
        int reach = 1;
        for (int i = 0; i < nums.length; i++) {
            // 到达第0个元素，能到达的最远距离需要大于等于1
            // 到达第i个元素，能到达的最远距离需要大于等于i+1
            // 可以想象前面有一个dummy节点，所有计算都是以dummy节点为开始节点做的计算
            if (reach < i + 1) {
                return false;
            }
            // 从第i个元素触发，能到达的最远距离是i + nums[i] + 1，
            // 注意reach表达的是距离，从第0个元素触发，能到的最远距离是 1+nums[0]，所以需要加1
            reach = Math.max(reach, i + nums[i] + 1);
        }
        return reach > nums.length-1;
    }

    /**
     * 动态规划，更容易理解一点
     * @param nums
     * @return
     */
    public static boolean dp(int[] nums) {

        int[] dp = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            // dp[i]标识到达节点i时的剩余步数，两种情况：
            // 1、是从i-1节点跳到i节点，剩余步数等于 nums[i-1] - 1
            // 2、不是从i-1节点跳到i节点，剩余步数等于 dp[i-1] - 1
            dp[i] = Math.max(dp[i-1], nums[i-1]) - 1;
            if (dp[i] < 0) {
                return false;
            }
        }
        return dp[nums.length-1] >= 0;
    }


}
