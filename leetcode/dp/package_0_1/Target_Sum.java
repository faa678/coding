package com.faa.coding.leetcode.dp.package_0_1;

/**
 * @author ：faa
 * @description：TODO
 * @date ：2020/5/27 14:35
 */

public class Target_Sum {

    public int findTargetSumWays(int[] nums, int S) {
        int len = nums.length;
        if(len == 0) return 0;
        return dp(nums, 0, S, 0);
    }

    int count = 0;
    private int dp(int[] nums, int pos, int S, int sum) {
        if(pos == nums.length && sum == S) {
            count++;
        }
        if(pos < nums.length) {
            dp(nums, pos + 1, S, sum + nums[pos]);
            dp(nums, pos + 1, S, sum - nums[pos]);
        }
        return count;
    }


    // 初始是非负整数数组！！！！！！！！！！！！！！！！！！！
    // 状态转移方程
    // dp[i][j] 表示数组中的前 i 个元素，组成和为 j 的方案数
    // dp[i][j] = dp[i - 1][j - nums[i]] + dp[i - 1][j + nums[i]]
    public int findTargetSumWays2(int[] nums, int S) {
        int len = nums.length;
        if(len == 0) return 0;
        int[][] dp = new int[len][2001];
        dp[0][nums[0] + 1000] = 1;
        dp[0][-nums[0] + 1000] = 1;
        if(nums[0] == 0) dp[0][1000] = 2;

        for(int i = 1; i < len; i++) {
            for(int j = 0; j < 2001; j++) {
                int left = 0; int right = 0;
                if(j - nums[i] >= 0) left = dp[i - 1][j - nums[i]];
                if(j + nums[i] < 2001) right = dp[i - 1][j + nums[i]];
                dp[i][j] = left + right; // dp[i][j] 不是跟相邻的 dp[i][j - 1] 直接关联的
            }
        }

        return S > 1000 ? 0 : dp[len - 1][S + 1000];
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        System.out.println(new Target_Sum().findTargetSumWays2(nums, 3));
    }
}
