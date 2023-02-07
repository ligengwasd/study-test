package com.ydb.algorithm.leetcode;

/**
 * @Author ligeng
 * @Date 18/9/6
 * @Time 上午10:06
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
    }

    public ListNode(int x ,ListNode next) {
        val = x;
        this.next = next;
    }

    public static ListNode array2List(int[] array) {
        ListNode head = null;
        ListNode tail = null;
        for (int i:array) {
            if (head == null) {
                head = new ListNode(i);
                tail = head;
                continue;
            }
            tail.next = new ListNode(i);
            tail = tail.next;
        }
        return head;
    }
}
