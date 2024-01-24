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

        solveSudoku(array);

    }

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){//trial. Try 1 through 9
                        if(isValid(board, i, j, c)){
                            board[i][j] = c; //Put c for this cell

                            if(solve(board))
                                return true; //If it's the solution return true
                            else
                                board[i][j] = '.'; //Otherwise go back
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 回溯
     * 这种解法比较容易理解
     * @param board
     * @param i
     * @param j
     * @return
     */
    public boolean backtrack(char[][] board, int i, int j) {
        if (j == board[0].length) {
            // 换行
            return backtrack(board, i+1, 0);
        }
        if (i == board.length) {
            // 遍历完了，说明找到了结果，如果找不到本方法最后一行会返回false
            return true;
        }
        if(board[i][j] != '.'){
            // 原位置是预置字符，遍历下一个字符
            return backtrack(board, i, j+1);
        }
        for(char c = '1'; c <= '9'; c++){
            if (!isValid(board, i, j, c)) {
                continue;
            }
            board[i][j] = c;
            boolean backtrack = backtrack(board, i, j + 1);
            if (backtrack) {
                return true;
            }
            board[i][j] = '.';
        }
        return false;
    }



    private boolean isValid(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i++) {
            if(board[i][col] != '.' && board[i][col] == c) return false; //check row
            if(board[row][i] != '.' && board[row][i] == c) return false; //check column
            if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' &&
                    board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
        }
        return true;
    }


}
