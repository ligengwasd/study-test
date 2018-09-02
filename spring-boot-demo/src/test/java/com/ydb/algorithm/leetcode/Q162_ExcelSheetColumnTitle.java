package com.ydb.algorithm.leetcode;

/**
 * @Author ligeng
 * @Date 18/9/3
 * @Time 上午1:08
 */
public class Q162_ExcelSheetColumnTitle {
    public static void main(String[] args) {
//        System.out.println((char) 65);
//        System.out.println((char) 90);
        System.out.println(convertToTitle(26));
//        System.out.println(1/2);
    }
    public static String convertToTitle(int n) {
        StringBuffer sb = new StringBuffer();
        while (n>0) {
            n--;
            sb.insert(0, (char)('A'+n%26));
            n = n/26;
        }
        return sb.toString();
    }


}
