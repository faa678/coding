#include<iostream>
#include<cstring>
using namespace std;

void replaceSpace(char *str,int length) {
    int result_len = length;
    for(int i = 0; i < length; i++){
        if(str[i] == ' ') result_len += 2;
    }
    char *s = new char[result_len];
    for(int i = 0, j = 0; i < length, j < result_len; i++, j++){
        if(str[i] == ' '){
            s[j] = '\%';
            s[++j] = '2';
            s[++j] = '0';
        }
        else s[j] = str[i];
    }
    strcpy(str, s);
}

int main(){
    char *s = "hello world";
    replaceSpace(s, 11);
    cout<<s;
    return 0;
}