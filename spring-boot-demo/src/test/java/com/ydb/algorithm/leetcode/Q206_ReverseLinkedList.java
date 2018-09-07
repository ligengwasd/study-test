package com.ydb.algorithm.leetcode;

/**
 * @Author ligeng
 * @Date 18/9/6
 * @Time 上午10:06
 */
public class Q206_ReverseLinkedList {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);


        ListNode newHead = reverseList(node1);
    }

    /**
     * 1 2 3 4 5 6
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode newLinkHead = head;
        head = head.next;
        newLinkHead.next = null;

        while (head != null) {
            ListNode temp = head.next;
            head.next = newLinkHead;
            newLinkHead = head;
            head = temp;
        }

        return newLinkHead;
    }
}
