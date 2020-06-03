package com.faa.coding.leetcode.dp.package_0_1;

/**
 * @author ：faa
 * @description：TODO
 * @date ：2020/5/29 8:21
 */

public class Ones_and_Zeroes {

    public int findMaxForm(String[] strs, int m, int n) {

        int len = strs.length;
        if(len == 0) return 0;

        // f(k, i, j): 使用 i 个 0 和 j 个 1 能够拼出前 k 个字符串中的最多的个数

        int[][][] dp = new int[len + 1][m + 1][n + 1];

        // 当前字符串 0 个数：zeroes, 1 个数：ones
        // 当前字符串有两种情况：选择 or 不选择
        // 选择：dp[k][i][j] = dp[k - 1][i - zeroes][j - ones] + 1
        // 不选择：dp[k][i][j] = dp[k - 1][i][j]

        for(int k = 1; k <= len; k++) {
            String s = strs[k - 1];
            int zeroes = get_0_1(s)[0]; int ones = get_0_1(s)[1]; // 当前字符串中的 0 和 1 的个数

            for(int i = 0; i <= m; i++) { // i 和 j 从 0 开始，因为可以使用 0 个 i 或 0 个 j
                for(int j = 0; j <= n; j++) {
                    if(i >= zeroes && j >= ones)
                        dp[k][i][j] = Math.max(dp[k - 1][i][j], dp[k - 1][i - zeroes][j - ones] + 1);
                    else
                        dp[k][i][j] = dp[k - 1][i][j];
                }
            }

        }

        return dp[len][m][n];

    }

    // 统计 0 和 1 的 个数
    private int[] get_0_1(String s) {
        int len = s.length();
        int[] tmp = new int[2];
        for(int i = 0; i < len; i++) {
            if(s.charAt(i) == '0')
                tmp[0]++;
            else
                tmp[1]++;
        }
        return tmp;
    }

    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        System.out.println(new Ones_and_Zeroes().findMaxForm(strs, 5, 3));
    }

}
