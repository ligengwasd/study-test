package com.ydb.algorithm.leetcode;

import java.util.List;

/**
 * Created by ligeng on 18/1/13.
 */
public class DeleteDuplicates {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;

        Solution solution = new Solution();
        solution.deleteDuplicates(node1);
    }
    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode current = head;
            while (current!= null) {
                if (current.next != null && current.val == current.next.val) {
                    current.next = current.next.next;
                } else {
                    current = current.next;
                }
            }
            return head;
        }
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
