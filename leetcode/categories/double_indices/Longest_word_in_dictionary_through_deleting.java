package com.faa.leetcode.double_indices;

import java.util.Arrays;
import java.util.List;

public class Longest_word_in_dictionary_through_deleting {

    public String findLongestWord(String s, List<String> d) {
        String result = "";
        for(String target : d) {
            int l1 = result.length(), l2 = target.length();
            if(l1 > l2 || (l1 == l2 && result.compareTo(target) < 0))
                continue;
            if(is_equal_through_Deleting(s, target))
                result = target;
        }
        return result;
    }

    public boolean is_equal_through_Deleting(String s, String d) {
        int l = 0;
        for(int i = 0; i < d.length(); i++) {
            while(l < s.length()) {
                if(i == d.length() - 1 && s.charAt(l) == d.charAt(i)) return true;
                if(s.charAt(l) == d.charAt(i)) i++;
                l++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> d = Arrays.asList("ale","apple","monkey","plea");
        System.out.println(new Longest_word_in_dictionary_through_deleting().findLongestWord(s, d));
    }

}
