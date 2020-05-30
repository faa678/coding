package com.faa.leetcode.dp.package_0_1;

/**
 * @author ：faa
 * @description：TODO
 * @date ：2020/5/29 8:21
 */

public class Ones_and_Zeroes {

    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        if(len == 0) return 0;

        int[][][] dp = new int[m + 1][n + 1][len];
//      f(i, j, k) 使用 i 个 0 和 j 个 1 组成的 strs 中前 k 个字符串中最多的个数
        for(int k = 0; k < len; k++) {
            String s = strs[k];
            int zeroes = 0; int ones = 0;
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '0') zeroes++;
                else ones++;
            }

            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(i - zeroes >= 0 && j - ones >= 0 && k >= 1)
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - zeroes][j - ones][k] + 1);
                }
            }
        }
        return dp[m - 1][n - 1][len - 1];

    }

    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        System.out.println(new Ones_and_Zeroes().findMaxForm(strs, 5, 3));
    }

}
