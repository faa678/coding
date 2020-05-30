package com.faa.leetcode.dp.fib;

import java.util.*;

public class Coin_Change {

    public int coinChange(int[] coins, int amount) {
        return dp2(coins, amount);
    }

    Map<Integer, Integer> map = new HashMap<>();

    private int dp(int[] coins, int amount) {
        if(0 == amount) return 0;
        if(0 > amount) return -1;
        if(map.containsKey(amount)) return map.get(amount);
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++) {
            int tmp = dp(coins, amount - coins[i]);
            if(tmp == -1) continue;
            result = Math.min(result, 1 + tmp);
        }
        map.put(amount, result == Integer.MAX_VALUE ? -1 : result);
        return map.get(amount);
    }

    private int dp2(int[] coins, int amount) {
        //转移方程为 f(amount) = min(f(amount - coins[0]) + 1, f(amount - coins[1]) + 1, f(amount - coins[2]) + 1, ......)
        int[] f = new int[amount + 1];
        if(amount <= 0) return -1;
        f[0] = 0;
        for(int i = 1; i <= amount; i++) {
            f[i] = Integer.MAX_VALUE;
        }

        for(int i = 1; i <= amount; i++) {
            for(int j = 0; j < coins.length; j++) {
                if(i - coins[j] < 0) continue;
                f[i] = Math.min(f[i - coins[j]] + 1, f[i]);
            }
        }

        return f[amount] == Integer.MAX_VALUE ? -1 : f[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(new Coin_Change().coinChange(coins, amount));
    }

}
