/*
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
*/

#include<iostream>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

ListNode* reverseList(ListNode* head) {
    if(head == NULL)return NULL;
    ListNode* pre = NULL; 
    ListNode* tmpNode = NULL;
    ListNode* current = head;
    while(current!=NULL){
        pre = current;
        current=current->next;//不要放在最后
        pre->next = tmpNode;
        tmpNode = pre;
    }
    return pre;
}

int main(){
    ListNode* a = new ListNode(1);
    ListNode* b = new ListNode(2);
    ListNode* c = new ListNode(3);
    a->next = b;
    b->next = c;
    reverseList(a);
    return 0;
}