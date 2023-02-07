package com.ydb.algorithm.essentials.binarytree.search;

import com.ydb.algorithm.leetcode.ListNode;
import com.ydb.algorithm.leetcode.TreeNode;

public class ConvertSortedListToBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode middle = cutAtMiddle(head);
        TreeNode root = new TreeNode(middle.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(middle.next);
        return root;
    }

    ListNode cutAtMiddle(ListNode head) {
        if(head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        // 慢指针的前置节点，因为是单向链表，所以需要额外记录
        ListNode prev_slow = head;
        while(fast != null && fast.next != null){
            prev_slow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 断开链表，如果不断开，下一轮搜索的时候会继续搜。
        prev_slow.next = null;
        return slow;
    }
}
