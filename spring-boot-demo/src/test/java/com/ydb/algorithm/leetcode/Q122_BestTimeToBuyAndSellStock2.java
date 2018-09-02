package com.ydb.algorithm.leetcode;

/**
 * @Author ligeng
 * @Date 18/9/2
 * @Time 下午9:37
 */
public class Q122_BestTimeToBuyAndSellStock2 {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int total = 0;
        for (int i=0; i<prices.length-1; i++) {
            if (prices[i+1] - prices[i] > 0) {
                total += prices[i+1] - prices[i];
            }
        }
        return total;
    }
}