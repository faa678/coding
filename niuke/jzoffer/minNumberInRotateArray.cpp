#include<iostream>
#include<vector>
using namespace std;

//顺序查找O(n)
/*
int minNumberInRotateArray(vector<int> rotateArray) {
    int len = rotateArray.size();
    if(len == 0)return 0;
    int min_ele = rotateArray[0];
    for(int i = 0; i < len; i++){
        if(rotateArray[i] < min_ele){
            min_ele = rotateArray[i];
            break;
        }
    }
    return min_ele;
}
*/

int minNumberInRotateArray1(vector<int> rotateArray, int start, int end) {
    int len = end - start;
    if(len == 0)return 0;
    int min_ele = rotateArray[start];
    for(int i = start; i < start + len; i++){
        if(rotateArray[i] < min_ele){
            min_ele = rotateArray[i];
            break;
        }
    }
    return min_ele;
}

//二分查找O(logn)
int minNumberInRotateArray(vector<int> rotateArray) {//二分查找O(logn),顺序O(n)
    int len = rotateArray.size();
    if(len == 0)return 0;
    int left = 0, mid = len / 2, right = len - 1;
    while(left < right){
        if(rotateArray[mid] >= rotateArray[left] && rotateArray[mid] <= rotateArray[right]) return rotateArray[left];//旋转数为0的时候
        if(rotateArray[mid] == rotateArray[left] && rotateArray[mid] == rotateArray[right]){
            return minNumberInRotateArray1(rotateArray, left, right);
        }
        if(rotateArray[mid] >= rotateArray[left]) left = mid;
        else if(rotateArray[mid] <= rotateArray[right]) right = mid;
        mid = (left + right) / 2;
        if(right - left == 1) return min(rotateArray[left], rotateArray[right]);//左元素属于递减,右元素属于递增
    }
    return rotateArray[mid];
}

int main(){
    vector<int> a = {5,1,2,3,4};
    int b = minNumberInRotateArray(a);
    cout<<b;
    return 0;
}