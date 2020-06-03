package com.faa.coding.leetcode.greedy;

public class Can_place_flowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int counter = 0;
        for(int i = 0; i < len; i++) {
            if(flowerbed[i] == 0 &&  (i - 1 < 0 || flowerbed[i - 1] == 0) && (i + 1 >= len || flowerbed[i + 1]  == 0))  {
                counter++;
                i++;//外层i也要加1
            }
        }
        if(counter < n) return false;
        else return true;
    }

    public static void main(String[] args) {
        int[] flowerbed = {1, 0, 0, 0, 0, 1};
        System.out.println(new Can_place_flowers().canPlaceFlowers(flowerbed, 2));
    }

}

