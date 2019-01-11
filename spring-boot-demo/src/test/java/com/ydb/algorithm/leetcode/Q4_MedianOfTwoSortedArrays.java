package com.ydb.algorithm.leetcode;

import com.ydb.sort.Util;
import org.junit.Test;

/**
 * @Author ligeng
 * @Date 19/1/11
 * @Time 下午4:34
 */
public class Q4_MedianOfTwoSortedArrays {
    @Test
    public void test() {
        System.out.println(findMedianSortedArrays(
                new int[]{1},
                new int[]{}
        ));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0, j=0, k=0;
        int[] newArray = new int[nums1.length+nums2.length];
        while (i<nums1.length && j<nums2.length) {
            newArray[k++] = (nums1[i] < nums2[j]) ? nums1[i++] : nums2[j++];
        }
        while (i<nums1.length) {
            newArray[k++] = nums1[i++];
        }
        while (j<nums2.length) {
            newArray[k++] = nums2[j++];
        }
        Util.print(newArray);
        if (k%2 == 1) {
            return Double.valueOf(newArray[k/2+1-1]);
        } else {
            return Double.valueOf(newArray[k/2-1] + newArray[k/2+1-1])/2;
        }
    }
}
