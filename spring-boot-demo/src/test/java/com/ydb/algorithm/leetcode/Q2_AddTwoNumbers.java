package com.ydb.algorithm.leetcode;

import org.junit.Test;

/**
 * @Author ligeng
 * @Date 19/1/10
 * @Time 下午9:23
 */
public class Q2_AddTwoNumbers {
    @Test
    public void test() {

        ListNode l1 = new ListNode(0);
//        ListNode l11 = new ListNode(4);
//        ListNode l111 = new ListNode(3);
//        l1.next = l11;
//        l11.next = l111;

        ListNode l2 = new ListNode(0);
//        ListNode l22 = new ListNode(6);
//        ListNode l222 = new ListNode(4);
//        l2.next = l22;
//        l22.next = l222;

        System.out.println(list2Integer(l2));
        ListNode node = addTwoNumbers(l1, l2);
        System.out.println(1);

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int i = list2Integer(l1) + list2Integer(l2);

        ListNode head = null;
        ListNode tail = null;
        while (i>10) {
            if (head == null) {
                head = new ListNode(i%10);
                tail = head;
                i = i/10;
                continue;
            }
            tail.next = new ListNode(i%10);
            tail = tail.next;
            i = i/10;
        }
        if (tail != null) {
            tail.next = new ListNode(i);
        }
        return head;

    }

    public int list2Integer(ListNode l1) {
        Integer sum=0;
        int count = 0;
        while (l1 != null) {
            sum = sum + l1.val * ((int)Math.pow(10, count));
            l1 = l1.next;
            count++;
        }
        return sum;
    }


     public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
     }
}
