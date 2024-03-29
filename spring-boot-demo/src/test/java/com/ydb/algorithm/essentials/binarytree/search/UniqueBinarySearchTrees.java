package com.ydb.algorithm.essentials.binarytree.search;

public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        Integer n = 10;

        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 1;

        // i：表示总节点数
        // j：表示树的左节点数
        for (int i=2; i<=n; i++) {
            for (int j =0; j<i; j++) {
                f[i] = f[i] + f[j]*f[i-j-1];
            }
        }
        System.out.println(f[n]);
    }
}
