/*
Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/

#include<iostream>
#include<vector>
using namespace std;

vector<vector<int> > generate(int numRows) {
    if(numRows == 0)return {};//0行，返回空
    vector<vector<int> > triangle;
    int a[1] = {1};
    int b[2] = {1 , 1};
    vector<int> a_v(a , a + 1);
    triangle.push_back(a_v);//初始化一行
    if(numRows == 1)return triangle;//numRows == 1，返回
    vector<int> b_v(b , b + 2);//初始化两行
    triangle.push_back(b_v);
    for(int i = 2; i < numRows; i++){//从第三行开始算
        int *nums = new int[i + 1];//i从0开始
        nums[0] = 1;nums[i] = 1;//每行的首元素和末元素
        for(int j = 1; j < i; j++){
            nums[j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
        }
        vector<int> all(nums , nums + i + 1);
        triangle.push_back(all);
    }
    return triangle;
}

int main(){
    generate(5);
    return 0;
}