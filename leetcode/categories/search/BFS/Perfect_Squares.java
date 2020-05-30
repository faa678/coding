package com.faa.leetcode.search.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

///求最少使用BFS算法

public class Perfect_Squares {

    /*
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        // 创建 set 来存放非重复的元素
        Set<Integer> visited = new HashSet<>();
        queue.add(n);
        // 定义 level 记录完全平方数的个数
        int level = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            // 每次有元素入队就代表还有剩余子平方数
            level++;
            for (int i = 0; i < len; i++) {
                int node = queue.poll();
                // 从 1 开始取，每次拿平方数来比较
                for (int j = 1; j * j <= node; j++) {
                    // 用当前结点减去平方数 1,4,9...
                    int next = node - j * j;
                    // 找完所有的平方数即可返回
                    if (next == 0) {
                        return level;
                    }
                    // 如果 set 里面没有存放当前元素，则可以入队,入 set
                    if (!visited.contains(next)) {
                        queue.add(next);
                        visited.add(next);
                    }
                }
            }
        }
        return 0;
    }
    * */

    public static int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<Integer>();
        Set<Integer> set = new HashSet<>();
        queue.offer(n);
        queue.offer(-1);
        int result = 0;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            if(cur == -1) {
                result++;
                //用 -1 作为每一层的分界线，当获取到的值为 -1 时，
                // 就代表当前这一层已经全部分析完，
                // 并且当前层的下一层也已经加入队列完毕，所以在队列尾部入队 -1
                queue.offer(-1);
                continue;
            }
            //使用set去重
            if(!set.contains(cur))
                set.add(cur);
            else continue;

            if(cur == 0) break;
            for(int i = 1; i <= cur; i++) {
                if(i * i > cur) {
                    break;
                }
                else queue.offer(cur - i * i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }

}
