/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
*/
#include<iostream>
#include<algorithm>
#include<iterator>
#include<limits.h>
#include<map>
#include<vector>
using namespace std;
class MinStack{
/**
    //使用vector实现stack，使用map存储栈中值的个数，pop时，map中对应元素的value减1，到零是删除此元素，最后找的map键最小的元素取键即为最小值
    public:
        vector<int> s;
        map<int, int> minMap;
        int min_ele;
        MinStack() {}

        void push(int x) {
            if(s.size() == 0){
                s.push_back(x);
                min_ele = x;
                minMap.insert(pair<int, int>(x , 1));
            }
            else{
                s.push_back(x);
                if(x < min_ele){
                    min_ele = x;
                    minMap.insert(pair<int, int>(x , 1));
                }
                else if(x == min_ele){
                    int value = minMap[x];
                    minMap[x] = ++value;
                }
                else{
                   map<int, int>::iterator iter = minMap.find(x);//迭代器法查找元素
                   if(iter != minMap.end()){
                       int value = iter->second;
                       minMap[x] = ++value;
                   }
                   else minMap.insert(pair<int, int>(x , 1));
                }
            }          
        }

        void pop() {
            int topVal = s[s.size() - 1];
            int value = minMap[topVal];
            value == 1 ? minMap.erase(topVal) : minMap[topVal] = --value;
            s.pop_back();
        }

        int top() {
            int len = s.size();
            return s[len - 1];
        }

        int getMin() {
            map<int, int>::iterator it=minMap.begin();//自动排序
		    return it->first;
        }

**/

//求最小值时不用排序..............mmp
        vector<int> s;
        int min_ele;
        MinStack() {
        
        }

        void push(int x) {
            s.push_back(x);
        }

        void pop() {
            s.pop_back();
        }

        int top() {
            int size = s.size();
            return s[size - 1];
        }

        int getMin() {
            min_ele = INT_MAX;
            for(int i = 0; i < s.size(); i++){
                if(s[i] < min_ele){
                    min_ele = s[i];
                }
            }
            return min_ele;
        }
};
int main(){
    int a[] = {1,2,3,1,2,3,4};
    vector<int> b(a,a+7);
    cout<<b.size();
    b.pop_back();
    cout<<endl;
    cout<<b.size();
}