package com.ydb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ligeng
 * @Date 18/9/2
 * @Time 下午1:50
 */
public class Q119_PascalTriangle2 {
    public static void main(String[] args) {
        getRow(5);
    }

    /**
     * 思路：
     * 在第n行前面插入1，
     * 第n+1行的第j个元素 = 第n行的第j-1个元素 + 第n行的第j个元素
     * 第n+1行的第j个元素 = 处理前的第n+1行的第j个元素 + 处理前的第n+1行的第j+1个元素
     * @param rowIndex
     * @return
     */
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        if (rowIndex < 0)
            return list;

        for (int i = 0; i < rowIndex + 1; i++) {
            list.add(0, 1);
            for (int j = 1; j < list.size() - 1; j++) {
                list.set(j, list.get(j) + list.get(j + 1));
            }
        }
        return list;
    }
}
