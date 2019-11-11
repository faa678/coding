#include<iostream>
#include<stack>
using namespace std;

class Solution
{
public:
    void push(int node) {
        stack1.push(node);
    }

    int pop() {
        if(stack2.empty()){//stack2为空时pop,将satck1元素pop并push到stack2中,始终从stack2中pop作pop结果,顺序和stack1相反
            while(!stack1.empty()){//不知道为什么使用while(stack1.top())不对
                stack2.push(stack1.top());
                stack1.pop();
            }
        }
        int pop_ele = stack2.top();
        stack2.pop();
        return pop_ele;
    }

private:
    stack<int> stack1;
    stack<int> stack2;
};