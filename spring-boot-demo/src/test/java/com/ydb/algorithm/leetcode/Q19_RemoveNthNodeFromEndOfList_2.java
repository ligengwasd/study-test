package com.ydb.algorithm.leetcode;

import org.junit.Test;

/**
 * @Author ligeng
 * @Date 19/1/16
 * @Time 下午7:02
 */
public class Q19_RemoveNthNodeFromEndOfList_2 {
    @Test
    public void test() {
        ListNode node = ListNode.array2List(new int[]{1,2});
        ListNode listNode = removeNthFromEnd(node, 2);
        System.out.println(2);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;

        ListNode fast = fakeHead;
        ListNode slow = fakeHead;

        int i=0;
        while (i<n) {
            fast = fast.next;
            i++;
        }

        if (fast != null) {
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
        } else {

        }
        slow.next = slow.next.next;

        return fakeHead.next;
    }
}
