package com.faa.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sort_Characters_by_frequency {

    public String frequencySort(String s) {

        String result = "";

        //先得到每个字符出现的次数
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            charMap.put(s.charAt(i), charMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        List<Character>[] buckets = new ArrayList[s.length()];

        for(char key : charMap.keySet()) {
            int index = charMap.get(key) - 1;
            if(buckets[index] == null) {
                buckets[index] = new ArrayList<>();
            }
            buckets[index].add(key);
        }

        for(int i = s.length() - 1; i >= 0; i--) {
            if(buckets[i] != null) {
                for(char ch : buckets[i]) {
                    for(int k = 0; k <= i; k++) {
                        result += ch;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        String str= "tree";
        System.out.println(new Sort_Characters_by_frequency().frequencySort(str));

    }

}
