package com.ydb.algorithm.leetcode;

/**
 * @Author ligeng
 * @Date 18/11/11
 * @Time 下午5:00
 */
public class Q867_TransposeMatrix {
    public static void main(String[] args) {
        Q867_TransposeMatrix matrix = new Q867_TransposeMatrix();
        int[][] array = new int[][]{
                new int[]{1,1,0},
                new int[]{1,0,1},
                new int[]{0,0,0},
                new int[]{3,2,0},
        };
        int[][] transpose = matrix.transpose(array);
        System.out.println(1);
    }

    public int[][] transpose(int[][] A) {
        int width = A[0].length, height = A.length;
        int[][] data = new int[width][height];
        for (int i=0; i<width; i++) {
            for (int j=0; j<height; j++) {
                data[i][j] = A[j][i];
            }
        }
        return data;
    }
}
