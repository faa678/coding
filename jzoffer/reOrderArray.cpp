#include<iostream>
#include<vector>
#include<queue>
using namespace std;

void reOrderArray(vector<int> &array) {
    //顺序变了
/*    int forward = 0, backward = array.size() - 1;
    while(forward < backward){
        if(array[forward] % 2 == 0 && array[backward] % 2 == 1){
            swap(array[forward], array[backward]);
            forward++;
            backward--;
        }
        else if(array[backward] % 2 == 1)forward++;
        else if(array[forward] % 2 == 0)backward--;
        else{
            forward++;
            backward--;
        }
    }
*/
    queue<int> orderQueue;
    int len = array.size();
    for(int i = 0; i < len; i++){
        if(array[i] % 2 == 1)orderQueue.push(array[i]);
    }
    for(int i = 0; i < len; i++){
        if(array[i] % 2 == 0)orderQueue.push(array[i]);
    }
    for(int i = 0; i < len; i++){
        array[i] = orderQueue.front();
        orderQueue.pop();
    }
}

int main(){
    return 0;
}