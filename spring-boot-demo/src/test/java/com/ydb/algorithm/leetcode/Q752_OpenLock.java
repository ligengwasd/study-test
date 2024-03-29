package com.ydb.algorithm.leetcode;

import java.util.Arrays;

public class Q752_OpenLock {
    int openLock(String[] deadends, String target) {
        return 0;
    }

    String[] deadends; String target;
    int minCount = Integer.MAX_VALUE;
    void bfs(int i, int j, int k, int l, int count) {
        String path = i + "" + j + k + l;
        if (Arrays.asList(deadends).contains(path)) {
            return;
        }
        if (target.equals(path)) {
            minCount = Math.min(minCount, count);
            return;
        }
        // 数字变大
        bfs(i == 9 ? 0 : i+1, j, k, l, count + 1);
        bfs(i, j == 9 ? 0 : j+1, k, l, count + 1);
        bfs(i, j, k == 9 ? 0 : k+1, l, count + 1);
        bfs(i, j, k, l == 9 ? 0 : l+1, count + 1);
        // 数字变小
        bfs(i == 0 ? 9 : i+1, j, k, l, count + 1);
        bfs(i, j == 0 ? 9 : j+1, k, l, count + 1);
        bfs(i, j, k == 0 ? 9 : k+1, l, count + 1);
        bfs(i, j, k, l == 0 ? 9 : l+1, count + 1);
    }

}
