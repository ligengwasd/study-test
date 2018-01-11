package com.ydb.algorithm.leetcode;

/**
 * Created by ligeng on 18/1/11.
 */
public class PlusOne {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] s = solution.plusOne(new int[]{9,9,9});
        System.out.println(s);
    }

    static class Solution {
        public int[] plusOne(int[] digits) {
            int n = digits.length;
            for (int i = digits.length - 1; i >= 0; --i) {
                if (digits[i] < 9) {
                    ++digits[i];
                    return digits;
                }
                digits[i] = 0;
            }
            int[] res = new int[n + 1];
            res[0] = 1;
            return res;
        }
    }
}
