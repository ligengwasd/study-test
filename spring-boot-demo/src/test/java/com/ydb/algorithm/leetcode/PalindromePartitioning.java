package com.ydb.algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 该答案不完整。
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        return null;
    }

    /**
     * @param path
     * @param start start前面的都是回文
     * @param end 是否在end的地方断开
     */
    public void dfs(LinkedList<String> path, String s, int start) {
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                path.add(s.substring(start, i));
                dfs(path, s, i+1);
                path.removeLast();
            }
        }
    }


    private boolean isPalindrome(String s, int left, int right) {
        while (right - left > 1) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }
}
