package com.ydb.algorithm.essentials.binarytree;

public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        Integer n = 10;

        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 1;

        for (int i=2; i<=n; i++) {
            for (int j = 1; j<=i; j++) {
                f[i] = f[i] + f[j-1]*f[i-j];
            }
        }
        System.out.println(f[n]);
    }
}
