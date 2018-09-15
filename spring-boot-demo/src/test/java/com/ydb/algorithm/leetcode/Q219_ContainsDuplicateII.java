package com.ydb.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author ligeng
 * @Date 18/9/15
 * @Time 下午9:12
 */
public class Q219_ContainsDuplicateII {
    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1}, 3));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            if (i>k) set.remove(nums[i-k-1]);
            if (!set.add(nums[i])) return true;
        }

        return false;

    }
}
