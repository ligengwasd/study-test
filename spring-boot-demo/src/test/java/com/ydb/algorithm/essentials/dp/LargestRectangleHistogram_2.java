package com.ydb.algorithm.essentials.dp;

import java.util.Stack;

public class LargestRectangleHistogram_2 {
    public static void main(String[] args) {
        int[] heights = new int[] {2,1,5,6,2,3};
        // 在原数据的头尾分别加上0
        int[] tmp = new int[heights.length+2];
        System.arraycopy(heights, 0, tmp, 1, heights.length);
        //存的是数组下标，单调递增栈
        Stack<Integer> stack = new Stack<>();
        int maxArea=0;
        for (int i=0; i<tmp.length; i++) {
            // 当第i个元素小于栈顶元素时，计算以栈顶元素为高的矩形面积
            while (!stack.isEmpty() && tmp[i] < tmp[stack.peek()]) {
                int currHeight = tmp[stack.pop()];
                // 宽度计算：元素i比栈顶元素小，栈顶元素的前一个元素是离栈顶元素最近的比它小的元素。
                maxArea = Math.max(maxArea, currHeight * (i - stack.peek()-1));
            }
            stack.push(i);
        }
        System.out.println("最大矩形面积是:" + maxArea);
    }
}
