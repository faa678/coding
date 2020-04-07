/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    ...
Example 1:

Input: 1
Output: "A"
Example 2:

Input: 28
Output: "AB"
Example 3:

Input: 701
Output: "ZY"
*/
#include<iostream>
#include<map>
#include<vector>
using namespace std;

map<int, char> numMap;

char s = 65;
string convertToTitle(int n) {
    for(int i = 0;i < 26; i++){
        numMap.insert(pair<int, char>(i + 1, 65 + i));
    }
    string result = "";
    int last = 0;
    int pre = 0;
    while(n > 0){
        pre = n / 26;
        last = n % 26;
        if(last == 0){//如果余数得0，从商借一位，余数变Z
            pre--;
            last = 26;
        }
        n = pre;//循环求每一个余数
        result += numMap[last];//余数求值
    }
    string s(result.rbegin(),result.rend());//string的反向迭代器
    return s;
}

int main(){
    //cout<<s;
    cout<<convertToTitle(701);
    return 0;
}