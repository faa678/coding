package com.faa.coding.leetcode.search.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：faa
 * @description：TODO
 * @date ：2020/4/26 21:08
 */

public class Restore_IP_Addresses {

    List<String> list = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {

        if(s == null || s.length() < 4 || s.length() > 12) return list;

        int len = s.length();
        backtrack("", s, 0);
        return list;
    }

    private void backtrack(String combination, String s, int flag) {

        int len = s.length();
        if(flag == 4 && len == 0) {
            list.add(combination);
        }

        if(s == null || s == "" || flag > 3 || (4 - flag) * 3 < len) {
            return;
        }

        for(int i = 0; i < 3; i++) {
            if(i >= len || isIllegal(s.substring(0, i + 1))) return;
            String sub = s.substring(0, i + 1);//上面的 i + 1 == len 直接return的话，举例最后两位35，此时此句之前就return了

            //此处 flag = 3 是因为 flag 还没 +1 之前就形成了第一个数字
            backtrack(combination + sub + (flag < 3 ? "." : ""), s.substring(i + 1, len), flag + 1);
        }


    }

    private boolean isIllegal(String n) {
        return ((n.length() > 1 && n.charAt(0) == '0') || Integer.parseInt(n) < 0 || Integer.parseInt(n) > 255);
    }

    public static void main(String[] args) {
        String s = "25525511135";
        String n = "";
        System.out.println(new Restore_IP_Addresses().restoreIpAddresses(s));
    }

}
