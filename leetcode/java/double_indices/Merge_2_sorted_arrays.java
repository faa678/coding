package com.faa.leetcode;

public class Merge_2_sorted_arrays {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        while(m > 0 && n > 0) {//从后往前
            if(nums1[m - 1] >= nums2[n - 1]) {
                nums1[m + n - 1] = nums1[m - 1];
                m--;
            }
            else {
                nums1[m + n - 1] = nums2[n - 1];
                n--;
            }
        }
        if(m == 0) {
            for(int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3, 5, 0, 0, 0};
        int[] nums2 = new int[]{2, 4, 6};
        new Merge_2_sorted_arrays().merge(nums1, 3, nums2, 3);
        for(int i = 0; i < 6; i++) {
            System.out.println(nums1[i]);
        }
    }

}
