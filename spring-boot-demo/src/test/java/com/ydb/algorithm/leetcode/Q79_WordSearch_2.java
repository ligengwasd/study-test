package com.ydb.algorithm.leetcode;

/**
 * @Author ligeng
 * @Date 19/1/7
 * @Time 上午9:44
 */
public class Q79_WordSearch_2 {
    public static void main(String[] args) {
        System.out.println(exist(new char[][]{
                new char[]{'A','B','C','E'},
                new char[]{'S','F','C','S'},
                new char[]{'A','D','E','E'}
//                new char[]{'a','b'},
//                new char[]{'c','d'}
        }, "ABCB"));
    }

    public static boolean exist(char[][] board, String word) {
        if (board == null || word == null || board.length == 0) return false;
        int rowNum = board.length, colNum = board[0].length;
        boolean[][] visited = new boolean[rowNum][colNum];
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if (dfs(board, visited, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, boolean[][] visited, String word, int i, int j, int pos) {
        if (pos == word.length()) return true;
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1) return false;

        if (visited[i][j] || board[i][j] != word.charAt(pos)) return false;

        visited[i][j] = true;

        if (dfs(board, visited, word, i - 1, j, pos + 1)
                || dfs(board, visited, word, i + 1, j, pos + 1)
                || dfs(board, visited, word, i, j - 1, pos + 1)
                || dfs(board, visited, word, i, j + 1, pos + 1)) return true;

        visited[i][j] = false;
        return false;
    }
}
