package com.ydb.algorithm.leetcode;

/**
 * @Author ligeng
 * @Date 18/9/23
 * @Time 下午8:09
 */
public class Q896_MonotonicArray {
    public static void main(String[] args) {
        System.out.println(isMonotonic(new int[]{1,2,2,3}));
    }

    public static boolean isMonotonic(int[] A) {
        Boolean firstTrend=null;
        for (int i=0; i<A.length-1; i++) {
            if (A[i] == A[i+1]) continue;

            if (firstTrend == null) {
                firstTrend = A[i] < A[i+1] ? true : false;
            } else {
                boolean tempTrend = A[i] < A[i+1] ? true : false;
                if (firstTrend != tempTrend) {
                    return false;
                }
            }
        }
        return true;
    }
}
