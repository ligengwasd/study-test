package com.ydb.algorithm.essentials.binarytree.search;

import com.ydb.algorithm.leetcode.ListNode;

public class ConvertSortedListToBinarySearchTree {
    ListNode cutAtMiddle(ListNode head) {
        if(head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev_slow = head;
        while(fast != null && fast.next != null){
            prev_slow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev_slow.next = null;
        return slow;
    }
}
