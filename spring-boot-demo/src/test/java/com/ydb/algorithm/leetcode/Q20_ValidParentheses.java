package com.ydb.algorithm.leetcode;

import java.util.Stack;

/**
 * @Author ligeng
 * @Date 18/9/1
 * @Time 上午10:09
 */
public class Q20_ValidParentheses {
    public static void main(String[] args) {
        System.out.println(solution("{[]}"));
    }

    public static boolean solution(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
