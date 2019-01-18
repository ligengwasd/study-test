package com.ydb.algorithm.leetcode;

import com.ydb.sort.Util;
import org.junit.Test;

/**
 * @Author ligeng
 * @Date 19/1/18
 * @Time 下午9:07
 */
public class Q48_RotateImage {
    @Test
    public void test() {
        String s = "[\n" +
                "  [1,2,3],\n" +
                "  [4,5,6],\n" +
                "  [7,8,9]\n" +
                "]";

        String[] strArray = s.replace("[", "").replace("]", "").replace("\n", "").replace("\"", "").split(",");

        int  k=3;
        int[][] array = new int[k][k];
        for (int i=1; i<strArray.length+1; i++) {
            int height = (i-1)/k;
            int width = ((i)%k==0 ? k : (i)%k) -1;
            array[height][width] = Integer.valueOf(strArray[i-1].replace(" ",""));
        }


        rotate(array);
        System.out.println();
    }

    public void rotate(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;
        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                if (j < i) {
                    swap(matrix, i,j);
                }
            }
        }

        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                if (j <= (width/2-1)) {
                    swap2(matrix, width, i,j);
                }
            }
        }

    }

    public void swap2(int s[][],int width, int i, int j){
        int temp = s[i][j];
        s[i][j] = s[i][width-j-1];
        s[i][width-j-1] = temp;
    }

    public void swap(int s[][], int i, int j){
        int temp;
        temp = s[i][j];
        s[i][j] = s[j][i];
        s[j][i] = temp;
    }


}
