package com.ydb.algorithm.leetcode;

import javax.validation.constraints.Max;
import java.util.Arrays;

/**
 * @Author ligeng
 * @Date 19/8/17
 * @Time 下午6:52
 */
public class HouseRobber {
    public static void main(String[] args) {
        System.out.println(rob2(new int[]{2,1,1,2}));
    }


    // DP数组里存储的搜索到第i栋房子的时候， 能抢到的金钱的最大值。
    // 数组还可以进一步优化成两个变量，因为只用到了DP数组的i-1,i-2两个值。
    public static int rob2(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            if (i==0) {
                dp[i] = Math.max(0, nums[i]);
                continue;
            }
            if (i==1) {
                dp[i] = Math.max(nums[i], nums[i-1]);
                continue;
            }
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }

    // 动态规划的原始版本，根据两个变量计算，第一个变量是第i栋房子，第二个变量是抢或者不抢
    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[][] dp = new int[nums.length][2];

        for (int i=0; i<nums.length; i++) {
            if (i==0) {
                dp[0][0] = 0;
                dp[0][1] = nums[i];
                continue;
            }
            if (i==1) {
                dp[1][0] = Math.max(dp[0][0], dp[0][1]);
                dp[1][1] = nums[i];
                continue;
            }

            dp[i][0] =  Math.max(dp[i-1][1] , dp[i-1][0] );
            dp[i][1] = Math.max(dp[i-2][1] , dp[i-2][0] ) + nums[i];
        }

        return Math.max(dp[nums.length-1][0], dp[nums.length-1][1]) ;
    }
}
