/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
Example 2:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
*/

#include<iostream>
#include<vector>
using namespace std;
/**
int maxProfit(vector<int>& prices) {
    int profit = 0;
    if(prices.empty())return profit;
    int buy = prices[0], prePrice = 100;
    for(int i = 0; i < prices.size(); i++){
        if(prices[i] <= prePrice){//用前一天的价格和今天的相比，今天比昨天低就把今天的当做买入价格
            buy = prices[i];
            for(int j = i; j < prices.size(); j++){//后面的价格减今天的价格，循环得到最大的profit
                if(prices[j] - prices[i] >= profit){//得到最大值
                    profit = prices[j] - prices[i];
                }
            }
        }
        prePrice = prices[i];
    }
    return profit;
}
**/
  int maxProfit(vector<int>& prices) 
    {
        if(prices.empty()) return 0;
        
        int buyPrice = prices[0];
        int res = 0;
        int len = prices.size();
        for (int i = 1; i < len; ++i)
        {
            buyPrice = min(buyPrice, prices[i]);
            res = max(res, prices[i] - buyPrice);
        }
        return res; 
    }

int main(){
    int a[] = {7,1,5,3,6,4};
    vector<int> a_v(a, a + 6);
    cout<<maxProfit(a_v);
    return 0;
}