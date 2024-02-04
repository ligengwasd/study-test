package com.ydb.algorithm.leetcode;

import java.util.Stack;

/**
 * 算法不正确
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // 记录每个元素上方的柱形高度，并且已初始化为0
        int[][] heightsDp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果当前元素是0，高度就是0，不需要处理
                if (matrix[i][j] == 1) {
                    int preHeight = i == 0 ? 0 : heightsDp[i-1][j];
                    heightsDp[i][j] = preHeight + 1;
                }
            }
        }
        int maxArea = 0;
        for (int k = 0; k < heightsDp.length; k++) {
            maxArea = Math.max(maxArea, max(heightsDp[k]));
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
