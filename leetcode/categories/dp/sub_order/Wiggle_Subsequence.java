package com.faa.leetcode.dp.sub_order;

import java.util.Arrays;

/**
 * @author ：faa
 * @description：TODO
 * @date ：2020/5/24 14:16
 */

public class Wiggle_Subsequence {

    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        if(len < 2) return len;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        if(nums[0] != nums[1])
            dp[1] = 2;
        int first = nums[1] -nums[0]; int second = 0;
        for(int i = 2; i < len; i++) {//i 从 2 开始
            second = nums[i] - nums[i - 1];
            if(second * first < 0 || (first == 0 && second != 0)) {//或的是开头一直不增不减的情况
                dp[i] = dp[i - 1] + 1;
                first = second;
            }
            else dp[i] = dp[i - 1];
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 4, 9, 2, 5};

        System.out.println(new Wiggle_Subsequence().wiggleMaxLength(nums));

    }

}
