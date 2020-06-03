package com.faa.coding.leetcode.search.DFS;

public class Surrounded_Regions {

    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    public static void solve(char[][] board) {
        int r = board.length;
        if(r == 0) return;
        int c = board[0].length;
        for(int i = 0; i < c; i++) {
            if(board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            if(board[r - 1][i] == 'O') {
                dfs(board, r - 1, i);
            }
        }

        for(int i = 0; i < r; i++) {
            if(board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if(board[i][c - 1] == 'O') {
                dfs(board, i, c - 1);
            }
        }
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'K') board[i][j] = 'O';
            }
        }
    }

    private static void dfs(char[][] board, int i, int j) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') return;
        if(board[i][j] == 'O') board[i][j] = 'K';
        for(int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            dfs(board, x, y);
        }
    }

    private static void printBoard(char[][] board) {
        for (char[] chars : board) {
            for (char c : chars)
                System.out.print(c);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        System.out.println("pre: ");
        printBoard(board);
        solve(board);
        System.out.println("aft: ");
        printBoard(board);

    }

}
