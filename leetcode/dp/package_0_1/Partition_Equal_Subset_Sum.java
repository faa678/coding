package com.faa.coding.leetcode.dp.package_0_1;

/**
 * @author ：faa
 * @description：TODO
 * @date ：2020/5/25 12:48
 */

public class Partition_Equal_Subset_Sum {

    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if(len < 2) return false;
        int sum = 0;
        for(int i = 0; i < len; i++) {
            sum += nums[i];
        }
        if(sum % 2 == 1) return false;
        sum /= 2;
        boolean[][] dp = new boolean[len + 1][sum + 1];
        for(int i = 0; i < len; i++) {
            dp[i][0] = true;
        }
        for(int i = 1; i < len + 1; i++) {//数组中数的个数
            for(int j = 1; j < sum + 1; j++) {//容量
                //背包容量不足，不能装入第 i 个
                if(j - nums[i - 1] < 0) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
            }
        }
        return dp[len][sum];
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        System.out.println(new Partition_Equal_Subset_Sum().canPartition(nums));
    }

}
