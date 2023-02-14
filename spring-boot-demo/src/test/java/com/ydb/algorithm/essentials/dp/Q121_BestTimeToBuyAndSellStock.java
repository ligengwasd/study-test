package com.ydb.algorithm.essentials.dp;

/**
 * 通用解法地址：
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/yi-ge-tong-yong-fang-fa-tuan-mie-6-dao-gu-piao-wen/#comment
 *
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
            // res表示第i步之前卖出的最大获利；
            // i-minPriceBeforeHere表示在第i步卖出的获利。
            res = Math.max(res, i-minPriceBeforeHere);
        }
        return res;
    }
}
