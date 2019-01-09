package com.ydb.algorithm.leetcode;

import com.ydb.sort.Util;
import org.junit.Test;

/**
 * @Author ligeng
 * @Date 19/1/7
 * @Time 上午10:53
 */
public class Q80_RemoveDuplicatesFromSortedArrayII {
    @Test
    public void test() {
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
    }

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums){
            if (i < 2 || n > nums[i-2]) {
                nums[i++] = n;
            }
            Util.print(nums);
        }
        return i;
    }
}
