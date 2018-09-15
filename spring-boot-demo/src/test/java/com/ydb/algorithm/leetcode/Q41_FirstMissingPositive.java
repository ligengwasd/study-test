package com.ydb.algorithm.leetcode;

import java.util.Arrays;

/**
 * @Author ligeng
 * @Date 18/9/15
 * @Time 下午5:02
 */
public class Q41_FirstMissingPositive {
    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1000,-1}));
    }

    public static int firstMissingPositive(int[] nums) {
        if (nums.length == 0) return 1;
        Arrays.sort(nums);
        if (nums[0] > 1) return 1;

        for (int i=1; i<nums.length; i++) {
            if (nums[i] > 0)  {
                if (nums[i-1] < 0) {
                    if (nums[i] > 1) return 1;
                } else {
                    if (nums[i] - nums[i-1] > 1) {
                        return nums[i-1]+1;
                    }
                }
            }
        }
        return nums[nums.length-1] + 1;
    }
}
