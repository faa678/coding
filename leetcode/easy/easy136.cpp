/*
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4
*/

#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int singleNumber(vector<int>& nums) {
    int len = nums.size();
    int result = 0;
    //sort(nums.begin(), nums.end());//对vector使用的sort函数
    for(int i = 0; i < len; i++){
        result = result ^ nums[i];//使用异或操作
    }
    return result;
}

int main(){
    return 0;
}