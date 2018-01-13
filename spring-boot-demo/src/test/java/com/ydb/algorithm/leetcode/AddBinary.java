package com.ydb.algorithm.leetcode;

/**
 * Created by ligeng on 18/1/13.
 */
public class AddBinary {
    // TODO: 18/1/13  看不懂的题目
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("1111", "01"));
    }
    static class Solution {
        public String addBinary1(String a, String b) {
            if (a.length() < b.length()) {
                String temp = a;
                a = b;
                b = temp;
            }
            // a比b长
            return null;

        }
        public String addBinary(String a, String b) {
            int aLength = a.length();
            int bLength = b.length();
            StringBuilder sb = new StringBuilder();
            int carry = 0;
            while(Math.max(aLength, bLength) > 0) {
                int aNum = aLength > 0 ? (a.charAt(aLength-- -1) - '0') : 0;
                int bNum = bLength > 0 ? (b.charAt(bLength-- -1) - '0') : 0;
                int cNum = aNum + bNum + carry;
                sb.append(cNum%2);
                carry = cNum / 2;
            }
            return (carry == 1)?sb.append(1).reverse().toString():sb.reverse().toString();
        }
    }
}
