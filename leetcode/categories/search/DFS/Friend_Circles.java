package com.faa.leetcode.search.DFS;

import java.util.Stack;

public class Friend_Circles {

    public static int findCircleNum(int[][] M) {
        int circles = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < M.length * M.length; i++) {
            int r = i / M.length;
            int c = i % M.length;
            if(M[r][c] == 1) {
                stack.push(c);
                circles++;
                while (!stack.isEmpty()) {
                    int cur = stack.pop();
                    for (int j = 0; j < M.length; j++) {
                        if (M[cur][j] == 1) {
                            System.out.println(cur + " " + j);
                            stack.push(j);
                            M[cur][j] = 0;
                        }
                    }
                }
            }
        }

        return circles;
    }



    public static int findCircleNum1(int[][] M) {
        int circles = 0;
        for(int i = 0; i < M.length; i++) {
            for(int j = 0; j < M.length; j++) {
                if(M[i][j] == 1) {
                    dfs(M, j);
                    circles++;
                }
            }
        }
        return circles;
    }

    private static void dfs(int[][] M, int j) {
        for(int i = 0; i < M.length; i++) {
            if(M[j][i] == 1) {
                M[j][i] = 0;
                dfs(M, i);
            }
        }
    }

    public static void main(String[] args) {
        int[][] M = {{1,1,0},
                     {1,1,0},
                     {0,0,1}};
        int[][] M1 = {{1,0,0,1},
                      {0,1,1,0},
                      {0,1,1,1},
                      {1,0,1,1}};
        System.out.println(findCircleNum1(M));
    }

}
