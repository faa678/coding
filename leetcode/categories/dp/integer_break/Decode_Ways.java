package com.faa.leetcode.dp.integer_break;

public class Decode_Ways {


    //自底向上
    // f(n) = tail != '0' : f(n - 1) + legal(tail) : f(n - 2)
    public int numDecodings(String s) {
        int len = s.length();
        if(len == 0 || s.charAt(0) == '0') return 0;
        int[] dp = new int[len + 1];
        dp[0] = 1;//辅助位
        dp[1] = 1;
        for(int i = 2; i < len + 1; i++) {
            //对于 s 来说 i 比 dp 偏左一位
            if(s.charAt(i - 1) != '0') dp[i] = dp[i - 1];//如果当前一位字符合法，直接单独加后面
            if(isLegal(s.substring(i - 2, i))) dp[i] += dp[i - 2];//如果当前一位 + 上一位合起来合法
        }
        return dp[len];
    }


    private boolean isLegal(String s) {
        return s.compareTo("26") <= 0 && s.charAt(0) != '0';
    }
    public static void main(String[] args) {
        String s = "12120";
        System.out.println(new Decode_Ways().numDecodings(s));
    }

}
