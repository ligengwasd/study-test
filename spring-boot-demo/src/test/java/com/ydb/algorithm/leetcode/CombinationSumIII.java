package com.ydb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ligeng
 * @Date 19/8/19
 * @Time 下午11:16
 */
public class CombinationSumIII {
    public static void main(String[] args) {
        CombinationSumIII solution = new CombinationSumIII();
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        return result;
    }

    private void dfs(int step, int gap, List<Integer> path, List<List<Integer>> result) {
        if (step == 0) {
            if (gap == 0) {
                result.add(path);
            }
            return;
        }






    }
}
