package com.ydb.algorithm.leetcode;

/**
 * @Author ligeng
 * @Date 18/9/23
 * @Time 下午8:33
 */
public class Q888_FairCandySwap {
    public static void main(String[] args) {
        int[] ints = fairCandySwap(
                new int[]{1,2,5},
                new int[]{2,4}
                );
        System.out.println(ints);
    }

    public static int[] fairCandySwap(int[] A, int[] B) {
        int sumA=0, sumB=0;
        for (int a:A) {
            sumA += a;
        }
        for (int b:B) {
            sumB += b;
        }

//        int
        if (sumA < sumB) {

        }
        return null;
    }
}
