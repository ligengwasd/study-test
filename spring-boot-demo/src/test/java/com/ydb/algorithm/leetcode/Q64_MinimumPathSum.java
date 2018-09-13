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
                new int[]{4,2,1},
//                new int[]{1,2},
//                new int[]{5,6},
//                new int[]{1,1},
        }));
    }
    public static int minPathSum(int[][] grid) {
        int width = grid[0].length, height = grid.length;
        int dp[] = new int[width];

        for (int i=0; i<height; i++) {
            int pathX = 0;
            int pathY = 0;
            for (int j=0; j<width; j++) {
                pathX += grid[0][j];
                pathY = 0;
                for (int k=1; k<=i; k++) {
                    pathY += grid[k][j];
                }
                if (j==0) {
                    dp[j] = pathY+pathX;
                } else {
                    dp[j] = Math.min(pathX+pathY, dp[j-1]+grid[i][j]);
                }
            }
        }
        return dp[width-1];
    }
//    public static int getPath(int[][] grid, int x, int y) {
//        int sum=0;
//        for (int i=0; i<x; i++) {
//            sum += grid[i][y];
//        }
//        for (int j=0; j<y; j++) {
//            sum += grid[x][j];
//        }
//        return sum;
//    }
}
