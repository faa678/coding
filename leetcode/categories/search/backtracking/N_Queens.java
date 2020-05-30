package com.faa.leetcode.search.backtracking;

import javafx.beans.binding.StringBinding;

import java.util.ArrayList;
import java.util.List;

public class N_Queens {

    List<List<String>> list = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        List<String> board = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append('.');
        }
        for(int i = 0; i < n; i++) {
            board.add(new String(sb));
        }

        backtrack(n, 0, board);
        return list;
    }

    private void backtrack(int n, int i, List<String> board) {
        if(i == n) {
            list.add(new ArrayList<String>(board));
            return;
        }
        for(int j = 0; j < n; j++) {
            if(!isValid(n, board, i, j)) continue;
            StringBuilder tmp = new StringBuilder(board.get(i));
            tmp.setCharAt(j, 'Q');
            board.set(i, tmp.toString());
            backtrack(n, i + 1, board);
            tmp.setCharAt(j, '.');
            board.set(i, tmp.toString());
        }

    }

    private boolean isValid(int n, List<String> board, int r, int c) {
        //检查列是否有冲突
        for(int i = 0; i < r; i++) {
            if(board.get(i).charAt(c) == 'Q')
                return false;//只用检查列是否有冲突
        }
        //检查右上方是否有冲突
        for(int i = r - 1, j = c + 1; i >= 0 && j < n; i--, j++) {
            if(board.get(i).charAt(j) == 'Q')
                return false;
        }
        //检查左上方是否有冲突
        for(int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
            if(board.get(i).charAt(j) == 'Q')
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new N_Queens().solveNQueens(4));
    }

}
