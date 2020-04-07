/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
*/

#include<iostream>
using namespace std;

bool isPalindrome(string s) {
    if(s == "")return true;
    string a, b = "";
    int length = s.length();
    for(int i = 0; i < length; i++){
        if(s[i] >= 65 && s[i] <= 90){
            a += (s[i] + 32);
        }
        else if((s[i] >= 97 && s[i] <= 122) || (s[i] >=48 && s[i] <= 57)){
            a += s[i];
        }
    }
    int len = a.length() - 1;
    int i = 0;
    bool isTrue = true;
    while(len >= 0){
        isTrue = isTrue && (a[i] == a[len]);
        len--;
        i++;
    }
    return isTrue;        
}

int main(){
    return 0;
}