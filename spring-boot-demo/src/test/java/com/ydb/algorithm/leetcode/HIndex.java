package com.ydb.algorithm.leetcode;

/**
 * @Author ligeng
 * @Date 19/8/21
 * @Time 下午2:06
 */
public class HIndex {
    public static void main(String[] args) {
        HIndex solution = new HIndex();
        System.out.println(solution.hIndex(new int[]{3,0,6,1,5}));
    }

    public int hIndex(int[] citations) {
        final int n = citations.length + 1;
        final int[] histogram = new int[n+1];

        for (int x : citations) {
            ++histogram[x > n ? n : x];
        }

        int sum = 0; // current number of papers
        for (int i = n; i > 0; --i) {
            sum += histogram[i];
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }
}
