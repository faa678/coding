package com.faa.coding.leetcode.dp.sub_order;

import java.util.Arrays;

public class Maximum_Length_Of_Pair_Chain {

    public int findLongestChain(int[][] pairs) {

        int r = pairs.length;
        if(r < 2) return r;
        Arrays.sort(pairs, (o1, o2) -> o1[0] - o2[0]);
        Arrays.sort(pairs, (o1, o2) -> o1[1] - o2[1]);
        int[] dp = new int[r];
        dp[0] = 1;
        int max_len = 1;//数组长度不为 0 的话，最短长度为 1
        for(int i = 1; i < r; i++) {
            for(int j = 0; j < i; j++) {
                if(pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max_len = Math.max(max_len, dp[i]);
                }
            }
        }
        return max_len;
    }

    public static void main(String[] args) {
        int[][] pairs = {{1, 2}, {2, 3}, {3, 4}};
        System.out.println(new Maximum_Length_Of_Pair_Chain().findLongestChain(pairs));
    }

}
