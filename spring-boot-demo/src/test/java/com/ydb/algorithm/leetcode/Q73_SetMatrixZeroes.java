package com.ydb.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ligeng
 * @Date 18/9/17
 * @Time 下午11:36
 */
public class Q73_SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] array = new int[][]{
                new int[]{0,1,2,0},
                new int[]{3,0,5,2},
                new int[]{1,3,1,5},
        };
        setZeroes2(array);
        System.out.println(1);
    }

    public static void setZeroes2(int[][] matrix) {
        int col0 = 1;
        int height = matrix.length;
        int width = matrix[0].length;
        for (int i=0; i<height; i++) {
            if (matrix[i][0] == 0) col0 = 0;
            for (int j=0; j<width; j++) {
                if (matrix[i][j] == 0) matrix[0][j] = matrix[i][0] = 0;
            }
        }


        for (int i = height - 1; i >= 0; i--) {
            for (int j = width - 1; j >= 1; j--)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            if (col0 == 0) matrix[i][0] = 0;
        }


    }

    public static void setZeroes(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;
        Set<Integer> xSet = new HashSet<>();
        Set<Integer> ySet = new HashSet<>();
        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                if (matrix[i][j] == 0) {
                    xSet.add(i);
                    ySet.add(j);
                }
            }
        }

        for (Integer x:xSet) {
            int tempY=0;
            while (tempY < width) {
                matrix[x][tempY++] = 0;
            }
        }

        for (Integer y:ySet) {
            int tempX=0;
            while (tempX < height) {
                matrix[tempX++][y] = 0;
            }
        }


    }
}
