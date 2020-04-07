/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:

Input: "cbbd"
Output: "bb"
*/

#include<iostream>
using namespace std;

// bool isPalindrome(string str){  //judge if a certain string is palindromic 
//     int len = str.size();
//     for(int i = 0, j = len - 1; i < j; i++, j--){
//         if(str[i] ^ str[j] != 0) return false;
//     }
//     return true;
// }

string longestPalindrome(string s) {
    if(s.size() == 0) return "";
    int len = s.size(), maxlen = 0, max_start = 0, max_end = 0;
    string maxstr = "";
    for(int start = 0; start < len; start++){   //from the start, and increment the start
        int i = start, j = len - 1; 
        while(j >= i){
            if(maxlen > (j - i + 1)) break; //get rid of needless comparision
            if(s[i] == s[j]){   // find the char same as starting char from the end
                bool isPalindrome = true;
                for(int m = i, n = j; m < n; m++, n--){ //  move inside the function to judge idf the centain string is palindromic
                    if(s[m] != s[n]) isPalindrome = false;
                }
                string str = s.substr(i, j - i + 1);
                if(isPalindrome && (j - i + 1) > maxlen){  //judge if the substring is palindomic
                    maxlen = j - i + 1;
                    max_start = i;  //just return the index of the substring which is palindromic in s
                    max_end = j;
                    //maxstr = str; 
                    break;  // if it is, it must be the longest palindromic substring with the current starting char
                }
                else{   //if it is not palindromic, find the next ending char same as the starting char
                    j--;
                }
            }
            else{   //find the ending char same as the starting char
                j--;
            }
            
        }
    }
    maxstr = s.substr(max_start, max_end - max_start + 1);
    return maxstr;
}

int main(){
    string s = "aaabaaaa";
    longestPalindrome(s);
    cout << "longest palindromic substring is: " << longestPalindrome(s) << endl; 
}