package com.faa.leetcode.search.DFS;

import java.util.HashMap;
import java.util.Stack;

public class Number_of_islands {

    public static int numIslands(char[][] grid) {

        if(grid == null || grid.length == 0) return 0;

        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};

        // i = 当前行 * 列数 + 当前列
        int r = grid.length;//行数
        int c = grid[0].length;//列数

        Stack<Integer> stack = new Stack<>();

        int result = 0;

        for(int i = 0; i < r * c; i++) {
            int p1 = i / c;//第 p1 行
            int p2 = i % c;//第 p2 列
            if(grid[p1][p2] == '0') continue;
            stack.push(i);
            result++;
            while(!stack.isEmpty()) {
                int cur = stack.peek();//深度优先遍历需要回溯，不能直接弹出，应该等到当前节点没有子节点之后才能弹出
                int cur_r = cur / c;
                int cur_c = cur % c;
                for(int j = 0; j < 4; j++) {
                    int next_r = cur_r + dx[j];
                    int next_c = cur_c + dy[j];
                    if(next_r < 0 || next_r >= r || next_c < 0 || next_c >= c || grid[next_r][next_c] == '0') {
                        if(j == 3) stack.pop();
                        continue;
                    }
                    grid[next_r][next_c] = '0';
                    stack.push(next_r * c + next_c);
                    break;
                }
            }
        }

        return result;
    }

    public static int numIslands2(char[][] grid) {

        int rs = grid.length;
        int cs = grid[0].length;
        int result = 0;


        for(int i = 0; i < rs; i++) {
            for(int j = 0; j < cs; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
//                    System.out.println(i + " " + j);
                    result++;
                }
            }
        }

        return result;
    }

    private static void dfs(char[][] grid, int r, int c) {
        int[][] d = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        grid[r][c] = '0';
        for(int i = 0; i < 4; i++) {
            int x = r + d[i][0];
            int y = c + d[i][1];
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0')
                continue;//循环内此处不能直接return，否则会直接跳过其他方向
            System.out.println(x + " " + y);
            dfs(grid, x, y);
        }
    }
    //好
//    private static void dfs(char[][] grid, int r, int c) {
//        int[][] d = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
//        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0') return;
//        for(int[] next_d : d) {
//            int x = r + next_d[0];
//            int y = c + next_d[1];
//            dfs(grid, x, y);
//        }
//        grid[r][c] = '0';
//    }


    public static void main(String[] args) {

        char[][] grid = {{'1','1','1','1','0'},
                        {'1','1','0','1','0'},
                        {'1','1','0','0','0'},
                        {'0','0','0','0','0'}};
        System.out.println(numIslands2(grid));
    }

}
