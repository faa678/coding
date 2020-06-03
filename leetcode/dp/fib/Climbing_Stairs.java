package com.faa.coding.leetcode.dp.fib;

import java.util.HashMap;
import java.util.Map;

public class Climbing_Stairs {

    public int climbStairs(int n) {

        if(n <= 2) return n;
        int[] dp = new int[n + 1];//一共n阶，dp[0]是0阶而不是1阶
        dp[1] = 1;//n是正整数
        dp[2] = 2;
        for(int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairs1(int n) {
        int pre1 = 1; int pre2 = 2; int cur = n;
        for(int i = 3; i < n + 1; i++) {
            cur = pre1 + pre2;
            pre1 = pre2;
            pre2 = cur;
        }
        return cur;
    }

    Map<Integer, Integer> map = new HashMap<>();
    public int climbStairs2(int n) {
        if(n <= 2) return n;//n是正整数
        if(map.containsKey(n)) return map.get(n);
        else {
            map.put(n, climbStairs2(n - 1) + climbStairs2(n - 2));
            return map.get(n);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new Climbing_Stairs().climbStairs1(n));
    }

}
