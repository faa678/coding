#include<iostream>
#include<map>
using namespace std;

map<int, int> fib;

int Fibonacci(int n) {
    if(n <= 0) return 0;//不加此句，输入负数会无限递归
    if(n == 1 || n == 2) return 1;
    if(fib.count(n) > 0) return fib[n];
    else {
        fib.insert(pair<int, int>(n, Fibonacci(n - 1) + Fibonacci(n - 2)));//占内存大
    }
    return fib[n];
}

/*
int Fibonacci(int n) {
    if(n <= 0) return 0;//不加此句，输入负数会无限递归
    if(n == 1 || n == 2) return 1;
    else return Fibonacci(n - 1) + Fibonacci(n - 2);
}
*/
//动态规划
int Fibonacci2(int n) {// 1 1 2 3 5 8
    int pre = 0, cur = 1;
    while(n--){
        cur += pre;
        pre = cur - pre;
    }
    return pre;
}

int main(){
    cout<<Fibonacci(5)<<" "<<Fibonacci2(5);
    return 0;
}