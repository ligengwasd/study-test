package com.ydb.algorithm.leetcode;

import org.junit.Test;

/**
 * @Author ligeng
 * @Date 19/1/16
 * @Time 下午5:05
 */
public class Q42_TrappingRainWater {
    @Test
    public void test() {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    public int trap(int[] height) {
        int sum=0 ,start=1;
        for (int i=2; i<height.length-1;i++) {
            if (height[i] < height[start]) {
                continue;
            } else {
                if (height[i]>=height[start]) {
                    sum += Math.min(height[i],height[start]) * (i-start-1);

                    int temp=start+1;
                    while (temp<i) {
                        sum -= height[temp];
                        temp++;
                    }

                    start = i;
                }
            }
        }

        return sum;
    }
}
