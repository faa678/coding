package com.faa.leetcode.greedy;

public class Non_decreasing_Array {

    public boolean checkPossibility(int[] nums) {
        int len = nums.length;
        if(len < 3) return true;
        int counter = 0;
        int pre = nums[0];
        for(int i = 1; i < len; i++) {
            if(nums[i] < nums[i - 1]) {
                counter++;
                if(counter > 1) return false;
                if(i == 1 || nums[i] > nums[i - 2]) {//看i和i-2位置上谁大
                    nums[i - 1] = nums[i];//i大的话让i-1=i
                }
                else {//为了首位
                    nums[i] = nums[i - 1];//否则让i=i-1
                }
            }
        }
        if(counter <= 1) return true;
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 4, 2, 3};
        System.out.println(new Non_decreasing_Array().checkPossibility(nums));
    }

}
