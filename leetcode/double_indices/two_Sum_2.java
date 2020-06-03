package com.faa.coding.leetcode.double_indices;

/**
 * @author ：faa
 * @description：TODO
 * @date ：2020/2/12 19:06
 */

//使用双指针，只遍历一次

public class two_Sum_2 {

    public int[] twoSum(int[] numbers, int target) {

        int len = numbers.length;
        int[] result = null;
        int left = 0, right = len - 1;
        while(left < right){
            int tmp = numbers[left] + numbers[right];
            if(tmp == target){
                result = new int[]{left + 1, right + 1};
                return result;
            }
            else if(tmp < target) left++;
            else right--;
        }


        return null;

    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        two_Sum_2 a = new two_Sum_2();
        int[] result = a.twoSum(numbers, 9);
        System.out.println(result[0] + ", " + result[1]);
    }

}
