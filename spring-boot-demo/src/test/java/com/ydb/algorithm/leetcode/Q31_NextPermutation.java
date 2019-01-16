package com.ydb.algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author ligeng
 * @Date 19/1/13
 * @Time 上午1:20
 */
public class Q31_NextPermutation {
    @Test
    public void test() {
        int[] array = new int[]{1,5,1};
        nextPermutation(array);
        System.out.println(1);
    }

    public void nextPermutation(int[] nums) {
        if (nums.length < 2) return;
        int i= nums.length-1;
        while (i>0){
            if (nums[i-1] < nums[i]) {
                break;
            }
            i--;
        }

        if (i==0) {
            reverse(nums, i);
            return;
        }

        int j=nums.length-1;
        while (j>i) {
            if (nums[j] > nums[i-1] && nums[j] <= nums[i]){
                break;
            }
            j--;
        }

        this.swap(nums, i-1, j);

        this.reverse(nums, i);
    }

    private  void reverse(int[] array, int cursor) {
        int end = array.length - 1;
        for (int i = cursor; i <= end; i++, end--) {
            swap(array, i, end);
        }
    }

    public void swap(int s[], int i, int j) {
        int temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
