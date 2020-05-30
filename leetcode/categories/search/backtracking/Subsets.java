package com.faa.leetcode.search.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        if(len == 0) return list;
        Arrays.sort(nums);
        List<Integer> combination = new ArrayList<>();
        boolean[] visited = new boolean[len];
        dfs(nums, len, combination, 0);
        return list;
    }

    private void dfs(int[] nums, int len, List<Integer> combination, int pos) {
        list.add(new ArrayList<Integer>(combination));
        for(int i = pos; i < len; i++) {
            combination.add(nums[i]);
            dfs(nums, len, combination, i + 1);
            combination.remove(combination.size() - 1);

        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Subsets().subsets(nums));
    }

}
