package com.faa.coding.leetcode.dp.array_range;

public class Range_Sum_Query {
    static class NumArray {
        int[] sum;
        public NumArray(int[] nums) {
            int len = nums.length;
            sum = new int[len + 1];
            for(int i = 0; i < len; i++) {
                sum[i + 1] = sum[i] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return sum[j + 1] - sum[i];
        }

    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2,0,3,-5,2,-1});
        System.out.println(numArray.sumRange(0, 2));
    }

}
