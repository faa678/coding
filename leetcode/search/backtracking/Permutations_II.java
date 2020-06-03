package com.faa.coding.leetcode.search.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations_II {

    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {

        int len = nums.length;
        if(len == 0) return list;

        boolean[] visited = new boolean[len];

        List<Integer> path = new ArrayList<>();

        dfs(nums, len, path, visited);

        return list;
    }

    private void dfs(int[] nums, int len, List<Integer> path, boolean[] visited) {

        if(path.size() == len) {
            list.add(new ArrayList<Integer>(path));
            return;
        }

        Set<Integer> set = new HashSet<>();//对每一层去重

        for(int i = 0; i < len; i++) {

            if(!visited[i]) {
                if(set.contains(nums[i])) continue;
                set.add(nums[i]);
                path.add(nums[i]);
                visited[i] = true;
                dfs(nums, len, path, visited);
                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(new Permutations().permute(nums));
    }

}
