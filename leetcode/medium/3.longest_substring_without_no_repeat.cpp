/*
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/


#include<iostream>
#include<string>
#include<map>
using namespace std;

int lengthOfLongestSubstring(string s) {
    if (s.size() == 0) return 0;
    int strlen = s.size(), start = 0, curlen = 0, maxlen = 0;
    map<char, int> c_map;
    for(int i = 0; i < strlen; i++){
        if(c_map.count(s[i]) == 1 && c_map[s[i]] != -1){

            for(int j = start; j < c_map[s[i]]; j++){   //将之前start到当前start之间的元素清空  (baabd的情况)
                c_map[s[j]] = -1;
            }

            start = c_map[s[i]] + 1;    //更新start
            c_map[s[i]] = i;
            curlen = i - start + 1;
        }
        else{
            curlen++;
            maxlen = curlen > maxlen ? curlen : maxlen;   //maxlen 和 curlen 同步更新
            c_map[s[i]] = i;
            //c_map.insert(pair<char, int>(s[i], i)); //push_back 和 emplace_back 是 vector 添加元素的方法    //c++插入重复key会忽略后插入的
        }
    }
    return maxlen;
}

int main(){
    string s = "aabaabcbb";
    string s1 = "au";
    string s2 = "pww;ew";
    cout<<lengthOfLongestSubstring(s)<<" "<<lengthOfLongestSubstring(s1)<<" "<<lengthOfLongestSubstring(s2)<<endl;
    return 0;
}
