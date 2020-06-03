package com.faa.coding.leetcode.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Partition_Labels {

    public List<Integer> partitionLabels(String S) {
        ArrayList<Integer> result = new ArrayList<>();

        int len = S.length();

        HashMap<Character, Integer> map = new HashMap();
        for(int i = 0; i < len; i++)
            map.put(S.charAt(i), i);

        int max = map.get(S.charAt(0));
        int pre = 0;
        for(int i = 0; i < len; i++) {
            max = Math.max(max, map.get(S.charAt(i)));
            if(i == max) {
                result.add(max + 1 - pre);
                pre = max + 1;
            }
        }

        System.out.println(result.toString());
        return result;
    }

    public static void main(String[] args) {
        new Partition_Labels().partitionLabels("ababcbacadefegdehijhklij");
    }

}
