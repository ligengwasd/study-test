package com.ydb.algorithm.leetcode;

public class Q695_MaxAreaOfIsland {
    int maxAreaOfIsland(int[][] grid) {
        int maxArea=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i > grid.length-1 || j < 0 || j > grid[0].length - 1) {
            return 0;
        }
        if (grid[i][j] == 0) {
            // 碰到了海水，终止执行
            return 0;
        }
        if (grid[i][j] == 1) {
            // 陆地变成海水，防止重复计算
            grid[i][j] = 0;
        }
        return  1+dfs(grid, i-1, j)
                + dfs(grid, i+1, j)
                + dfs(grid, i, j-1)
                + dfs(grid, i, j+1);
    }
}
