package com.faa.leetcode.double_indices;

/**
 * @author ：faa
 * @description：TODO
 * @date ：2020/2/14 15:29
 */

public class sum_of_square_numbers {

    public static boolean judgeSquareSum(int c) {
        int right = (int)Math.sqrt(c);
        int left = 0;
        while(left <= right){
            int tmp = left * left + right * right;
            if(tmp == c) {
                System.out.println(c + ": " + left + ", " + right);
                return true;
            }
            else if(tmp < c)
                left++;
            else
                right--;
        }
        return false;
    }
    public static void main(String[] args) {
        for (int i = 0; i <= 100; i++) {
            judgeSquareSum(i);
        }
    }
}
