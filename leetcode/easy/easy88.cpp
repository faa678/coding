/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
*/
#include<iostream>
#include<vector>
using namespace std;

void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int pos = m + n -1;
        while(m > 0 && n > 0){
                int a = nums1[m - 1], b = nums2[n - 1];//从两个数组的尾开始对比，大的放在结果数组的尾
                nums1[pos] = a >= b ? a : b;
                pos--;
                a >= b ? m-- : n--;
        }
        if(m == 0){//当nums2还有剩余的时候，顺序放进nums1
            for(int i = 0; i < n; i++){
                nums1[i] = nums2[i];
            }
        }
    }

int main(){
    int m[] = {1,2,3};
    int n[] = {2,5,6};
    vector<int> nums1(m,m+3);
    vector<int> nums2(n,n+3);
    merge(nums1,3,nums2,3);
    for(int i = 0; i < 6; i++){
        cout<<nums1[i]<<" ";
        cout<<endl;
    }
    
    return 0;
}