package com.faa.coding.leetcode.search.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：faa
 * @description：TODO
 * @date ：2020/4/25 20:00
 */

public class Letter_Combinations_of_a_Phone_Number {
    Map<Character, String> map = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    List<String> list = new ArrayList<>();
    public List<String> letterCombinations(String digits) {

        if(digits == null || digits.length() == 0) return list;

        backtrack("", digits);

        return list;
    }

    private void backtrack(String combination, String digits) {
        if(digits == null || digits.length() == 0) {
            System.out.println(combination);
            list.add(combination);
            return;
        }
        String tmp = map.get(digits.charAt(0));
        int len = digits.length();
        for(char t : tmp.toCharArray()) {
            backtrack(combination + t, digits.substring(1, len));
        }
    }

    public static void main(String[] args) {
        System.out.println(new Letter_Combinations_of_a_Phone_Number().letterCombinations("23"));
    }

}
