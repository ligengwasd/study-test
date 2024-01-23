package com.ydb.algorithm.leetcode;

public class Q200_iland {
    public int numIslands(char[][] grid) {
        //记录岛屿数量
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i > grid.length-1 || j < 0 || j > grid[0].length - 1) {
            return;
        }
        if (grid[i][j] == '0') {
            // 碰到了海水，终止执行
            return;
        }
        if (grid[i][j] == '1') {
            // 陆地变成海水，防止重复计算
            grid[i][j] = '0';
        }
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }

}
