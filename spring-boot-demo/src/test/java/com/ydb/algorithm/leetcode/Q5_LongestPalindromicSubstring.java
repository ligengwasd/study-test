package com.ydb.algorithm.leetcode;

import org.junit.Test;

/**
 * @Author ligeng
 * @Date 19/1/11
 * @Time 下午4:56
 */
public class Q5_LongestPalindromicSubstring {
    @Test
    public void test() {
        System.out.println(longestPalindrome("abb"));
    }

    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        for (int i = 0; i < s.length()-1; i++) {
            extendPalindrome(s, i,i);
            extendPalindrome(s, i,i+1);
        }
        return s.substring(lo, lo+maxLen);
    }

    public void extendPalindrome(String s, int left, int right) {
        while (left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // right和left分别多在执行了一次递增和递减，要减去2
        if (maxLen < right-left-2+1) {
            lo = left+1;
            maxLen = right-left-2+1;
        }
    }
    private int lo, maxLen;
}
