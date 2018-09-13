package com.ydb.algorithm.leetcode;

import java.util.Arrays;

/**
 * @Author ligeng
 * @Date 18/9/13
 * @Time 上午9:05
 */
public class Q62_UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(7,3));
    }
    public static int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++)  {
                // dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
                dp[j] = dp[j] + dp[j-1];
            }
        }
        return dp[n-1];
    }
}
