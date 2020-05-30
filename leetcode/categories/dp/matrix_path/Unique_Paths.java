package com.faa.leetcode.dp.matrix_path;

public class Unique_Paths {

    public int uniquePaths(int m, int n) {

        //转移方程：f(i, j) = f(i - 1, j) + f(i, j - 1)
        //i == 0 || j == 0 时，f(i, j) = 1
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || j == 0) dp[i][j] = 1;
                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int m = 3; int n = 2;
        System.out.println(new Unique_Paths().uniquePaths(m, n));
    }

}
