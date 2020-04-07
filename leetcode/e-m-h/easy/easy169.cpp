/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2
*/

#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int majorityElement(vector<int>& nums) {
    int len = nums.size();
    //int begin = 0, end = 0, result = nums[0];
    sort(nums.begin(), nums.end());//排好序
   /** for(int i = 0; i < len; i++){
        if(nums[i] != result){
            end = i;
            if(end - begin > len / 2)return result;//判断间隔
            else{
                begin = i;
                result = nums[i];
            }
        }
        if(i == len - 1 && nums[i] == result)return nums[i];//最后一位和前一位相同的情况，跑到这一步了说明前面没找到，说明最后一位的值就是结果
    }
    return 0;
    **/
    return nums[len / 2];
}

int main(){
    return 0;
}