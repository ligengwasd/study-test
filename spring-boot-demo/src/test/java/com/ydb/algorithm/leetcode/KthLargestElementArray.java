package com.ydb.algorithm.leetcode;

import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @Author ligeng
 * @Date 19/8/21
 * @Time 上午10:19
 */
public class KthLargestElementArray {
    public static void main(String[] args) {
        KthLargestElementArray solution = new KthLargestElementArray();
        System.out.println(solution.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int val:nums) {
            queue.offer(val);
            if (queue.size() > k) {
                // 根节点是最小的，把最小的节点弹出去。
                queue.poll();
            }
        }
        return queue.peek();
    }
}
