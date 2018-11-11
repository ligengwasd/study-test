package com.ydb.algorithm.leetcode;

/**
 * @Author ligeng
 * @Date 18/11/11
 * @Time 下午5:18
 */
public class Q766_ToeplitzMatrix {
    public static void main(String[] args) {
        Q766_ToeplitzMatrix matrix = new Q766_ToeplitzMatrix();
        int[][] array = new int[][]{
                new int[]{1,2,3,4},
                new int[]{5,1,2,3},
                new int[]{9,5,1,2},
        };
        System.out.println(matrix.isToeplitzMatrix(array));
    }
    public boolean isToeplitzMatrix(int[][] matrix) {
        int width = matrix[0].length, height = matrix.length;
        for (int i=0; i<height; i++) {
            int tempI=i, tempJ=0;
            while (tempI<height-1 && tempJ<width-1) {
                if (matrix[tempI][tempJ] != matrix[++tempI][++tempJ]){
                    return false;
                }
            }
        }

        for (int j=1; j<width; j++) {
            int tempI=0, tempJ=j;
            while (tempI<height-1 && tempJ<width-1) {
                if (matrix[tempI][tempJ] != matrix[++tempI][++tempJ]){
                    return false;
                }
            }
        }
        return true;

    }
}
