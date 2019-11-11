/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/


#include<iostream>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
 };

ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
    ListNode* result = l1;
    int tmp = 0;
    while(l1->next && l2->next){
        int l = l1->val + l2->val + tmp;
        l1->val = l % 10;
        tmp = l / 10;
        l1 = l1->next;
        l2 = l2->next;
    }

    int l = l1->val + l2->val + tmp;
    l1->val = l % 10;
    tmp = l / 10;

    if(l2->next){
        l1->next = l2->next;
    }

    while(l1->next){
        l1 = l1->next;
        int l = l1->val + tmp;
        l1->val = l % 10;
        tmp = l / 10;
    }


    if(tmp == 1) l1->next = new ListNode(1);
    return result;
}
int main(){
    ListNode* a = new ListNode(9);
    ListNode* b = new ListNode(1);
    ListNode* c = addTwoNumbers(a, b);
    while(c){
        cout<<c->val;
        c = c->next;
    }
    return 0;
}