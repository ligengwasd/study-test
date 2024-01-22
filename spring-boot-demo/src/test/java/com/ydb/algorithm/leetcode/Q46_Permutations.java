package com.ydb.algorithm.leetcode;

import com.google.gson.Gson;
import org.apache.commons.lang3.BooleanUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 递归解法
 * @Author ligeng
 * @Date 19/1/15
 * @Time 下午8:49
 */
public class Q46_Permutations {
    public static void main(String[] args) {
        Q46_Permutations q = new Q46_Permutations();
        q.traverse(new int[]{1,2,3}, new LinkedList<>(), new Boolean[3]);
    }

    List<LinkedList<Integer>> res = new ArrayList<>();
    public void traverse(int[] nums, LinkedList<Integer> path, Boolean[] used) {
        if (path.size() == nums.length) {
            System.out.println(new Gson().toJson(path));
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i=0 ; i< nums.length; i++) {
            if (BooleanUtils.isTrue(used[i])) continue;
            path.add(nums[i]);
            used[i] = true;
            traverse(nums, path, used);
            path.removeLast();
            used[i] = false;
        }
    }
}
