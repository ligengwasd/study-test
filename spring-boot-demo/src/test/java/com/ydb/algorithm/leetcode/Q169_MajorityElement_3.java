package com.ydb.algorithm.leetcode;

import org.junit.Test;

/**
 * @Author ligeng
 * @Date 19/1/20
 * @Time 下午3:42
 */
public class Q169_MajorityElement_3 {
    @Test
    public void test() {
        int i = majorityElement(new int[]{2,2,1,1,1,2,2});
        System.out.println();
    }

    /**
     * 抵消法。由于超过n/2次，凡是和最多的元素不一样的都抵消掉，剩下的就是最多的那个元素。
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int count = 0;
        int result = 0;
        for (int x : nums) {
            if (count == 0) {
                result = x;
                count = 1;
            } else if (result == x) {
                count++;
            } else {
                count--;
            }
        }
        return result;
    }
}
