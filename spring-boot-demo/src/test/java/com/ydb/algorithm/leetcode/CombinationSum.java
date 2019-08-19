package com.ydb.algorithm.leetcode;

import java.util.*;

/**
 * @Author ligeng
 * @Date 19/8/19
 * @Time 下午5:49
 */
public class CombinationSum {
    public static void main(String[] args) {
        CombinationSum solution = new CombinationSum();
        List<List<Integer>> lists = solution.combinationSum(new int[]{10,1,2,7,6,1,5}, 8);

        System.out.println(1);
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>(); // 最终结果
        List<Integer> path = new ArrayList<>(); // 中间结果
        dfs(nums, path, result, target, 0);
        return result;
    }

    private static void dfs(int[] nums, List<Integer> path,
                            List<List<Integer>> result, int gap, int start) {
        if (gap == 0) {  // 找到一个合法解
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = start; i < nums.length; i++) { // 扩展状态
            if (gap < nums[i]) return; // 剪枝

            path.add(nums[i]); // 执行扩展动作
            dfs(nums, path, result, gap - nums[i], i);
            path.remove(path.size() - 1);  // 撤销动作
        }
    }
}
