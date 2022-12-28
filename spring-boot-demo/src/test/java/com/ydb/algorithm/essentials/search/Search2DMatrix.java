package com.ydb.algorithm.essentials.search;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int first = 0;
        int last = m*n;
        while (first < last) {
            int mid = first + (first + last)/2;
            int midValue = matrix[mid/n][mid%n];
            if (midValue == target) {
                return true;
            } else if (target < midValue) {
                last = mid;
            } else if (target > midValue) {
                first = mid+1;
            }
        }
        return false;
    }
}
