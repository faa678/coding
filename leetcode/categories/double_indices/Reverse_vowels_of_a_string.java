package com.faa.leetcode.double_indices;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author ：faa
 * @description：TODO
 * @date ：2020/2/15 14:23
 */

public class Reverse_vowels_of_a_string {

    private final HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String reverseVowels(String s) {

        int len = s.length();

        char[] cs = s.toCharArray();
        int left = 0, right = len -1;
        while(left < right) {
            if(!vowels.contains(cs[left])) left++;
            else if(!vowels.contains(cs[right])) right--;
            else {
                cs[left] = s.charAt(right);
                cs[right] = s.charAt(left);
                left++;
                right--;
            }

        }
        return new String(cs);
    }

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(s);
        System.out.println(new Reverse_vowels_of_a_string().reverseVowels(s));
    }

}
