package com.ydb.algorithm.leetcode;

import com.ydb.util.JsonUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author ligeng
 * @Date 19/1/16
 * @Time 下午4:21
 */
public class Q36_ValidSudoku {
    @Test
    public void test() {
        String s = "[\n" +
                "  [\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],\n" +
                "  [\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],\n" +
                "  [\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],\n" +
                "  [\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],\n" +
                "  [\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],\n" +
                "  [\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],\n" +
                "  [\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],\n" +
                "  [\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],\n" +
                "  [\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]\n" +
                "]";

        String[] strArray = s.replace("[", "").replace("]", "").replace("\n", "").replace("\"", "").split(",");

        char[][] array = new char[9][9];
        for (int i=1; i<strArray.length+1; i++) {
            int height = (i-1)/9;
            int width = ((i)%9==0 ? 9 : (i)%9) -1;
            array[height][width] = strArray[i-1].replace(" ","").charAt(0);
        }


        boolean b = isValidSudoku(array);
        System.out.println(b);

    }
    public boolean isValidSudoku(char[][] board) {
        Set seen = new HashSet();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                if (board[i][j] != '.') {
                    String b = "(" + board[i][j] + ")";
                    if (!seen.add(b + i) || !seen.add(j + b) || !seen.add(i/3 + b + j/3))
                        return false;
                }
            }
        }
        return true;
    }
}
