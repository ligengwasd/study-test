package com.ydb.algorithm.leetcode;

/**
 * @Author ligeng
 * @Date 18/9/6
 * @Time 上午9:32
 */
public class Q190_ReverseBits {
    public static void main(String[] args) {
        System.out.println(reverseBits(43261596));
    }



    public static int reverseBits(int n) {
        int res = 0;
        for (int i=0; i<32; i++) {
            res += n&1;
            n >>>= 1;
            if (i<31) res <<= 1;
        }
        return res;
    }
}
