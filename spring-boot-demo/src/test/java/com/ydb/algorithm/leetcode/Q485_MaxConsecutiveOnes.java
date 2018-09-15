package com.ydb.algorithm.leetcode;

/**
 * @Author ligeng
 * @Date 18/9/15
 * @Time 下午9:25
 */
public class Q485_MaxConsecutiveOnes {
    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxCount = 0;
        for (int i:nums) {
            if (i==0) count = 0;
            if (i==1) count++;
            if (count > maxCount) {
                maxCount = count;
            }
        }
        return maxCount;
    }
}
