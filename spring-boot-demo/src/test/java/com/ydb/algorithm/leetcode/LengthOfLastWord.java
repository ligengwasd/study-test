package com.ydb.algorithm.leetcode;

/**
 * Created by ligeng on 18/1/11.
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLastWord("Hello World"));
    }
    static class Solution {
        public int lengthOfLastWord(String s) {
            if(s==null || s.length()==0)
                return 0;
            int idx = s.length()-1;
            // 从后往前获取第一个不为空的字符的index
            while(idx>=0 && s.charAt(idx)==' ') idx--;
            // 从后往前获取第一个为空的字符的index（不包含末尾空字符）
            int idx2 = idx;
            while(idx2>=0 && s.charAt(idx2) !=' ') idx2--;

            return idx - idx2;
        }
    }
}
