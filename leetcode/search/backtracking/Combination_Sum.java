package com.faa.coding.leetcode.search.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum {

    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        int len = candidates.length;
        if(len == 0) return list;
        Arrays.sort(candidates);//需要先进行排序
        List<Integer> combination = new ArrayList<>();

        dfs(candidates, len, combination, 0, target, 0);

        return list;
    }

    private void dfs(int[] candidates, int len, List<Integer> combination, int sum, int target, int pos) {//pos用于记录上一个数的位置，不能去前面查找，否则会有记录重复
        if(sum == target) {
            list.add(new ArrayList<Integer>(combination));
            return;
        }
        for(int i = pos; i < len; i++) {
            if(sum + candidates[i] > target) continue;
            combination.add(candidates[i]);
            dfs(candidates, len, combination, sum + candidates[i], target, i);//不是i + 1，因为可以重复使用数字
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] condidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(new Combination_Sum().combinationSum(condidates, target));
    }

}
