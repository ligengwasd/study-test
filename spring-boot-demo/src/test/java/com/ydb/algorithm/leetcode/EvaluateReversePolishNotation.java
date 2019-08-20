package com.ydb.algorithm.leetcode;

import java.util.Stack;

/**
 * @Author ligeng
 * @Date 19/8/20
 * @Time 下午4:10
 */
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        EvaluateReversePolishNotation solution = new EvaluateReversePolishNotation();
        System.out.println(solution.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s:tokens) {
            switch (s) {
                case "*":
                    stack.push(stack.pop()*stack.pop());
                    break;
                case "/":
                    Integer i1 = stack.pop();
                    Integer i2 = stack.pop();
                    stack.push(i2 / i1);
                    break;
                case "+":
                    stack.push(stack.pop()+stack.pop());
                    break;
                case "-":
                    Integer i3 = stack.pop();
                    Integer i4 = stack.pop();
                    stack.push(i4-i3);
                    break;
                default:
                    stack.push(Integer.valueOf(s));
                    break;
            }
        }
        return stack.pop();
    }


}
