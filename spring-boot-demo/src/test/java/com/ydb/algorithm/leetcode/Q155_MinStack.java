package com.ydb.algorithm.leetcode;

import java.util.Stack;

/**
 * @Author ligeng
 * @Date 18/9/2
 * @Time 下午11:52
 */
public class Q155_MinStack {
    public static void main(String[] args) {

    }

    public static class MinStack {
        private Stack<Integer> stack;
        private int min;

        public MinStack() {
            stack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (x<min) min = x;
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }

    }
}
