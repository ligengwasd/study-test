package com.ydb.algorithm.leetcode;

/**
 * @Author ligeng
 * @Date 18/9/2
 * @Time 下午7:23
 */
public class Q121_BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
    public static int maxProfit(int[] prices) {
        int minPriceBeforeHere = Integer.MAX_VALUE;
        int res=0;
        for (int i:prices) {
            minPriceBeforeHere = Math.min(minPriceBeforeHere, i);
            res = Math.max(res, i-minPriceBeforeHere);
        }
        return res;
    }
}
