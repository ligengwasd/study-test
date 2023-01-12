package com.ydb.algorithm.essentials.dp;

/**
 * 答案：https://www.cnblogs.com/grandyang/p/4322653.html
 * @Author ligeng
 * @Date 19/8/20
 * @Time 下午4:00
 */
public class LargestRectangleHistogram {
    public static void main(String[] args) {
        LargestRectangleHistogram solution = new LargestRectangleHistogram();
        System.out.println(solution.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }

    public int largestRectangleArea(int[] heights) {
        int res = 0;
        for (int i = 0; i < heights.length; ++i) {
            if (i + 1 < heights.length && heights[i] <= heights[i + 1]) {
                continue;
            }
            int minH = heights[i];
            for (int j = i; j >= 0; --j) {
                minH = Math.min(minH, heights[j]);
                int area = minH * (i - j + 1);
                res = Math.max(res, area);
            }
        }
        return res;
    }
}
