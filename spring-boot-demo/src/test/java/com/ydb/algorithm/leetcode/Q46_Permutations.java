package com.ydb.algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归解法
 * @Author ligeng
 * @Date 19/1/15
 * @Time 下午8:49
 */
public class Q46_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        fullArray(nums, 0, nums.length-1, res);
        return res;
    }

    private void fullArray(int[] array, int start, int end,List<List<Integer>> res ) {
        if (start == end) {
            List<Integer> list = new ArrayList<>();
            for (int k:array) {
                list.add(k);
            }
            res.add(list);
        } else {
            for (int i = start; i <= end; i++) {
                swap(array, start, i);
                fullArray(array, start + 1, end, res);
                swap(array, start, i);
            }
        }
    }

    public void swap(int s[], int i, int j) {
        int temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
