package com.faa.coding.leetcode.dp.package_0_1;

/**
 * @author ：faa
 * @description：TODO
 * @date ：2020/6/3 8:57
 */

public class Coin_change_II {

    public int change(int amount, int[] coins) {
        int len = coins.length;
        if(amount == 0) return 1;
        if(len == 0) return 0;
        // f(amount): 可以凑成 amount 金额的硬币组合数
        int[] dp = new int[amount + 1];
        dp[0] = 1; // 减到 0 时说明可以到达
        for(int j = 0; j < len; j++) { // 如果两个循环调过来，221 和 212 重了，求组合数不关心顺序
            for(int i = 1; i <= amount; i++) {
                if(i - coins[j] >= 0)
                    dp[i] += dp[i - coins[j]];
            }
        }
        return dp[amount];
    }

    public int change2(int amount, int[] coins) {
        return 0;
    }

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.println(new Coin_change_II().change(amount, coins));
    }

}
