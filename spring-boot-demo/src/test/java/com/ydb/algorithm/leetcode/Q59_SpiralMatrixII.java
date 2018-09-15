package com.ydb.algorithm.leetcode;

/**
 * @Author ligeng
 * @Date 18/9/15
 * @Time 下午8:09
 */
public class Q59_SpiralMatrixII {
    public static void main(String[] args) {
        int[][] ints = generateMatrix(3);
        System.out.println(1);
    }
    public static int[][] generateMatrix(int n) {
        int[][] rs = new int[n][n];
        int left = 0, right = n-1, top = 0, bottom = n-1;
        int num = 1;
        while (left <= right && top <= bottom) {
            for (int i=left; i<=right; i++) {
                rs[top][i] = num++;
            }
            top++;
            for (int i=top; i<=bottom; i++) {
                rs[i][right] = num++;
            }
            right--;
            for (int i=right; i>=left; i--) {
                rs[bottom][i] = num++;
            }
            bottom--;
            for (int i=bottom; i>=top; i--) {
                rs[i][left] = num++;
            }
            left++;
        }

        return rs;
    }
}
