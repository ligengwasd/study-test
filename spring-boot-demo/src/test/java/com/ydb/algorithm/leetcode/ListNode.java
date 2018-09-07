package com.ydb.algorithm.leetcode;

/**
 * @Author ligeng
 * @Date 18/9/6
 * @Time 上午10:06
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }

    ListNode(int x ,ListNode next) {
        val = x;
        this.next = next;
    }
}
