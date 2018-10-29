package com.ydb.algorithm.leetcode;

import com.ydb.sort.Util;

import java.util.Arrays;

/**
 * @Author ligeng
 * @Date 18/10/29
 * @Time 上午9:23
 */
public class Q832_FlippingAnImage {
    public static void main(String[] args) {
        Q832_FlippingAnImage image = new Q832_FlippingAnImage();

        int[][] invertImage = image.flipAndInvertImage(new int[][]{
//                new int[]{1}
                new int[]{1,1,0},
                new int[]{1,0,1},
                new int[]{0,0,0}
        });
        System.out.println(1);
    }
//    [[1,1,0],[1,0,1],[0,0,0]]

    public int[][] flipAndInvertImage(int[][] A) {
        for (int height=0; height < A.length; height++) {
            int left=0, right=A[height].length-1;
            while (left <= right) {
                if (left == right) {
                    if (A[height][left] == 0) A[height][left] = 1;
                    else A[height][left] = 0;
                    break;
                }
                this.swap(A[height], left, right);
                this.reverse(A, height, left, right);
                left++;
                right--;
            }
        }
        return A;
    }

    public void reverse(int A[][], int height, int left, int right) {
        if (A[height][left] == 0) A[height][left] = 1;
        else A[height][left] = 0;
        if (A[height][right] == 0) A[height][right] = 1;
        else A[height][right] = 0;
    }

    public void swap(int s[], int i, int j){
        int temp;
        temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
