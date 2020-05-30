package com.faa.leetcode.search.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Shortest_Path_in_Matrix {

    public static int shortestPathBinaryMatrix(int[][] grid) {

        //当前节点搜索方向
        int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        int dy[] = {-1, 0, 1, -1, 1, -1, 0, 1};
    int n = grid.length;
        if(grid[0][0] == 1 || grid[n -1][n - 1] == 1) {
            return -1;
        }
        if(n == 1) return 1;
        Queue<Integer> queue = new LinkedList<>();
        int[][] d = new int[n][n];
        //x*n+y     x=i/n, y=i%n
        queue.offer(0);
        d[0][0] = 1;
        while(!queue.isEmpty()) {
            int t = queue.poll();//当前节点
            int nx = t / n; int ny = t % n;
            for(int i = 0; i < 8; i++) {//依次查看8个方向
                int x = nx + dx[i];
                int y = ny + dy[i];
                if(x < 0 || y < 0 || x >= n || y >= n || d[x][y] > 0 || grid[x][y] == 1) continue;
                d[x][y] = d[nx][ny] + 1;
                if(x == n - 1 && y == n - 1) return d[x][y];
                queue.offer(x * n + y);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }
}
