package com.faa.coding.leetcode.search.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Combination_Sum_III {

    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {

        List<Integer> combination = new ArrayList<>();

        boolean[] visited = new boolean[n];
        dfs(k, combination, 0, n, 1);
        return list;
    }

    private void dfs(int k, List<Integer> combination, int sum, int n, int pos) {
        Set<Integer> set = new HashSet<>();
        if(sum == n && combination.size() == k) {
            list.add(new ArrayList(combination));
            return;
        }

        for(int i = pos; i <= 9; i++) {
            if(sum + i > n || combination.size() >= k) return;
            if(set.contains(i)) continue;
            combination.add(i);
            set.add(i);
            dfs(k, combination, sum + i, n, i + 1);//i 不要错写成 pos
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        int k = 3;
        int n = 7;
        System.out.println(new Combination_Sum_III().combinationSum3(k, n));
    }

}
