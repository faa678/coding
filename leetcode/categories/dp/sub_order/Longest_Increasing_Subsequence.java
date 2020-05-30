package com.faa.leetcode.dp.sub_order;

import java.util.Arrays;

public class Longest_Increasing_Subsequence {

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        // dp 保存比当前数小的数的递增个数 + 1 (需要保证递增)
        int[] dp = new int[len];

//        Arrays.fill(dp, 1);
        int result = 0;
        for(int i = 1; i < len; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    result = Math.max(dp[i], result);
                }
            }
        }
        return result + 1;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new Longest_Increasing_Subsequence().lengthOfLIS(nums));
    }

}
