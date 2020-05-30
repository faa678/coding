package com.faa.leetcode.dp.array_range;

public class Arithmetic_Slices {

    public int numberOfArithmeticSlices(int[] A) {
        int len = A.length;
        if(len < 3) return 0;
        int[] dp = new int[len];
        dp[0] = 0; dp[1] = 0;
        int pos = 0;
        for(int i = 2; i < len; i++) {
            if(A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                //找规律
                //5: 3 + 2 + 1
                //4: 2 + 1
                //3: 1
                dp[i] = dp[i - 1] + 1;
            }
        }
        int count = 0;
        for(int i : dp) {
            count += i;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        System.out.println(new Arithmetic_Slices().numberOfArithmeticSlices(A));
    }

}
