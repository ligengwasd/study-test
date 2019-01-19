package com.ydb.algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author ligeng
 * @Date 19/1/19
 * @Time 下午10:47
 */
public class Q66_PlusOne {
    @Test
    public void test() {
        int[] ints = plusOne(new int[]{8, 9});
        System.out.println(1);
    }

    public int[] plusOne(int[] digits) {
        return plus(digits,1);
    }

    public int[] plus(int[] digits, int digit) {
        int carry = digit;
        for (int i=digits.length-1; i>=0; i--) {
            digits[i] += carry;
            carry = digits[i]/10;
            digits[i] %= 10;
        }

        if (carry>0) {
            int[] res = new int[digits.length + 1];
            System.arraycopy(digits, 0, res, 1, digits.length);
            res[0] = carry;
            return res;
        }

        return digits;
    }
}
