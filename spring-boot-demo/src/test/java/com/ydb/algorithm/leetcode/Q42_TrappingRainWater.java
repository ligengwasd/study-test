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
        int sum=0;
        for (int i=0; i<height.length;i++) {
            int rightHighest = rightHighest(height, i);
            int leftHighest = leftHighest(height, i);
            if (Math.min(rightHighest, leftHighest) > 0) {
                int i1 = Math.min(rightHighest, leftHighest)-height[i];
                sum += i1;
            }
        }

        return sum;
    }

    public int rightHighest(int[] height, int i) {
        int rightHighest = 0;
        for (int right=height.length-1; right>i; right--) {
            rightHighest = Math.max(height[right], rightHighest);
        }
        return rightHighest < height[i] ? 0 : rightHighest;
    }

    public int leftHighest(int[] height, int i) {
        int leftHighest = 0;
        for (int left=0; left<i; left++) {
            leftHighest = Math.max(height[left], leftHighest);
        }
        return leftHighest < height[i] ? 0 : leftHighest;
    }

}
