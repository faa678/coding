package com.faa.coding.leetcode.dp.integer_break;

import java.util.HashMap;
import java.util.Map;

public class Perfect_Squares {

    Map<Integer, Integer> map = new HashMap<>();
    //状态转移方程是 f(n) = min(f(n - 1) + 1, f(n - 4) + 1, ..., f(n - i ^ 2) + 1)
    public int numSquares(int n) {
        int count = Integer.MAX_VALUE;
        if(isSquare(n)) return 1;
        if(map.containsKey(n)) return map.get(n);
        for(int i = 1; i * i < n; i++) {
            count = Math.min(numSquares(n - i * i) + 1, count);
        }
        map.put(n, count);
        return count;
    }

    public int numSquares2(int n) {
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            dp[i] = i; //最坏的情况是每次都 +1
            for(int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }


    private boolean isSquare(int n) {
        for(int i = 1; ; i++) {
            if(i * i == n) return true;
            else if(i * i > n) return false;
        }
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println(new com.faa.coding.leetcode.dp.integer_break.Perfect_Squares().numSquares2(n));
    }


}
