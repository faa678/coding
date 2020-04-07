package com.faa.leetcode.sorting;

/*
Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

进阶：

一个直观的解决方案是使用计数排序的两趟扫描算法。
首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
你能想出一个仅使用常数空间的一趟扫描算法吗？


0: red, 1: white, 2: blue

 */


/*
    1）若遍历到值为1的元素，则说明其属于中部，中部的不动，cur向后移动一个位置；
　　2）若是遇到值为0的元素，则说明其必属于前部，于是和beg的位置的值进行交换，然后cur向后移动一个位置，beg也向后移动一个位置，表示beg之前的部分已经排好了。
　　3）若是遇到值为2的元素，则说明其必属于后部，于是，和end位置的值进行交换，然后end向前移动一个位置，表示end之后的都排好了，但是，cur不要向后移动一个位置，因为交换后的cur所指向的值可能等于0，即属于前部还没有比较，所以，下次循环还是从此处开始。（因为是从前往后遍历的）
 */
public class Sort_Colors {

    public void sortColors(int[] nums) {

        int left = 0, right = nums.length - 1;

        for(int i = 0; i <= right; i++) {
            if(left == right) break;
            if(nums[i] == 0) swap(nums, i, left++);
            else if(nums[i] == 2) swap(nums, i--, right--);
            else continue;
        }

    }

    public void sortColors2(int[] nums) {
        int left = 0, current = 0, right = nums.length - 1;
        while(current <= right) {
            if(left == right) break;
            if(nums[current] == 0) swap(nums, current, left++);
            else if(nums[current] == 2) swap(nums, current--, right--);//交换2后，需要保持当前不动
            current++;
        }
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        new Sort_Colors().sortColors(nums);
        for(int i : nums) {
            System.out.println(i);
        }
    }

}
