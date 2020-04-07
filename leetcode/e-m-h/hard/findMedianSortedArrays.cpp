/*
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
*/

#include<iostream>
#include<vector>
using namespace std;

double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {//感觉没错啊，但是{1， 2}和{3， 4}报错
    int len1 = nums1.size();
    int len2 = nums2.size();
    int len = (len1 + len2) / 2;
    int i = 0, j = 0;
    vector<double> result;
    while(i + j <= len){
        if(i < len1 && nums1[i] <= nums2[j]){
            result.emplace_back(nums1[i]);
            i++;
        }
        else if(j < len2 && nums2[j] <= nums1[i]){
            result.emplace_back(nums2[j]);
            j++;
        }
        else if(i == len1){
            result.emplace_back(nums2[j]);
            j++;
        }
        else if(j == len2){
            result.emplace_back(nums1[i]);
            i++;
        }
    }
    if((len1 + len2) & 1 == 1){
        return result[len];
    }
    else{
        return (result[len - 1] + result[len]) / 2;
    }
}

int main(){
    vector<int> a{1, 2};
    vector<int> b{3, 4};
    cout<<findMedianSortedArrays(a, b);
    return 0;
}