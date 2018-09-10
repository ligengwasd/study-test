package com.ydb.algorithm.leetcode;

import javax.validation.constraints.Max;

/**
 * @Author ligeng
 * @Date 18/9/10
 * @Time 下午11:16
 */
public class Q11_ContainerWithMostWater {
    public static void main(String[] args) {

    }
    public static int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int maxArea = 0;
        while (left < right) {
            int curArea = Math.min(height[left], height[right]) * (right-left);
            maxArea = Math.max(maxArea, curArea);
            if (height[left] > height[right]) {
                // 所有以right为右边界的容器中，以left为左边界的最大，所以left不需要动。
                right--;
            } else {
                // 所有以left为左边界的容器中，以right为右边界的最大，所以right不需要懂。
                left++;
            }
        }
        return maxArea;
    }
}
