package com.faa.coding.leetcode.sorting;

import java.util.PriorityQueue;

public class Kth_Largest_Element {


    //使用冒泡排序, 每次得到最大值, 排k次得到第k大, 最坏O(n*n)
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        for(int i = 0; i < k; i++) {
            int tmp = nums[0];
            for(int j = 0; j < len - i; j++) {
                if(nums[j] < tmp) {
                    nums[j - 1] = nums[j];
                    nums[j] = tmp;
                }
                tmp = nums[j];
            }
            System.out.println(i + ": " + nums[len - 1 - i]);
        }
        System.out.println("第" + k + "大: " + nums[len - k]);
        return nums[len - k];
    }

    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int num : nums) {
            if(heap.size() == k) {
                if(num > heap.peek()) {
                    heap.poll();//移除堆顶元素
                    heap.offer(num);
                }
            }
            else {
                heap.offer(num);
            }

        }
        return heap.peek();
    }

    public int findKthLargest3(int[] nums, int k) {
        if(nums.length == 0 || nums == null) return 0;
        int len = nums.length;
        int left = 0, right = len - 1;
        while(true) {
            int position = partition(nums, left, right);
            if(position == len - k) return nums[position];
            else if(position < len - k) left = position + 1;
            else right = position - 1;
        }
    }
    public int partition (int[] nums, int left, int right) {//使用l, r不用额外数组
        int pivot = left;
        int l = left  + 1, r = right;
        while(l <= r) {
            while(l <= r && nums[l] <= nums[pivot]) l++;
            while(l <= r && nums[r] >= nums[pivot]) r--;
            if(l < r && nums[l] > nums[pivot] && nums[r] < nums[pivot]) {//左侧找到大于pivot的值, 右侧找到小于pivot的值, 交换位置（从小到大排序）
                swap(nums, l++, r--);//一样的效果
//                l++;
//                r--;
            }
        }
        swap(nums, pivot, r);
        return r;
    }
    public void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        System.out.println(new Kth_Largest_Element().findKthLargest3(nums, 2));
    }

}


