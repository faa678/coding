/*
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

Note:

Your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you may not use the same element twice.
Example:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
*/

#include<iostream>
#include<vector>
using namespace std;

vector<int> twoSum(vector<int>& numbers, int target) {
    vector<int> empty;
    int len = numbers.size();
    if(len < 2)return empty;
    vector<int> result;
    int i = 0, j = len - 1;
    while(i < j){
        if(numbers[i] + numbers[j] == target){
            result.emplace_back(i);
            result.push_back(j);
            return result;
        }
        else if(numbers[i] + numbers[j] < target) i++;
        else j--;
    }
    return empty;
}

//result.emplace_back()更加高效