package com.ydb.algorithm.leetcode;

import org.junit.Test;

/**
 * @Author ligeng
 * @Date 19/1/16
 * @Time 下午6:02
 */
public class Q42_TrappingRainWater_2 {
    @Test
    public void test() {
        System.out.println(trap(new int[]{2,0,2}));
    }

    public int trap(int[] height) {
        int max = 0;
        int res = 0;
        // 第i个元素左边的最大值。
        int[] container = new int[height.length];
        for (int i=0; i<height.length; i++) {
            container[i] = max;
            max = Math.max(max, height[i]);
        }

        max = 0;
        for (int i = height.length-1; i>0; i--) {
            //  此处max表示第i个元素右边的最大值。
            container[i] = Math.min(max, container[i]);
            if (container[i]>0 && container[i]>height[i]) {
                res += (container[i]-height[i]);
            }
            max = Math.max(max, height[i]);
        }

        return res;
    }
}
