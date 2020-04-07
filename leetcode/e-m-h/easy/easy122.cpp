/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

Example 1:

Input: [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Example 2:

Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
*/
#include<iostream>
#include<vector>
using namespace std;

int maxProfit(vector<int>& prices) {
    int buy = 0, profit = 0, lastDay = 0;
    if(prices.empty())return profit;
    buy = prices[0];
    lastDay = prices.size();
    int tmp = 0;
    for(int i = 1; i < lastDay; i++){
        buy = min(buy, prices[i]);
        prices[i] - buy >= tmp ? tmp = prices[i] - buy : (profit += tmp, buy = prices[i], tmp = 0);//要加括号 //遇到不递增的元素，计算前面的利润
        if(i == lastDay - 1)profit += prices[i] - buy;//结尾如果全是递增特殊处理
    }
    return profit;       
}

/*
	int maxProfit(vector<int>& prices) {
        int n=prices.size();
        if (n==0) return 0;
        int prof=0;
        
        for (int i=1; i<n; i++) {
            if (prices[i]>prices[i-1]) 
                prof+=(prices[i]-prices[i-1]);
        }
        return prof;
    }
*/

int main(){
    int a[] = {7,1,5,3,6,4};
    vector<int> a_v(a, a + 6);
    cout<<maxProfit(a_v);
    return 0;
}