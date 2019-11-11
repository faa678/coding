/*
Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 3
Output: [1,3,3,1]
Follow up:

Could you optimize your algorithm to use only O(k) extra space?
*/

#include<iostream>
#include<vector>
using namespace std;

vector<int> getRow(int rowIndex) {
    vector<int> row;
    vector<int> preRow = {1, 1};//多于两行使用的辅助vector（上一行）
    if(rowIndex <= 1){//前两行直接赋值
        while(rowIndex >= 0){
            row.push_back(1);
            rowIndex--;
        }
    }
    else{
        int curRowIndex = 2;//当前是第几行，从0开始
        while(curRowIndex <= rowIndex){
            row = {};
            row.push_back(1);//首位元素
            for(int i = 1; i < curRowIndex; i++){
                row.push_back(preRow[i - 1] + preRow[i]);
            }
            row.push_back(1);//末位元素
            preRow = row;
            curRowIndex++;
        }
    }
    return row; 
}

int main(){
    getRow(2);
    return 0;
}