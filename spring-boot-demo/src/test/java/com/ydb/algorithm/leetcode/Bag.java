package com.ydb.algorithm.leetcode;

import com.google.gson.Gson;

import java.util.Arrays;

/**
 * https://labuladong.gitee.io/algo/di-er-zhan-a01c6/bei-bao-le-34bd4/jing-dian--28f3c/
 * https://xie.infoq.cn/article/9cd9d6868446f8a7e1950bbb0
 * 看不懂的话，用笔画一画矩阵图
 */
public class Bag {
    public static void main(String[] args) {
        Bag bag = new Bag();
        int knapsack = bag.knapsack(4, 3, new int[]{2, 1, 3}, new int[]{4, 2, 3});
        System.out.println(knapsack);
    }

    /**
     *
     * @param W 背包重量上限
     * @param I 物品数量
     * @param wt
     * @param val
     * @return
     */
    int knapsack(int W, int I, int[] wt, int[] val) {
        // base case 已初始化。使用W+1，是为了让数组从1开始，这样数组下标就是重量
        int[][] dp = new int[I][W + 1];
        // i = 0的时候，即决策第1个商品的时候，只有1个商品，放的下就放，放不下就是0
        for (int w = 1; w < W + 1; w++) {
            if (w > wt[0]) {
                dp[0][w] = val[0];
            } else {
                dp[0][w] = 0;
            }
        }
        for (int i = 1; i < I; i++) {
            for (int w = 1; w < W + 1; w++) {
                if (w-wt[i] >0) { // 重量上限大于第i个物品的重量，说明可以选择该物品，并且选择后剩余重量（w-wt[i]）用来装其它物品，即dp[i-1][w - wt[i]]
                    dp[i][w] = Math.max(
                            dp[i-1][w],  // 不选择第i个物品
                            dp[i-1][w - wt[i]] + val[i] // 选择第i个物品
                    );
                } else {// 第i个物品超过了重量上限，只能不选择该物品。
                    dp[i][w] = dp[i-1][w];
                }
            }
        }
        return dp[I-1][W];
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
