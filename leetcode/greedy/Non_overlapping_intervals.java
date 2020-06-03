package com.faa.coding.leetcode.greedy;

import java.util.Arrays;

public class Non_overlapping_intervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        int result = 0;
        int len = intervals.length;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);//按照第一位从小到大排序,a[0] > b[0]时，进行交换

        //intervals是一个整体，第二个参数是根据第一个参数变化的
//        Arrays.sort(intervals, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return 0;
//            }
//        });

        for(int i = 1; i < len; i++) {
            if(intervals[i][0] < intervals[i - 1][1]) {
                if(intervals[i - 1][1] < intervals[i][1]) {
                    intervals[i][0] = intervals[i - 1][0];
                    intervals[i][1] = intervals[i - 1][1];
                }
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,3},{3,4},{1,2}};


         System.out.println(new Non_overlapping_intervals().eraseOverlapIntervals(intervals));
//        new Non_overlapping_intervals().eraseOverlapIntervals(intervals);
    }

}

