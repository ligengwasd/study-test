package com.ydb.algorithm.essentials.dfs;

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
        List<List<Integer>> lists = solution.combinationSum3(3, 9);
        System.out.println(1);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(k, n, new ArrayList<>(), result, 1);
        return result;
    }

    private void dfs(int step, int gap, List<Integer> path, List<List<Integer>> result, int start) {
        if (step == 0) {
            if (gap == 0) {
                result.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i=start; i<10; i++) {
            if (gap-i <0) return;
            path.add(i);
            dfs(step-1, gap-i, path, result, i+1);
            path.remove(path.size()-1);
        }
    }
}
