package com.ydb.algorithm.leetcode;

/**
 * @Author ligeng
 * @Date 18/9/9
 * @Time 上午12:17
 */
public class Q283_MoveZeroes {
    public static void main(String[] args) {

    }
    public static void moveZeroes(int[] nums) {
        int insertPos = 0;
        for (int i:nums) {
            if (i!=0) {
                nums[insertPos++] = i;
            }
        }
        while (insertPos<nums.length) {
            nums[insertPos++] = 0;
        }
    }
}
