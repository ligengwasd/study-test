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
                new int[]{3,4,5,2},
                new int[]{1,3,1,5},
        };
        setZeroes(array);
        System.out.println(1);
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
