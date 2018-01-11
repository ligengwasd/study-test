package com.ydb.algorithm.leetcode;

/**
 * Created by ligeng on 18/1/11.
 */
public class CountAndSay {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countAndSay(1));
        System.out.println(solution.countAndSay(2));
        System.out.println(solution.countAndSay(3));
        System.out.println(solution.countAndSay(4));
        System.out.println(solution.countAndSay(5));
        System.out.println(solution.countAndSay(6));

    }
    static class Solution {
        public String countAndSay(int n) {
            if (n==1) return "1";
            String str = countAndSay(n-1) + "*";
            char[] c = str.toCharArray();
            int count = 1;
            StringBuffer res = new StringBuffer();
            char temp=c[0];
            for (int i=0; i<c.length-1; i++) {
                if (c[i] == c[i+1]) {
                    count++;
                } else {
                    res.append(count+""+temp);
                    temp = c[i+1];
                    count = 1;
                }
            }
            return res.toString();
        }
    }

}
