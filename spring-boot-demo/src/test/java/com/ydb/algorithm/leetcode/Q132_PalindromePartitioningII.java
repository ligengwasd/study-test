package com.ydb.algorithm.leetcode;

/**
 * https://www.cnblogs.com/grandyang/p/4271456.html
 */
public class Q132_PalindromePartitioningII {
    public int minCut(String s) {
        char[] charArray = s.toCharArray();
        int n = charArray.length;
        // i-j范围内是否是回文串
        boolean[][] dp = new boolean[n][n];
        // 表示子串 [0, i] 范围内的最小分割数
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            // 对于前i个字符，最差的情况，每个字母分割一次（单个字母也是回文），需要i次分割
            res[i] = i;
            for (int j = 0; j <= i; j++) {
                if (charArray[i] == charArray[j] && (j -i < 2) || dp[i+1][j-1]) {
                    dp[i][j] = true;
                    res[i] = (j == 0) ? 0 : Math.min(res[i], res[j - 1] + 1);
                }
            }
        }
        return res[n-1];
    }
}
