package com.ydb.algorithm.leetcode;

import javax.validation.constraints.Max;

/**
 * @Author ligeng
 * @Date 18/9/13
 * @Time 上午9:48
 */
public class Q64_MinimumPathSum {
    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{
                new int[]{1,3,1},
                new int[]{1,5,1},
//                new int[]{4,2,1},
//                new int[]{1,2},
//                new int[]{5,6},
//                new int[]{1,1},
        }));
    }
    public static int minPathSum(int[][] grid) {
        int width = grid[0].length, height = grid.length;
        int dp[][] = new int[height][width];

        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                if (i==0 && j==0) {
                    dp[i][j] =  grid[i][j];
                } else if (i==0 && j>0) {
                    dp[i][j] = grid[i][j] + dp[i][j-1];
                } else if (i>0 && j==0) {
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
                }
            }
        }
        return dp[height-1][width-1];
    }
}
