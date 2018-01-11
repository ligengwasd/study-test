package com.ydb.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by ligeng on 18/1/11.
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,2,2,3}));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int j = 0, n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }
}
