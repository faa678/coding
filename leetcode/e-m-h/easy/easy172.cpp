/*
Given an integer n, return the number of trailing zeroes in n!.

Example 1:

Input: 3
Output: 0
Explanation: 3! = 6, no trailing zero.
Example 2:

Input: 5
Output: 1
Explanation: 5! = 120, one trailing zero.
Note: Your solution should be in logarithmic time complexity.
*/

#include<iostream>
using namespace std;

int trailingZeroes(int n) {
    if(n == 0)return 0;
    //求5的个数,25包含两个5，所以是/5, /5/5, /5/5/5,......
    int count = 0;
    while(n > 0){
        count += n / 5;
        n /= 5;
    }
    return count;
}
//递归法
/*int trailingZeroes(int n) {
    //求5的个数,25包含两个5，所以是/5, /5/5, /5/5/5,......
    if(n > 0){
        return n / 5 + trailingZeroes(n / 5);
    }
    return 0;
}*/

int main(){
    cout<<trailingZeroes(30);
    return 0;
}