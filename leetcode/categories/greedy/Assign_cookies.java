package com.faa.leetcode.greedy;

import java.util.Arrays;


//贪心：只在每次分配时选择当前最优解
//每次尽可能分配给当前孩子满足其最小的结果
public class Assign_cookies {

    public int findContentChildren(int[] g, int[] s) {
        int g_size = g.length, s_size = s.length, result = 0;
        if(g_size == 0 || s_size == 0) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while(i < g_size && j < s_size) {
            if(s[j] >= g[i]) {
                result++;
                i++;
            }
            j++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] g = new int[]{10,9,8,7};
        int[] s = new int[]{5,6,7,8};
        System.out.println(new Assign_cookies().findContentChildren(g, s));
    }

}
