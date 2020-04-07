package com.faa.leetcode.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Queue_reconstruction_by_height {

    public int[][] reconstructQueue(int[][] people) {
        int len = people.length;
        int[][] result = new int[len][2];
        for(int[] i : result){
            i[0] = -1;
            i[1] = -1;
        }
        Arrays.sort(people, (a, b) -> a[0] - b[0]);//从小到大排序


        for(int i = 0; i < len; i++) {
            int count = 0;
            for(int j  = 0; j < len; j++) {
                if(count == people[i][1]) {
                    if(result[j][0] == -1 && result[j][1] == -1) {//需要保证当前位置没有放过
                        result[j] = people[i];//顺序按照第二位放到正确的位置,也就是最终位置，因为从小到大排序，所以选定的位置都是最终位置
                        break;
                    }
                    else continue;
                }
                else {
                    if((result[j][0] == -1 && result[j][1] == -1) || result[j][0] >= people[i][0]) {
                        count++;
                    }
                }
            }
        }

        return result;
    }

    public int[][] reconstructQueue2(int[][] people) {
        if(people == null || people.length == 0 || people[0].length == 0) return new int[0][0];

        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));//身高高的在前，身高等的k小的在前

        List<int[]> list = new ArrayList<>();
        for(int[] p : people) {
            list.add(p[1], p);
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int[][] result = new Queue_reconstruction_by_height().reconstructQueue2(people);
        for(int[] i : result){
            for(int j : i) {
                //System.out.print(j);
            }
        }
    }

}
