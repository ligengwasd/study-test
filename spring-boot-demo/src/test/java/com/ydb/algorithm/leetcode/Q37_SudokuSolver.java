package com.ydb.algorithm.leetcode;

import org.junit.Test;

/**
 * @Author ligeng
 * @Date 19/1/18
 * @Time 下午10:22
 */
public class Q37_SudokuSolver {
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

        int  k=9;
        char[][] array = new char[9][9];
        for (int i=1; i<strArray.length+1; i++) {
            int height = (i-1)/9;
            int width = ((i)%9==0 ? 9 : (i)%9) -1;
            array[height][width] = strArray[i-1].replace(" ","").charAt(0);
        }

        System.out.println(containInBlock(array, 3,1,1));
        System.out.println(containInCol(array, 3,1));
        System.out.println(containInRow(array, 3,0));
        System.out.println(1);

    }

    public void solveSudoku(char[][] board) {
        for (int height=0; height<board.length; height++) {
            for (int width=0; width<board[0].length; width++) {
                if (".".equals(board[height][width]+"")) {



                }
            }
        }
    }

    boolean findFirstEmptyPos(char[][] board, int pos[])
    {
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                if (".".equals(board[i][j]+"")) {
                    pos[0] = i;
                    pos[1] = j;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containInBlock(char[][] board, int element, int row, int col) {
        int i = row / 3;
        int j = col / 3;

        for (int height=i*3; height<i*3+3; height++) {
            for (int width=j*3; width<j*3+3; width++) {
                if (board[height][width] == (char)(element+48)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containInCol(char[][] board, int element, int col) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == (char)(element+48)) return true;
        }
        return false;
    }

    public boolean containInRow(char[][]  board, int element, int row)
    {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == (char)(element+48)) return true;
        }
        return false;
    }


}
