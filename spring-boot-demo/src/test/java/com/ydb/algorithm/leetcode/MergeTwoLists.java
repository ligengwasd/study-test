package com.ydb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ligeng on 18/1/10.
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode l1_1 = new ListNode(1);
        ListNode l1_2 = new ListNode(2);
        ListNode l1_3 = new ListNode(4);
        l1_1.next = l1_2;
        l1_2.next = l1_3;

        ListNode l2_1 = new ListNode(1);
        ListNode l2_2 = new ListNode(3);
        ListNode l2_3 = new ListNode(4);
        l2_1.next = l2_2;
        l2_2.next = l2_3;

        ListNode res = mergeTwoLists(l1_1,l2_1);
        System.out.println(res);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        ListNode current1=l1,current2=l2;
        List<ListNode> list = new ArrayList<>();
        while (current1 != null && current2 != null){
            if (current1.val<=current2.val){
                list.add(current1);
                current1 = current1.next;
            } else {
                list.add(current2);
                current2 = current2.next;
            }
        }
        while (current1 != null) {
            list.add(current1);
            current1 = current1.next;
        }
        while (current2 != null) {
            list.add(current2);
            current2 = current2.next;
        }

        for (int i=0;i<list.size(); i++) {
            if (i<list.size()-1){
                list.get(i).next = list.get(i+1);
            }
        }
        return list.get(0);
    }

    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) { val = x; }
    }
}
