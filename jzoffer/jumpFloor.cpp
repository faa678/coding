#include<iostream>
#include<map>
using namespace std;

//递归
map<int, int> jumpMap;
int jumpFloor(int number) {
    if(number == 1) return 1;
    else if(number == 2) return 2;
    if(jumpMap.count(number) == 0) jumpMap.insert(pair<int, int>(number, jumpFloor(number - 1) + jumpFloor(number - 2)));
    return jumpMap[number];
}

//动态规划
int jumpFloor2(int number){
    //if(number == 0) return 1;
    int pre = 1, cur = 1;
    while(number--){
        cur += pre;
        pre = cur - pre;
    }
    return pre;
}

int main(){
    cout<<jumpFloor(5)<<" ";
    cout<<jumpFloor2(5);
    return 0;
}