package com.faa.leetcode.dp.fib;

public class House_Robber_II {

    public int rob(int[] nums) {

        int len = nums.length;
        if(len == 0) return 0;
        else if(len == 1) return nums[0];
        //分成 0 - len-1 就不会形成环了
        else return Math.max(dp(nums, 0, len - 2), dp(nums, 1, len - 1));


    }

    private int dp(int[] nums, int start, int end) {
        int len = end - start + 1;
        if(len == 0) return 0;
        int[] dp = new int[len];
        if(len > 0) dp[0] = nums[start];
        if(len > 1) dp[1] = Math.max(nums[start], nums[start + 1]);
        for(int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i + start], dp[i - 1]);
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(new House_Robber_II().rob(nums));
    }

}
