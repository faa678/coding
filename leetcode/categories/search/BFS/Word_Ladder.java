package com.faa.leetcode.search.BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Word_Ladder {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        queue.offer("");
        int level = 1;
        while(!queue.isEmpty()) {
            String cur = queue.poll();
            if(cur.equals("") && !queue.isEmpty()) {
                level++;
                queue.offer("");
                continue;
            }
            for(int i = 0; i < wordList.size(); i++) {
                String s = wordList.get(i);
                if(diff(cur, s)) {
                    if(s.equals(endWord)) return ++level;
                    queue.offer(s);
                    wordList.set(i, s + "a");
                }
            }
        }

        return 0;
    }

    private static boolean diff(String a, String b) {
        if(a.length() != b.length()) return false;
        int flag = 0;
        for(int i = 0; i < a.length(); i++) {
            if(flag > 1) return false;
            if(a.charAt(i) - b.charAt(i) != 0) flag++;
        }
        return flag <= 1;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println(diff("hit", "hoy"));
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }

}
