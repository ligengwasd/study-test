package com.ydb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author ligeng
 * @Date 18/11/11
 * @Time 下午7:26
 */
public class Q78_Subsets {
    public static void main(String[] args) {
        Q78_Subsets subsets = new Q78_Subsets();
        List<List<Integer>> list = subsets.subsets3(new int[]{1, 2, 3});
        System.out.println(1);
    }

    //    迭代
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int n : nums) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(n);
                result.add(subset);
            }
        }
        return result;
    }


    //    深度搜索
    public List<List<Integer>> subsets2(int[] nums) {
        Arrays.sort(nums); // 输出要求有序
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> path, int[] nums, int step) {
        if (step == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 不选
        dfs(res, path, nums, step + 1);

        path.add(nums[step]);
        dfs(res, path, nums, step + 1);
        path.remove(new Integer(nums[step]));
    }

    //    二进制法
    public List<List<Integer>> subsets3(int[] nums) {
        Arrays.sort(nums); // 输出要求有序
        List<List<Integer>> result = new ArrayList<>();
        final int n = nums.length;
        ArrayList<Integer> v = new ArrayList<>();

        for (int i = 0; i < 1 << n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i & 1 << j) > 0) {
                    v.add(nums[j]);
                }
            }
            result.add(new ArrayList<>(v));
            v.clear();
        }
        return result;
    }

}