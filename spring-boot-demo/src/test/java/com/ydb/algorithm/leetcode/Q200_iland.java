package com.ydb.algorithm.leetcode;

public class Q200_iland {
    public int numIslands(char[][] grid) {
        //记录岛屿数量
        int count = 0;

        //循环遍历
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    //如果等于1，开始dfs，找到岛屿的边界
                    dfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    //辅助方法：找到岛屿的边界，并把当前岛屿置0，避免重复计算
    public void dfs(char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1'){
            return;
        }

        //将当前位置置0，避免重复计算
        grid[i][j] = '2';

        //搜索上下左右
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

}
