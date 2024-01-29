package com.ydb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q239_SlidingWindowMaximum {
    int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                //先把窗口的前 k - 1 填满
                window.push(nums[i]);
            } else {
                // 窗口开始向前滑动
                // 移入新元素
                window.push(nums[i]);
                // 将当前窗口中的最大元素记入结果
                res.add(window.max());
                // 移出最后的元素
                window.pop(nums[i - k + 1]);
            }
        }
        // 将 List 类型转化成 int[] 数组作为返回值
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    class MonotonicQueue {
        // 双链表，支持头部和尾部增删元素
        // 维护其中的元素自尾部到头部单调递增
        private LinkedList<Integer> maxq = new LinkedList<>();

        // 在队尾添加元素 n
        void push(int n) {
            // 将前面小于自己的元素都删除
            while (!maxq.isEmpty() && maxq.getLast() < n) {
                maxq.pollLast();
            }
            maxq.addLast(n);
        }
        // 返回当前队列中的最大值
        int max() {
            return maxq.getFirst();
        }
        // 队头元素如果是 n，删除它
        void pop(int n) {

        }
    }

}
