/*
Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
Note:

Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?
*/
#include<iostream>
#include<vector>
using namespace std;

/*
void rotate(vector<int>& nums, int k) {
    int len = nums.size();
    int tmp = 0;
    for(int i = 0; i < k; i++){
        tmp = nums[len - 1];
        nums.pop_back();
        nums.insert(nums.begin(), tmp);
    }
}
*/
//O(n)
void rotate(vector<int>& nums, int k) {
    int len = nums.size();
    vector<int> tmp(nums);
    for(int i = 0; i < len; i++){
        //nums[i] = tmp[(i + k) % len];
        nums[(i + k) % len] = tmp[i];
    }
}

int main(){
    vector<int> a = {1,2,3,4,5,6,7};
    rotate(a, 3);
    for(int i = 0; i < a.size(); i++){
        cout<<a[i];
    }
    return 0;
}