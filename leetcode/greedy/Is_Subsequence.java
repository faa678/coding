package com.faa.coding.leetcode.greedy;

public class Is_Subsequence {

    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while(i < s.length() && j < t.length()) {
            if(s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        if(i == s.length()) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Is_Subsequence().isSubsequence("axc", "ahbgdc"));
    }

}
