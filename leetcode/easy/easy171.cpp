/*

*/

#include<iostream>
#include<math.h>
#include<map>
using namespace std;

/**
map<char, int> titleMap;
int titleToNumber(string s) {
    for(int i = 0; i < 26; i++){
        titleMap.insert(pair<char, int>(65 + i, i + 1));//字母和数字对应
    }
    int len = s.length();
    int result = 0;
    for(int l = len - 1; l >= 0; l--){//从最后一个字母开始算
        result += titleMap[s[l]] * pow(26, len - l - 1);//加的是当前位代表的数字×几个26
    }
    return result;
}
**/

//用map太慢了
map<char, int> titleMap;
int titleToNumber(string s) {
   
    int len = s.length();
    int result = 0;
    for(int l = len - 1; l >= 0; l--){//从最后一个字母开始算
        result += int(s[l]-'A'+1) * pow(26, len - l - 1);//加的是当前位代表的数字×几个26
    }
    return result;
}

int main(){
    cout<<titleToNumber("ZY");
    return 0;
}