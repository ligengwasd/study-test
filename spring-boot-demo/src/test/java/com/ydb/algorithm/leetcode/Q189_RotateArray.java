package com.ydb.algorithm.leetcode;

/**
 * @Author ligeng
 * @Date 18/9/6
 * @Time 上午9:22
 */
public class Q189_RotateArray {
    public static void main(String[] args) {
        rotate(new int[]{1,2,3,4,5,6,7}, 3);
    }
    public static void rotate(int[] nums, int k) {
        for (int j=0; j<k; j++) {
            int last = nums[nums.length-1];
            for (int i=nums.length-2; i>=0; i--) {
                nums[i+1] = nums[i];
            }
            nums[0] = last;
        }
        System.out.println();
    }
}
