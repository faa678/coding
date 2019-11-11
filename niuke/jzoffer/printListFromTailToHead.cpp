#include<iostream>
#include<vector>
using namespace std;

struct ListNode {
    int val;
    struct ListNode *next;
    ListNode(int x) :
        val(x), next(NULL) {
    }
};

/**
vector<int> result;
vector<int> printListFromTailToHead(ListNode* head) {
    //使用递归
    if(head){
        printListFromTailToHead(head->next);
        result.push_back(head->val);
    }
    return result;
}
**/

/**

**/