package com.faa.coding.leetcode.search.DFS;

import java.util.Stack;

public class Max_Area_of_Island {

    public static int maxAreaOfIsland(int[][] grid) {

        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};

        Stack<Integer> stack = new Stack<>();

        int h = grid.length;
        int w = grid[0].length;

        int maxArea = 0;
        int curArea;

        for(int i = 0; i < w * h; i++) {
            int cur_x = i / w;
            int cur_y = i % w;
            if(grid[cur_x][cur_y] == 1) {
//                System.out.println(cur_x + " " + cur_y);
                curArea = 1;

                stack.push(i);
                grid[cur_x][cur_y] = 0;
                while(!stack.isEmpty()) {
                    maxArea = Math.max(maxArea, curArea);
                    int cur = stack.peek();
                    cur_x = cur / w;
                    cur_y = cur % w;
                    for(int j = 0; j < 4; j++) {
                        int x = cur_x + dx[j];
                        int y = cur_y + dy[j];
                        if(x >= h || y >= w || x < 0 || y < 0 || grid[x][y] == 0) {
                            if(j == 3) stack.pop();
                            continue;
                        }
                        else if(grid[x][y] == 1){

                            stack.push(x * w + y);
                            System.out.println(x + " " + y);
                            grid[x][y] = 0;
                            curArea++;
//                            System.out.println(curArea);

                            break;
                        }
                    }
                }
            }
        }

        return maxArea;
    }


    public static void main(String[] args) {
        //               0 1 2 3 4 5 6 7 8 9 j q k
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,1,1,0,1,0,0,0,0,0,0,0,0},
                        {0,1,0,0,1,1,0,0,1,0,1,0,0},
                        {0,1,0,0,1,1,0,0,1,1,1,0,0},
                        {0,0,0,0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println("max: " + maxAreaOfIsland(grid));
    }

}
