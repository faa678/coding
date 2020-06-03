package com.faa.coding.leetcode.greedy;

import java.util.*;

public class Partition_lables {

    public List<Integer> partitionLabels(String S) {
        int len = S.length();
        List<Integer> result = null;
        HashMap<Character, Integer[]> ch_map = new HashMap<>();
        for(int i = 0; i < len; i++) {
            char c = S.charAt(i);
            if(ch_map.containsKey(c)) {
                ch_map.put(c, new Integer[]{ch_map.get(c)[0], i});
            }
            else {
                ch_map.put(c, new Integer[]{i, i});
            }
        }

        ArrayList<Integer[]> values = null;
        for(Character key : ch_map.keySet()) {
            values.add(ch_map.get(key));
        }

        Collections.sort(values, (a, b) -> a[0] - b[0]);

        int pre = 0;
        for(int i = 1; i < values.size(); i++) {
            if(values.get(i)[0] > values.get(i - 1)[1]) {
                result.add(values.get(i - 1)[1] - pre);
                pre = values.get(i)[0];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Partition_lables().partitionLabels("ababcbacadefegdehijhklij"));
    }

}
