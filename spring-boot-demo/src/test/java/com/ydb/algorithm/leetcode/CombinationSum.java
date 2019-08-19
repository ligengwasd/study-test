package com.ydb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author ligeng
 * @Date 19/8/19
 * @Time 下午5:49
 */
public class CombinationSum {
    public static void main(String[] args) {
        CombinationSum solution = new CombinationSum();
        List<List<Integer>> lists = solution.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
        System.out.println(1);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(new ArrayList<>(), candidates, target, res, 0);
        return res;
    }

    public void dfs(List<Integer> path, int[] candidates, int gap, List<List<Integer>> res, int start) {
        if (gap == 0) {  // 找到一个合法解
            res.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i=start; i<candidates.length; i++) {
            if (candidates[i] <= gap) {
                path.add(candidates[i]);
                dfs(path, candidates, gap-candidates[i], res, i+1);
                path.remove(path.size()-1);
            }
        }
    }
}
