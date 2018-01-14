package com.ydb.algorithm.leetcode;

/**
 * Created by ligeng on 18/1/13.
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        int[] A = new int[]{4,5,0,0,0};
        int[] B = new int[]{2,7,9};

        Solution solution = new Solution();
        solution.merge(A,2,B,3);
        System.out.println(A);
    }

    static class Solution {
        public void merge(int[] A, int m, int[] B, int n) {
            while(n>0)
                // m==0||B[n-1]>A[m-1] 解释：
                // 如果是n先等于0，m大于0那么A数组还有未比较的元素，不需要移动，所以直接跳出循环。
                // 如果是m先等于0，n大于0，B数组还有未比较队列的元素，不需要比较，直接移动到A队列。
                A[m+n-1] = (m==0||B[n-1]>A[m-1])?B[--n]:A[--m];
        }
    }
}
