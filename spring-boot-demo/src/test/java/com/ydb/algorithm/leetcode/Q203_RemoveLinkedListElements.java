package com.ydb.algorithm.leetcode;

/**
 * @Author ligeng
 * @Date 18/9/8
 * @Time 上午12:56
 */
public class Q203_RemoveLinkedListElements {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(1, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1);

        ListNode node = removeElements(null, 1);
        System.out.println(1);
    }
    public static ListNode removeElements(ListNode head, int val) {
        while (head !=null && head.val == val) head = head.next;
        ListNode current = head;// head不等于val
        while (current != null) {
            if (current.next != null && current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}
