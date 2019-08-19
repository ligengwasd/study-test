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
        System.out.println(uniquePaths3(7,3));
    }


    public static int uniquePaths3(int m, int n) {
        if (m==1 || n==1) return 1;
        return uniquePaths3(m-1, n) + uniquePaths3(m,n-1);
    }


    // 状态转移方程：
    //    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
    // 由于每次只用到了dp[i][j]结果的一行数据，所以可以改为用一位数组实现，即uniquePaths()的解法。
    public static int uniquePaths2(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++)  {
                if (i==1 || j==1) {
                    dp[i][j] = 1;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m-1][n-1];
    }

    // 一位数组动态规划。
    public static int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++)  {
                // dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
                // i不变的时候，上述方程式转化为
                // dp[j] = dp[j] + dp[j-1];
                dp[j] = dp[j] + dp[j-1];
            }
        }
        return dp[n-1];
    }
}
