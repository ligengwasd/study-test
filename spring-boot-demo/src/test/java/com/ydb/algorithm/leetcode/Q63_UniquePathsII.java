package com.ydb.algorithm.leetcode;

import java.util.Arrays;

/**
 * @Author ligeng
 * @Date 18/9/12
 * @Time 下午1:48
 */
public class Q63_UniquePathsII {
    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{
                new int[]{0,0,0,0},
                new int[]{0,1,0,0},
                new int[]{0,0,0,0},
                new int[]{0,0,1,0},
                new int[]{0,0,0,0}
        }));
    }
//    [[0,0,0,0],[0,1,0,0],[0,0,0,0],[0,0,1,0],[0,0,0,0]]
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length, height = obstacleGrid.length;

        int[] dp = new int[width];
        dp[0] = 1;
        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else {
                    if (j>0) {
                        dp[j] = dp[j] + dp[j-1];
                    }
                }
            }
        }
        return dp[width-1];
    }
}
