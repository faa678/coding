package com.faa.leetcode.search.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


public class Pacific_Atlantic_Water_Flow {
    static Stack<int[]> stack = new Stack<>();
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    public static List<List<Integer>> pacificAtlantic(int[][] matrix) {

        List<List<Integer>> list = new ArrayList<>();
        int m = matrix.length;
        if(m == 0) return list;
        int n = matrix[0].length;


        boolean[][] A = new boolean[m][n];
        boolean[][] B = new boolean[m][n];


        //从水中往山中回溯
        //太平洋
        for(int i = 0; i < n; i++) {
            dfs(matrix, 0, i, A);
            dfs(matrix, m - 1, i, B);
        }

        for(int i = 0; i < m; i++) {
            dfs(matrix, i, 0, A);
            dfs(matrix, i, n - 1, B);
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(A[i][j] && B[i][j]) list.add(Arrays.asList(i, j));
            }
        }
        return list;
    }

    private static void dfs(int[][] matrix, int i, int j, boolean[][] reachable) {
        stack.push(new int[]{i, j});
        while(!stack.isEmpty()) {
            int[] cur = stack.pop();
            if(reachable[cur[0]][cur[1]]) continue;
            reachable[cur[0]][cur[1]] = true;
            for (int k = 0; k < 4; k++) {
                int x = cur[0] + dx[k];
                int y = cur[1] + dy[k];
                if(x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length || matrix[x][y] < matrix[cur[0]][cur[1]]) continue;
                stack.push(new int[]{x, y});
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,2,3,5},
                          {3,2,3,4,4},
                          {2,4,5,3,1},
                          {6,7,1,4,5},
                          {5,1,1,2,4}};
        List<List<Integer>> list = pacificAtlantic(matrix);
        for(List ps : list) {
            for(Object p : ps) {
                System.out.print((int)(p));
            }
            System.out.println();
        }
    }

}
