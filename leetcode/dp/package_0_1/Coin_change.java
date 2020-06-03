package com.faa.coding.leetcode.dp.package_0_1;

import java.util.Arrays;

/**
 * @author ：faa
 * @description：TODO
 * @date ：2020/6/3 9:08
 */

public class Coin_change {

    public int coinChange(int[] coins, int amount) {
        // 转移方程：f(amount) = min(f(amount - coins[i])) + 1;
        int len = coins.length;
        if(len == 0) return 0;
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // 初始状态
        for(int i = 0; i <= amount; i++) {
            for(int j = 0; j < len; j++) {
                if(i - coins[j] >= 0 && dp[i - coins[j]] < Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int amount = 11;
        int[] coins = {1, 2, 5};
        System.out.println(new Coin_change().coinChange(coins, amount));
    }

}
