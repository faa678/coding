/*
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.


The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

 

Example:

Input: [1,8,6,2,5,4,8,3,7]
Output: 49
*/

#include<iostream>
#include<vector>
using namespace std;

int maxArea(vector<int>& height) {
    int len = height.size();
    int maxarea = 0;

    int i = 0, j = len - 1;
    while(i < j){
        int area = min(height[i], height[j]) * (j - i);
        maxarea = maxarea > area ? maxarea : area;//高变大了但是间距变小了，所以比较面积是否变大
        if(height[i] >= height[j]) j--;//尽量找值大的高
        else i++;
    }

    //暴力不可取
    // for(int i = 0; i < len - 1; i++){
    //     for(int j = i + 1; j < len; j++){
    //         int area = min(height[i], height[j]) * (j - i);
    //         maxarea = maxarea >= area ? maxarea : area;
    //     }
    // }
    return maxarea;
}

int main(){
    return 0;
}