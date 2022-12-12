package com.ydb.algorithm.leetcode;

public class Q109 {
    ListNode globeHead;
    public TreeNode sortedListToBST(ListNode head) {
        globeHead = head;
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return toBST(0, length - 1);
    }

    public TreeNode toBST(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right + 1) / 2;
        TreeNode root = new TreeNode();
        root.left = toBST(left, mid - 1);
        root.val = globeHead.val;
        globeHead = globeHead.next;
        root.right = toBST(mid + 1, right);
        return root;
    }
}
