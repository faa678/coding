package com.faa.coding.leetcode.greedy;

import java.util.Arrays;

public class Minimum_number_of_arrows_to_burst_ballons {

    public int findMinArrowShots(int[][] points) {

        int len = points.length;

        if(len == 0) return 0;

        Arrays.sort(points, (a, b) -> a[1] - b[1]);//看end，用后面的首位（一个一个看的）和前面的末位（统一的几个）比较

        int result = 1;
        int i = 0;
        int pre = points[0][1];
        while(i < len) {
            if(points[i][0] > pre) {
                result++;
                pre = points[i][1];
            }
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
//        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}, {11, 18}};
        int[][] points = {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        System.out.println(new Minimum_number_of_arrows_to_burst_ballons().findMinArrowShots(points));

        for(int[] i : points) {
            for(int j : i) {
                System.out.println(j);
            }
        }
    }

}
