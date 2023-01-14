package com.ydb.algorithm.essentials.dp;

public class RangeSumQuery2D {
    public static void main(String[] args) {

    }

    public RangeSumQuery2D(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        this.f = new int[m+1][n+1];
        for (int i=1; i<m+1; i++) {
            int rowSum=0;
            for (int j=1; j<n+1; j++) {
                f[i][j] =  rowSum + matrix[i-1][j-1];
            }
        }
    }

    private final int[][] f;
}
