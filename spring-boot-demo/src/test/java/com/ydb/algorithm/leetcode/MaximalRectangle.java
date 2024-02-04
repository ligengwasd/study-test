package com.ydb.algorithm.leetcode;

import java.util.Stack;

/**
 * 算法不正确
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int level = matrix.length;
        int[] heights = new int[matrix[0].length];
        int maxArea = 0;
        for (int i = 0; i < level; i++) {
            for (int j = 0; j < heights.length; j++) {
                if (matrix[i][j] == 1) {
                    heights[j] = heights[j] + 1;
                } else {
                    heights[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, max(heights));
        }
        return maxArea;
    }

    /**
     * 单调递增栈求做到面积
     * @param heights
     * @return
     */
    public int max(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                Integer pop = stack.pop();
                maxArea = Math.max(
                        maxArea,
                        heights[pop] * (i - stack.peek() -1)
                        );
            }
            stack.push(i);
        }
        return maxArea;
    }
}
