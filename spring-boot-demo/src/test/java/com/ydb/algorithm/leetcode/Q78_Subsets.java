package com.ydb.algorithm.leetcode;

import com.google.gson.Gson;

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
        List<List<Integer>> list = subsets.subsets(new int[]{1, 2, 3});
        list.stream().forEach(
                o -> System.out.println(new Gson().toJson(o))
        );
        System.out.println(1);
    }

    //    迭代
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        // 每新增一个元素，就遍历result，在原来result上组装新的元素，然后压入result。
        for (int i=0; i<=nums.length-1; i++) {
            int size = result.size();
            for (int j = 0; j<= size -1; j++) {
                List<Integer> originItem = result.get(j);
                ArrayList<Integer> newItem = new ArrayList<Integer>();
                newItem.addAll(originItem);
                newItem.add(nums[i]);
                result.add(newItem);
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
        // 不选nums[step]
        dfs(res, path, nums, step + 1);
        // 选nums[step]
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