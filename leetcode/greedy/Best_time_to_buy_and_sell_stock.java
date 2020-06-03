package com.faa.coding.leetcode.greedy;

public class Best_time_to_buy_and_sell_stock {

    public int maxProfit(int[] prices) {
        int result = 0;
        int len = prices.length;
        if(len == 0) return 0;
        int buy = prices[0], send = prices[0];

        for(int i = 0; i < len; i++) {
            if (prices[i] - buy < 0) {
                buy = prices[i];
            }else {
                result = Math.max(result, prices[i] - buy);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        System.out.println(new Best_time_to_buy_and_sell_stock().maxProfit(prices));
    }

}
