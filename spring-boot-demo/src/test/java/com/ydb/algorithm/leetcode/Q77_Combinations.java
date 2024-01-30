package com.ydb.algorithm.leetcode;

import com.google.gson.Gson;

import java.util.LinkedList;

public class Q77_Combinations {
    public static void main(String[] args) {
        Q77_Combinations combinations = new Q77_Combinations();
        combinations.dfs(new LinkedList<>(), 4, 2);
    }

    public void dfs(LinkedList<Integer> path, int n, int k) {
        if (path.size() == k) {
            System.out.println(new Gson().toJson(path));
            return;
        }
        for (int i = 1; i <= n; i++) {
            // 只能选择后面的数字
            if (!path.isEmpty() && i <= path.getLast()) {
                continue;
            }
            path.add(i);
            dfs(path, n, k);
            path.removeLast();
        }
    }
}
