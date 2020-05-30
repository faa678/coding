package com.faa.leetcode.dp.sub_sequence;

/**
 * @author ：faa
 * @description：TODO
 * @date ：2020/5/24 22:18
 */

public class Longest_Common_Subsequence {

    public int longestCommonSubsequence(String text1, String text2) {

        int len1 = text1.length();
        int len2 = text2.length();
        if(len1 == 0 || len2 == 0) return 0;
        int[][] dp = new int[len1 + 1][len2 + 1];

        for(int i = 1; i < len1 + 1; i++) {
            for(int j = 1; j < len2 + 1; j++) {
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;//相等了就 i j 都加 1
                }
                else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[len1][len2];

    }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(new Longest_Common_Subsequence().longestCommonSubsequence(text1, text2));
    }


}
