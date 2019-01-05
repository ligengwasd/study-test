package com.ydb.algorithm.leetcode;

import java.io.InputStream;
import java.util.HashSet;
import java.util.stream.IntStream;

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
        int dif = (IntStream.of(A).sum() - IntStream.of(B).sum())/2;
        HashSet<Integer> S = new HashSet<>();
        for (int a : A) S.add(a);
        for (int b : B) if (S.contains(b + dif)) return new int[] {b + dif, b};

        return new int[0];
    }
}
