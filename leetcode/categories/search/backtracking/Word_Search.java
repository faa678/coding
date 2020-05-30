package com.faa.leetcode.search.backtracking;

import java.util.Stack;

/**
 * @author ：faa
 * @description：TODO
 * @date ：2020/4/28 19:38
 */

public class Word_Search {


    int[] dx = {-1, 0, 0, 1};
    int[] dy = {0, -1, 1, 0};

    private char[][] board;
    private String word;

    private int r;
    private int c;

    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        r = board.length;

        if(r == 0) return false;
        if(word.length() == 0) return true;
        c = board[0].length;

        this.board = board;
        this.word = word;

        visited = new boolean[r][c];


        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(board[i][j] == word.charAt(0))
                    if(dfs(i, j, 0))
                        return true;
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int start) {
        if(start == word.length() - 1) {
            return board[i][j] == word.charAt(start);
        }
        System.out.println(start);
        if(board[i][j] == word.charAt(start)) {
            visited[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int x = i + dx[k];
                int y = j + dy[k];
                if (x < 0 || x >= r || y < 0 || y >= c || visited[x][y]) continue;
//                if (board[x][y] == word.charAt(start)) //错位了
                if(dfs(x, y, start + 1)) return true;
            }
            visited[i][j] = false;//递归完后才执行此语句
        }
        return false;
    }

    public static void main(String[] args) {

        char[][] board1 = {
                {'C','A','A'},
                {'A','A','A'},
                {'B','C','D'}
        };
        char[][] board = {
              {'A','B','C','E'},
              {'S','F','C','S'},
              {'A','D','E','E'}
        };
        char[][] board2 = {
                {'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}
        };
        char[][] board3 = {{'a','b'},{'c','d'}};
        String word5 = "acdb";
        String word = "ABCCED";
        String word1 = "ABCB";
        String word2 = "AAB";
        String word3 = "ABCESEEEFS";
        String word4 = "SEE";
        System.out.println(new Word_Search().exist(board3, word5));
    }

}
