package com.ydb.algorithm.leetcode;

import java.util.Arrays;

/**
 * @Author ligeng
 * @Date 19/1/20
 * @Time 下午3:41
 */
public class Q169_MajorityElement_2 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

}
