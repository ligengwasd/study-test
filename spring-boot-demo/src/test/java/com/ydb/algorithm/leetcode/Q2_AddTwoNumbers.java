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
        System.out.println(Integer.MAX_VALUE);

        ListNode l1 = array2List(new int[]{1,9,9,9,9,9,9,9,9,9});
        ListNode l2 = array2List(new int[]{9});


//        ListNode l1 = new ListNode(2);
//        ListNode l11 = new ListNode(4);
//        ListNode l111 = new ListNode(3);
//        l1.next = l11;
//        l11.next = l111;
//
//        ListNode l2 = new ListNode(5);
//        ListNode l22 = new ListNode(6);
//        ListNode l222 = new ListNode(4);
//        l2.next = l22;
//        l22.next = l222;
//
//        System.out.println(list2Integer(l2));
        ListNode node = addTwoNumbers(l1, l2);
        System.out.println(1);

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            ListNode cur = new ListNode(0);
            int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            prev.next = cur;
            prev = cur;

            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return head.next;

    }

    public long list2Integer(ListNode l1) {
        long sum=0;
        int count = 0;
        while (l1 != null) {
            sum = sum + l1.val * ((int)Math.pow(10, count));
            l1 = l1.next;
            count++;
        }
        return sum;
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


     public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
     }
}
