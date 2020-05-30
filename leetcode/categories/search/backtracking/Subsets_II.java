package com.faa.leetcode.search.backtracking;

import java.util.*;

public class Subsets_II {

    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        int len = nums.length;
        if(len == 0) return list;
        Arrays.sort(nums);
        List<Integer> combination = new ArrayList<>();

        dfs(nums, len, combination, 0);

        return list;
    }

    private void dfs(int[] nums, int len, List<Integer> combination, int pos) {
        list.add(new ArrayList<Integer>(combination));
        Set<Integer> set = new HashSet<Integer>();

        for(int i = pos; i < len; i++) {
            if(set.contains(nums[i])) continue;
            combination.add(nums[i]);
            set.add(nums[i]);
            dfs(nums, len, combination, i + 1);
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        System.out.println(new Subsets_II().subsetsWithDup(nums));
    }

}
