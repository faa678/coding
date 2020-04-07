package com.faa.leetcode.sorting;

import java.util.*;

public class Top_K_frequent_elements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        //map存储的是 num : times
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            //getOrDefault(Object key, V defaultValue):当Map集合中有这个key时，就使用这个key值，如果没有就使用默认值defaultValue
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        /*
        //大顶堆
        PriorityQueue<Map.Entry<Integer, Integer>> maxheap = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));//用的是getValue
        for(Map.Entry entry : map.entrySet()) {
            maxheap.add(entry);
        }
        for(int i = 0; i < k; i++) {
            list.add(maxheap.poll().getKey());
        }
        */
        //小顶堆
        PriorityQueue<Integer> minheap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for(int key : map.keySet()) {
            minheap.add(key);//添加的是key,但是往小顶堆添加元素的时候比较的是value
            if(minheap.size() > k) minheap.poll();
        }
        while(!minheap.isEmpty()) {
            list.add(minheap.poll());
        }
        return list;
    }

    //桶排序    分数组长度的桶, 用元素出现的个数做下标, 内容是出现对应次数的元素
    public List<Integer> topKFrequent2(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int count = map.size();
        List<Integer>[] buckets = new ArrayList[nums.length];
        for(int key : map.keySet()) {
            int index = map.get(key);
            if(buckets[index - 1] == null) {
                buckets[index - 1] = new ArrayList<>();
            }
            buckets[index - 1].add(key);
        }
        for(int i = nums.length - 1; i >= 0 && list.size() < k; i--) {
            if(buckets[i] != null) {
                list.addAll(buckets[i]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        List<Integer> result = new Top_K_frequent_elements().topKFrequent2(nums, 2);
        for(int i : result) {
            System.out.println(i + " ");
        }
    }

}
