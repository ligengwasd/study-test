package com.ydb.algorithm.leetcode;

/**
 * Created by ligeng on 18/1/11.
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;
        System.out.println(removeElement(nums, val));
    }

    public static int removeElement(int[] nums, int val) {
        int end=0;
        for (int i=0; i<nums.length; i++){
            if (nums[i] != val) {
                nums[end] = nums[i];
                end++;
            }
        }
        return end;
    }
}
