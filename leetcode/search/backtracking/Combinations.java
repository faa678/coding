package com.faa.coding.leetcode.search.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {

        if(n <= 0 || k <= 0 || n < k) return list;

        List<Integer> combination = new ArrayList<>();

        boolean[] visited = new boolean[n];

        dfs(n, k, combination, visited, 0);

        return list;
    }

    private void dfs(int n, int k, List<Integer> combination, boolean[] visited, int pos) {//pos是上一位在数组中的位置
        if(combination.size() == k) {
            list.add(new ArrayList(combination));
            return;
        }
        for(int i = pos; i < n; i++) {
            if(!visited[i]) {
                combination.add(i + 1);
                visited[i] = true;
                dfs(n, k, combination, visited, i + 1);
                visited[i] = false;
                combination.remove(combination.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        System.out.println(new Combinations().combine(n, k));
    }

}
