package com.ydb.algorithm.leetcode;

/**
 * Created by ligeng on 18/1/13.
 */
public class MergeSortedArray {
    public static void main(String[] args) {

    }
    static class Solution {
        public void merge(int[] A, int m, int[] B, int n) {
            while(n>0)A[m+n-1]=(m==0||B[n-1]>A[m-1])?B[--n]:A[--m];
        }
    }
}
