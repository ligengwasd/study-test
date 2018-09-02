package com.ydb.algorithm.leetcode;

/**
 * @Author ligeng
 * @Date 18/9/2
 * @Time 下午11:18
 */
public class Q123_ValidPalindrome {
    public static void main(String[] args) {

    }

    public boolean isPalindrome(String s) {
        if (s.isEmpty()) return true;
        int head=0, tail = s.length()-1;
        char cHead, cTail;
        while (head<=tail) {

            cHead = s.charAt(head);
            cTail = s.charAt(tail);
            if (!Character.isLetterOrDigit(cHead)) {
                cHead++;
                continue;
            } else if (!Character.isLetterOrDigit(cTail)) {
                tail--;
                continue;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
                cHead++;
                cTail--;
            }
        }
        return true;
    }

}
