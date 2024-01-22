package com.ydb.algorithm.leetcode;

import java.util.Arrays;

/**
 * https://labuladong.gitee.io/algo/di-er-zhan-a01c6/bei-bao-le-34bd4/jing-dian--28f3c/
 */
public class Bag {
    public static void main(String[] args) {
        Bag bag = new Bag();
        int knapsack = bag.knapsack(new int[]{2, 1, 3}, new int[]{4, 2, 3});
        System.out.println(knapsack);
    }

    int knapsack(int[] wt, int[] val) {
        int W = wt.length;
        int N = val.length;
        // base case 已初始化
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= W; w++) {
                if (w - wt[i - 1] < 0) {
                    // 这种情况下只能选择不装入背包
                    dp[i][w] = dp[i - 1][w];
                } else {
                    // 装入或者不装入背包，择优
                    dp[i][w] = Math.max(
                            dp[i - 1][w - wt[i-1]] + val[i-1],
                            dp[i - 1][w]
                    );
                }
            }
        }

        return dp[N][W];
    }

    void knapsack(int[] wt, int[] val, int maxWeight, int curr, boolean[] selected) {
        if (maxWeight <= 0 || curr >= wt.length) {
            // 计算结果
            return;
        }
        // 选择
        selected[curr] = true;
        knapsack(wt, val, maxWeight-wt[curr], curr+1, selected);
        // 不选择
        selected[curr] = false;
        knapsack(wt, val, maxWeight, curr+1, selected);
    }
}
