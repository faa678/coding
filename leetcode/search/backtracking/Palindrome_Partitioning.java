package com.faa.coding.leetcode.search.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partitioning {

    List<List<String>> list = new ArrayList<>();
    public List<List<String>> partition(String s) {

        int len = s.length();
        if(len == 0) return list;

        List<String> sublist = new ArrayList<>();
        dfs(s, len, sublist, 0);
        return list;
    }

    private void dfs(String s, int len, List<String> sublist, int pos) {
        if(pos == len) {
            list.add(new ArrayList<String>(sublist));
        }

        for(int i = pos; i < len; i++) {
            String tmp = s.substring(pos, i + 1);
            if(!isPalindrome(tmp)) continue;
            sublist.add(tmp);
            dfs(s, len, sublist, i + 1);
            sublist.remove(sublist.size() - 1);
        }

    }

    private boolean isPalindrome(String s) {
        int len = s.length();
        for(int i = 0; i < len >> 1; i++) {
            if(s.charAt(i) != s.charAt(len - i - 1)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(new Palindrome_Partitioning().partition(s));
    }

}
