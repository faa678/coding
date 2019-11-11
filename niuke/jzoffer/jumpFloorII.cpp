#include<iostream>
using namespace std;

//主要是找关系
//逆向思维来考虑这个问题。要想跳到第n级台阶，就可以从第n-1级、第n-2级、***、第1级 跳到第n级，再加上直接从地面到第n级的一种情况。

//使用循环
int jumpFloorII(int number) {
    int *result = new int[number]{0};
    for(int i = 0; i < number; i++){
        for(int j = 0; j < i; j++){
            result[i] += result[j];
        }
        result[i] += 1;
    }
    return result[number - 1];
}

//使用递归
int jumpFloorIII(int number) {
    int result = 1;
    if(number <= 2)return number;
    else{
        while(number > 0){
            result += jumpFloorIII(number - 1);
            number--;
        }
        return result;
    }
}

//使用动态规划
int jumpFloorIV(int number) {//f(n) = 2 * f(n - 1)
    int result = 1;
    if(number == 1)result = 1;
    else{
        for(int i = 1; i < number; i++){
            result *= 2;
        }
    }
    return result;
}

int main(){
    cout<<jumpFloorII(5);
    cout<<jumpFloorIII(5);
    cout<<jumpFloorIV(5);
    return 0;
}