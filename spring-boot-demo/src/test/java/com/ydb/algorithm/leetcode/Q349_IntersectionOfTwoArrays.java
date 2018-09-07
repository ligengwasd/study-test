package com.ydb.algorithm.leetcode;

import org.omg.CORBA.INTERNAL;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author ligeng
 * @Date 18/9/6
 * @Time 上午9:41
 */
public class Q349_IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] intersection = intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        System.out.println(intersection);
    }
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> res =  new HashSet<>();
        for (int i:nums1) {
            set1.add(i);
        }
        for (int i:nums2) {
            set2.add(i);
        }

        res.addAll(set1);
        res.retainAll(set2);

        int[] array = new int[res.size()];
        for (int i=0; i<res.toArray().length; i++) {
            array[i] = (int)res.toArray()[i];
        }
        return array;
    }
}
