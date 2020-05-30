package com.faa.leetcode.dp.fib;

public class House_Robber {

    public int rob(int[] nums) {

        int len = nums.length;
        if(len == 0) return 0;

        int[] dp = new int[len];//表示到第i家的最大获利
        if(len > 0) dp[0] = nums[0];
        if(len > 1) dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(new House_Robber().rob(nums));
    }

}
