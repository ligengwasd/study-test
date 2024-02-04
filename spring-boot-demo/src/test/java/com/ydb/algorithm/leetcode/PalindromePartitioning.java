package com.ydb.algorithm.leetcode;

import com.google.gson.Gson;

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
        if (start == s.length()) {
            System.out.println(new Gson().toJson(path));
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                path.add(s.substring(start, i+1));
                dfs(path, s, i+1);
                path.removeLast();
            }
        }
    }
    /**
     * 左闭右闭区间
     * @param s
     * @param left
     * @param right
     * @return
     */
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
