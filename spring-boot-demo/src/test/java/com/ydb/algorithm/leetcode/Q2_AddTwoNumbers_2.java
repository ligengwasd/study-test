package com.ydb.algorithm.leetcode;

import org.junit.Test;

/**
 * @Author ligeng
 * @Date 19/1/10
 * @Time 下午10:43
 */
public class Q2_AddTwoNumbers_2 {
    @Test
    public void test() {

        ListNode l1 = array2List(new int[]{2,4,3});
        ListNode l2 = array2List(new int[]{5,6,4});

        this.addTwoNumbers(l1, l2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;

        int value1=0;
        int value2=0;
        ListNode tail = new ListNode(0);
        ListNode fakeHead = tail;

        while (l1!=null && l2!=null) {
            // (l1.val+l2.val)大于10，value1=1，表示下一次迭代要进一位。
            value2 = (l1.val+l2.val+value1)%10;
            // 重新计算value1
            value1 = (l1.val+l2.val+value1)/10;

            tail.next = new ListNode(value2);
            l1 = l1.next;
            l2 = l2.next;
            tail = tail.next;

            if (l1==null && l2==null) break;
            if (l1==null) l1 = new ListNode(0);
            if (l2==null) l2 = new ListNode(0);
        }

        if (value1 != 0) {
            tail.next = new ListNode(value1);
        }

        return fakeHead.next;
    }



    public ListNode array2List(int[] array) {
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
