#include<iostream>
using namespace std;

int  NumberOf1(int n) {//负数用补码，最高位是1
    int result = 0;
    //用与运算的临时值左移
    int flag = 1;
    while(flag != 0){
        if((n & flag) != 0)result++;//(n & flag)加括号，按位与$的优先级小于!=
        flag = flag << 1;
    }
    return result;
}

int main(){
    cout<<NumberOf1(45);
    return 0;
}