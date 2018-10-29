package com.ydb.algorithm.leetcode;

import java.util.Arrays;

/**
 * @Author ligeng
 * @Date 18/10/29
 * @Time 上午10:11
 */
public class Q561_ArrayPartitionI {
    public static void main(String[] args) {
        Q561_ArrayPartitionI partition = new Q561_ArrayPartitionI();
        int i = partition.arrayPairSum(new int[]{1, 4, 3, 2});
        System.out.println(i);
    }

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum=0;
        for (int i=0; i<nums.length; i+=2) {
            sum += nums[i];
        }
        return sum;
    }
}
