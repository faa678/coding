package com.faa.coding.leetcode.double_indices;

/**
 * @author ：faa
 * @description：TODO
 * @date ：2020/2/15 17:11
 */

public class Valid_palindrom_II {

    public boolean isPalindrome(String s) {
        int len = s.length();
        for(int i = 0; i <= len / 2; i++){
            if(s.charAt(i) != s.charAt(len - 1 - i)) return false;
        }
        return true;
    }

    public boolean validPalindrome(String s) {
       // System.out.println(s.substring(0,4));//结束索引不包含
        int len = s.length();
        int left = 0, right = len - 1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)){
                return isPalindrome(s.substring(left, right)) || isPalindrome(s.substring(left + 1, right + 1));
            }
            left++;
            right--;
        }
        return true;

    }

    public static void main(String[] args) {
        String s = "deeee";
        System.out.println(new Valid_palindrom_II().validPalindrome(s));
    }

}
