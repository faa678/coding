#include<iostream>
using namespace std;


int rectCover(int number) {
    if(number <= 2)return number;
    else{
        return rectCover(number - 1) + rectCover(number - 2);
    }
    //return result;
}

int main(){
    cout<<rectCover(6);
    return 0;
}