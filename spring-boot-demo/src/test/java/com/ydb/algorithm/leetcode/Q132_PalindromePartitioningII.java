package com.ydb.algorithm.leetcode;

public class Q132_PalindromePartitioningII {
    public int minCut(String s) {
        char[] charArray = s.toCharArray();
        int n = charArray.length;
        boolean[][] dp = new boolean[n][n];
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            // 对于前i个字符，最差的情况，每个字母分割一次（单个字母也是回文），需要i次分割
            res[i] = i;
            for (int j = 0; j <= i; j++) {
                if (charArray[i] == charArray[j] && (j -i < 2) || dp[i+1][j-1]) {
                    dp[i][j] = true;
                }
            }
        }
        return -1;
    }
}
