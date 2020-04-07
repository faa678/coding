package com.faa.leetcode.partition;

import java.util.concurrent.atomic.AtomicInteger;

public class Find_Minimum_in_Rotated_Sorted_Array {

    public static int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while(l < r) {
            int m = l + (r - l) / 2;
            if(nums[m] > nums[r]) {
                l = m + 1;
            }
            else if(nums[m] < nums[r]) {
                r = m;//如果m刚好是最小值的话，r = m - 1就错了，所以此时
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        int a = findMin(new int[]{4,5,6,7,0,1,2});
        System.out.println(a);
    }

}
