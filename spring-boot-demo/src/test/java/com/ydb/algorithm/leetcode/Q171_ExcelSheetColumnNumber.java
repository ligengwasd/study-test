package com.ydb.algorithm.leetcode;

import java.util.Map;

/**
 * @Author ligeng
 * @Date 18/9/3
 * @Time 上午1:41
 */
public class Q171_ExcelSheetColumnNumber {
    public static void main(String[] args) {
        System.out.println(titleToNumber("A"));
    }
    public static int titleToNumber(String s) {
        int res=0;
        char[] array = s.toCharArray();
        for (int i=0; i<array.length; i++) {
            res += (array[i]-64) * Math.pow(26, array.length-1-i);
        }
        return res;
    }


}
