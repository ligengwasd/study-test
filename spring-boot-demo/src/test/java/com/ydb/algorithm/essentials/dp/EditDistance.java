package com.ydb.algorithm.essentials.dp;

public class EditDistance {
    public static void main(String[] args) {
        EditDistance editDistance = new EditDistance();
        System.out.println(editDistance.minDistance("horse", "ros"));
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < m + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = i;// 这一步表示由一个空串变成pSource的编辑距离
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // 表示当前两个字符串最后的两个元素相等的状况
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[n][m];
    }
    // 递归解法，方便理解
    public int minDistance2(String word1, int i, String word2, int j) {
        if (i<0)
            return j; // i的元素不够，需要新增
        if (j<0)
            return i; // i的元素有多余，需要删除
        if (word1.charAt(i) == word2.charAt(j)) {
            return minDistance2(word1, i-1, word2, j-1);
        }
        return Math.min(
                Math.min(minDistance2(word1, i, word2, j-1), minDistance2(word1, i-1, word2, j)),
                minDistance2(word1, i-1, word2, j-1)
        ) + 1;
    }
}
