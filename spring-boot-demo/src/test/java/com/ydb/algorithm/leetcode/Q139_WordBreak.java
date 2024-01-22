package com.ydb.algorithm.leetcode;

import java.util.Arrays;
import java.util.List;

public class Q139_WordBreak {
    public static void main(String[] args) {
        Q139_WordBreak q = new Q139_WordBreak();
        q.memo = new int[4];
        Arrays.fill(q.memo, -1);
        q.wordBreak("abcd", Arrays.asList("a","abc","b","cd"));
        System.out.println(q.res);
    }

    boolean res = false;
    int[] memo;// 元素i，标识i左边的元素都可以用wordDict拼接起来
    // -------------------------------------动态规划--------------------------------------------
    void dp(String s, List<String> wordDict, int start) {

        for (String word : wordDict) {
            boolean startsWith = s.startsWith(word, start);
            if (startsWith) {
                memo[start] = 1;
            }
        }
        if (memo[start] == -1) memo[start] = 0;

    }
    // -------------------------------------回溯算法--------------------------------------------
    boolean wordBreak(String s, List<String> wordDict) {
        wordBreakInner(s, wordDict, 0);
        return res;
    }

    void wordBreakInner(String s, List<String> wordDict, int start) {
        if (res) {
            return;
        }
        if (start == s.length()) {
            res = true;
            return;
        }
        for (String word : wordDict) {
            if (start + word.length() > s.length()) {
                continue;
            }
            if (s.substring(start, start + word.length()).equals(word)) {
                wordBreakInner(s, wordDict, start + word.length());
            }
        }
    }
}
