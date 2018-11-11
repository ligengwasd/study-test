package com.ydb.algorithm.leetcode;

/**
 * @Author ligeng
 * @Date 18/11/11
 * @Time 下午7:07
 */
public class Q74_Search2DMatrix {
    public static void main(String[] args) {
        Q74_Search2DMatrix matrix = new Q74_Search2DMatrix();
        int[][] array = new int[][]{
                new int[]{1,   3,  5,  7},
                new int[]{10, 11, 16, 20},
                new int[]{23, 30, 34, 50},
        };
        System.out.println(matrix.searchMatrix(array, 30));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int width = matrix[0].length, height = matrix.length;
        for (int i=0; i<height; i++) {
            if ( (i!=height-1 && matrix[i][0] <= target && matrix[i+1][0] > target)||
                    (i==height-1)
                    ) {
                for (int j=0; j<width; j++) {
                    if (matrix[i][j] == target){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
