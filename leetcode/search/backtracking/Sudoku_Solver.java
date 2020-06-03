package com.faa.coding.leetcode.search.backtracking;

public class Sudoku_Solver {

    int[][] r = new int[9][9];
    int[][] c = new int[9][9];
    int[][] l = new int[9][9];
    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    private boolean backtrack(char[][] board, int i, int j) {
        if(i == 9) return true;
        if(j == 9) {
            return backtrack(board, i + 1, 0);
        }
        if(board[i][j] != '.') {
            return backtrack(board, i, j + 1);
        }
        for(char ch = '1'; ch <= '9'; ch++) {
            if(!isValid(board, ch, i, j)) continue;
            board[i][j] = ch;
            //只要找到一个可行解
            if(backtrack(board, i, j + 1))
                return true;
            board[i][j] = '.';
        }
        return false;
    }

    private boolean isValid(char[][] board, char ch, int r, int c) {
        for(int i = 0; i < 9; i++) {
            if (board[r][i] == ch) return false;
            if (board[i][c] == ch) return false;
            if (board[(r / 3) * 3 + i / 3][(c / 3) * 3 + i % 3] == ch)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}};
        new Sudoku_Solver().solveSudoku(board);
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }


}
