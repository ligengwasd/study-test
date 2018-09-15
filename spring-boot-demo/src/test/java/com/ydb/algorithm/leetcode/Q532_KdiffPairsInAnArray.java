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
        Arrays.sort(nums);
        int res = 0;
        for (int i=0; i<nums.length-1; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (nums[j] - nums[i] == k) {
                    res++;
                    break;
                }
            }
            while(i<nums.length-1 && nums[i] == nums[i+1]) {
                i++;
            }
        }
        return res;
    }
}
