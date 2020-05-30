package com.faa.leetcode.dp.integer_break;

public class Integer_Break {

    //f(n) = max(f(n - 1) * 1, f(n - 2) * 2, ..., f(1) * (n - 1))
    int[] map;
    public int integerBreak(int n) {
        map = new int[n];
        return Mul2(n);
    }

    private int Mul(int n) {
        int result = 0;

        if(n == 2) return 1;
        for(int i = 1; i < n; i++) {
            if(map[n - i - 1] == 0) map[n - i - 1] = Mul(n - 1);
            result = Math.max(result, Math.max((n - i) * i, map[n - i - 1] * i));//有可能 (n - i) > Mul(n - i)

        }
        return result;
    }

    private int Mul2(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for(int i = 3; i < n + 1; i++) {
            for(int j = 1; j < i; j++) {
                dp[i] = Math.max(Math.max(dp[i - j] * j, (i - j) * j), dp[i]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(new Integer_Break().integerBreak(n));
    }

}
