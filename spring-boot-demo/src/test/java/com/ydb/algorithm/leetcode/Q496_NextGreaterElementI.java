package com.ydb.algorithm.leetcode;

import java.util.Stack;

public class Q496_NextGreaterElementI {
    public static void main(String[] args) {

    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 构建递减栈
        Stack<Integer> stack = new Stack<>();
        for (int i = nums1.length - 1; i >= 0; i--) {
            if (i == nums1.length - 1) {
                nums2[i] = -1;
                stack.push(nums1[i]);
                continue;
            }
            // i比栈顶元素大，弹出栈顶元素
            while (!stack.isEmpty() && nums1[i] > stack.peek()) {
                Integer pop = stack.pop();
            }
            // i比栈顶元素小，栈顶就是比i大的第一个元素
            nums1[i] = stack.peek();
            stack.push(nums1[i]);
        }
        return nums2;
    }
}
