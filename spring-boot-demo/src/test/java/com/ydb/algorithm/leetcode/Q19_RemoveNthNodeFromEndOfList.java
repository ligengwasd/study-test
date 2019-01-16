package com.ydb.algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author ligeng
 * @Date 19/1/16
 * @Time 下午6:48
 */
public class Q19_RemoveNthNodeFromEndOfList {
    @Test
    public void test() {
        ListNode node = ListNode.array2List(new int[]{1,2});
        removeNthFromEnd(node, 2);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 1;
        ListNode start = head;
        while (start.next != null) {
            start = start.next;
            count++;
        }

        if (count==1) return null;

        int count2 = count - n, temp=1;
        if (count2 == 0) {
            head = head.next;
            return head;
        }

        start = head;
        while (start.next != null && temp < count2) {
            start = start.next;
            temp++;
        }
        start.next = start.next.next;
        return head;
    }
}
