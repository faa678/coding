package com.faa.leetcode.search.backtracking;

import java.util.*;

public class Combination_Sum_II {

    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        int len = candidates.length;
        if(len == 0) return list;
        Arrays.sort(candidates);
        List<Integer> combination = new ArrayList<>();
        boolean[] visited = new boolean[len];
        dfs(candidates, len, combination, target, 0, 0);

        return list;
    }

    private void dfs(int[] candidates, int len, List<Integer> combination, int target, int sum, int pos) {
        if(sum == target) {
            list.add(new ArrayList<Integer>(combination));
            return;
        }
        Set<Integer> set = new HashSet<>();//对每一层去重，一个dfs是一层
        for(int i = pos; i < len; i++) {

                if(set.contains(candidates[i])) continue;
                if(sum + candidates[i] > target) return;
                combination.add(candidates[i]);
                dfs(candidates, len, combination, target, sum + candidates[i], i + 1);
                set.add(candidates[i]);
                combination.remove(combination.size() - 1);

        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(new Combination_Sum_II().combinationSum2(candidates, target));
    }

}
