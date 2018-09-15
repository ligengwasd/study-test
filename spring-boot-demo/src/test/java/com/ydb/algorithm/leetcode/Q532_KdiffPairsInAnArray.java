package com.ydb.algorithm.leetcode;

import java.util.*;

/**
 * @Author ligeng
 * @Date 18/9/15
 * @Time 下午9:30
 */
public class Q532_KdiffPairsInAnArray {
    public static void main(String[] args) {
        System.out.println(findPairs(new int[]{1,1,1,2,1}, 1));
    }

    public static int findPairs(int[] nums, int k) {
        Set<Set<Integer>> set = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    HashSet<Integer> integers = new HashSet<>();
                    integers.add(nums[i]);
                    integers.add(nums[j]);
                    set.add(integers);
                }
            }
        }
        return set.size();
    }
}
