package com.ydb.algorithm.leetcode;

import java.util.Arrays;

/**
 * @Author ligeng
 * @Date 18/9/15
 * @Time 下午5:02
 */
public class Q41_FirstMissingPositive {
    public static void main(String[] args) {
        Q41_FirstMissingPositive solution = new Q41_FirstMissingPositive();
        int i = solution.firstMissingPositive(new int[]{-1, 1, 2, 0});
        System.out.println(i);
    }

    public int firstMissingPositive(int[] nums) {
        bucket_sort(nums);
        for (int i = 0; i < nums.length; ++i)
            if (nums[i] != (i + 1))
                return i + 1;
        return nums.length + 1;
    }
    private static void bucket_sort(int[] A) {
        final int n = A.length;
        for (int i = 0; i < n; i++) {
            while (A[i] != i + 1) {
                if (A[i] < 1 || A[i] > n || A[i] == A[A[i] - 1])
                    break;
                // swap
                int tmp = A[i];
                A[i] = A[tmp - 1];
                A[tmp - 1] = tmp;
            }
        }
    }

    public static int firstMissingPositive2(int[] nums) {
        if (nums.length == 0) return 1;
        Arrays.sort(nums);
        if (nums[0] > 1) return 1;

        for (int i=1; i<nums.length; i++) {
            if (nums[i] > 0)  {
                if (nums[i-1] < 0) {
                    if (nums[i] > 1) return 1;
                } else {
                    if (nums[i] - nums[i-1] > 1) {
                        return nums[i-1]+1;
                    }
                }
            }
        }
        return nums[nums.length-1] + 1;
    }
}
