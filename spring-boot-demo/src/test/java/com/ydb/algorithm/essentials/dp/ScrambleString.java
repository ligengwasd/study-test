package com.ydb.algorithm.essentials.dp;

public class ScrambleString {


    /**
     * s1 和 s2 是 scramble 的话，那么必然存在一个在 s1 上的长度 l1，将 s1 分成 s11 和 s12 两段，
     * 同样有 s21 和 s22，那么要么 s11 和 s21 是 scramble 的并且 s12 和 s22 是 scramble 的；
     * 要么 s11 和 s22 是 scramble 的并且 s12 和 s21 是 scramble 的。
     * 就拿题目中的例子 rgeat 和 great 来说，rgeat 可分成 rg 和 eat 两段，
     * great 可分成 gr 和 eat 两段，rg 和 gr 是 scrambled 的， eat 和 eat 当然是 scrambled。
     * @param s1
     * @param s2
     * @return
     */
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        // 递归走到底
        if (s1.length() == 1 && s2.length() == 1) {
            if (s1.equals(s2)) {
                return true;
            } else {
                return false;
            }
        }

        for (int i=1; i<s1.length(); i++) {
            String b1 = s1.substring(0, i);
            String b2 = s1.substring(i);
            String c1 = s2.substring(0, i);
            String c2 = s2.substring(i);
            if (isScramble(b1, c1) && isScramble(b2, c2)) {
                return true;
            }
            c1 = s2.substring(0, s2.length()-i);
            c2 = s2.substring(s2.length()-i);
            if (isScramble(b1, c1) && isScramble(b2, c2)) {
                return true;
            }
        }
        return false;
    }
}
