package com.faa.coding.leetcode.search.backtracking;

import java.util.*;

public class Permutations {

    List<List<Integer>> list = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] visited;
    public List<List<Integer>> permute(int[] nums) {

        int len = nums.length;

        List<Integer> path = new ArrayList<>();
        visited = new boolean[len];

        backtrack(nums, len, visited);
        return list;
    }

    private void backtrack(int[] nums, int len, boolean[] visited) {
        if(path.size() == len) {
            list.add(new ArrayList<>(path));//使用深拷贝
            return;
        }
        //此步类似四个方向
        for(int i = 0; i < len; i++) {
            if(!visited[i]) {
                path.add(nums[i]);
                visited[i] = true;
                backtrack(nums, len, visited);
                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Permutations().permute(nums));
    }

}
