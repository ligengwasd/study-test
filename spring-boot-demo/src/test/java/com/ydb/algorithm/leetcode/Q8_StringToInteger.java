package com.ydb.algorithm.leetcode;

import org.junit.Test;

/**
 * @Author ligeng
 * @Date 19/1/11
 * @Time 下午8:38
 */
public class Q8_StringToInteger {
    @Test
    public void test() {
        System.out.println(this.myAtoi("  -1"));
    }

    public int myAtoi(String str) {
        return Integer.valueOf(str.replaceAll("",""));
    }
}
