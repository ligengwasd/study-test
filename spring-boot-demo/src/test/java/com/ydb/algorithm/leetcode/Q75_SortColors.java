package com.ydb.algorithm.leetcode;

import com.ydb.sort.Util;
import org.junit.Test;

/**
 * @Author ligeng
 * @Date 19/1/11
 * @Time 下午8:50
 */
public class Q75_SortColors {
    @Test
    public void test() {
        sortColors(new int[]{1,2,0,2,1,1,0});
    }

    public void sortColors(int[] nums) {
        int temp, left=0, right=nums.length-1;
        while (left < right) {
            while (nums[left] == 0 && left < right) {
                left++;
            }
            while (nums[right] != 0 && left < right ) {
                right--;
            }
            swap(nums,left,right);
            Util.print(nums);
        }

        left=0;
        right=nums.length-1;
        while (left < right) {
            while (nums[left] != 2 && left < right) {
                left++;
            }
            while (nums[right] == 2 && left < right ) {
                right--;
            }
            swap(nums,left,right);
            Util.print(nums);
        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
