package com.ydb.algorithm.leetcode;

/**
 * @Author ligeng
 * @Date 18/9/3
 * @Time 上午12:27
 */
public class Q160_IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
//        node4.next = node3;


        System.out.println(getIntersectionNode(node1, node4).val);
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getLength(headA), lengthB= getLength(headB);
        while (lengthA > lengthB) {
            headA = headA.next;
            lengthA--;
        }
        while (lengthB > lengthA) {
            headB = headB.next;
            lengthB--;
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    public static int getLength(ListNode head) {
        int length=0;
        while (head!= null) {
            length++;
            head = head.next;
        }
        return length;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
           val = x;
           next = null;
        }


    }
}
