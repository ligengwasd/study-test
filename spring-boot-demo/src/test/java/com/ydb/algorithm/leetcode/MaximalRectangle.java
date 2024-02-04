package com.ydb.algorithm.leetcode;

import java.util.Stack;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int level = matrix.length;
        int[] heights = new int[matrix[0].length];
        for (int i = 0; i < level; i++) {

        }
        return -1;
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
