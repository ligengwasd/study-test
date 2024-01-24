package com.ydb.algorithm.leetcode;

import com.google.gson.Gson;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
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
        backtrack(0 ,0, new LinkedList<>(), n);
        return res;
    }

    void backtrack(int left, int right, LinkedList<String> path, int n) {
        if (right == n) {
            System.out.println(new Gson().toJson(path));
            return;
        }

        if (left < n) {
            path.add("(");
            backtrack(left+ 1, right, path, n);
            path.removeLast();
        }

        if (left > right) {
            path.add(")");
            backtrack(left, right+ 1, path, n);
            path.removeLast();
        }

    }


}
