package com.ydb.algorithm.leetcode;

/**
 * @Author ligeng
 * @Date 19/1/5
 * @Time 上午11:16
 */
public class Q79_WordSearch {
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
        if(board == null || word == null || board.length == 0 || word.length() == 0)
            return false;


        for (int height = 0; height<board.length; height++) {
            for (int width = 0; width<board[0].length; width++) {
                if (dfs(board, word, height, width, 0)) return true;
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, String word, int height, int width, int pos) {
        if (pos == word.length()) return true;
        if(height >= board.length || height < 0 ||  width < 0 || width >= board[0].length) return false;
        if(board[height][width] == '#') return false;
        if(board[height][width] != word.charAt(pos)) return false;

        char tmp = board[height][width];
        board[height][width] = '#';
        boolean res = dfs(board, word, height - 1, width, pos + 1)
                || dfs(board, word, height + 1, width, pos + 1)
                || dfs(board, word, height, width - 1, pos + 1)
                || dfs(board, word, height, width + 1, pos + 1);
        board[height][width] = tmp;

        return res;
    }


}
