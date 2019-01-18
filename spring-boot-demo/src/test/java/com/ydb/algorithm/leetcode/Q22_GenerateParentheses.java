package com.ydb.algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ligeng
 * @Date 19/1/18
 * @Time 下午11:26
 */
public class Q22_GenerateParentheses {
    @Test
    public void test(){
        List<String> strings = generateParenthesis(3);
        System.out.println(1);
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesisDFS(0,0, "",res, n);
        return res;
    }
    void generateParenthesisDFS(int left, int right, String out, List<String> res, int n) {
        if (right == n) {
            res.add(out);
        }
        if (left < n) {
            generateParenthesisDFS(left+1, right, out+"(", res, n);
        }
        if (right < left) {
            generateParenthesisDFS(left, right+1, out+")", res, n);
        }

    }
}
