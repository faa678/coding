package com.faa.coding.leetcode.greedy;

public class Best_time_to_buy_and_sell_stock_2 {

    public int maxProfit(int[] prices) {
        int result = 0;
        int len = prices.length;
        if (len <= 1) return result;
        int buy = prices[0], sell = -1;
        for(int i = 1; i < len; i++) {
            if(prices[i] > prices[i - 1]) {
                result += prices[i] - prices[i - 1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] prices = {2,1,2,1,0,0,1};
        System.out.println(new Best_time_to_buy_and_sell_stock_2().maxProfit(prices));
    }

}
