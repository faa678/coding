#include<iostream>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
 };

ListNode* FindKthToTail(ListNode* pListHead, unsigned int k) {
    ListNode* pListTail = pListHead;
    if(pListHead == NULL || k<=0)return NULL;//注意各种情况
    while(k - 1 > 0 && pListTail->next){
        pListTail = pListTail->next;
        k--;
    }
    if(k > 1)return NULL;//k>链表长度的情况
    while(pListTail->next){
        pListHead = pListHead->next;
        pListTail = pListTail->next;
    }
    return pListHead;
}

int main(){
    ListNode *node1 = new ListNode(1);
    ListNode *node2 = new ListNode(2);
    ListNode *node3 = new ListNode(3);
    ListNode *node4 = new ListNode(4);
    ListNode *node5 = new ListNode(5);
    node1->next = node2;
    node2->next = node3;
    node3->next = node4;
    node4->next = node5;
    cout<<FindKthToTail(node1, 2)->val;
    return 0;
}