package com.ydb.algorithm.leetcode;

/**
 * @Author ligeng
 * @Date 18/9/8
 * @Time 下午11:13
 */
public class Q191_NumberOf1Bits {
    public static void main(String[] args) {
        System.out.println(hammingWeight(128));
    }
    public static int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
