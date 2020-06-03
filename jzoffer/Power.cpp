#include<iostream>
using namespace std;

double Power(double base, int exponent) {
    double result = 1;
    //if(exponent == 0)return 1;
    while(exponent > 0){
        result *= base;
        exponent--;
    }
    while(exponent < 0){
        result *= (1 / base);
        exponent++;
    }
    return result;
}

int main(){
    cout<<Power(1.5, 2);
    return 0;
}