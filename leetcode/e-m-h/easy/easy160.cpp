/*
Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:


begin to intersect at node c1.

 

Example 1:


Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
Output: Reference of the node with value = 8
Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). 
From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the intersected node in A; 
There are 3 nodes before the intersected node in B.
*/

#include<iostream>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
    ListNode *curA = headA, *curB = headB;
    while(curA && curB){
        curA = curA->next;
        curB = curB->next;
    }
    while(curA){
        headA = headA->next;
        curA = curA->next;
    }
    while(curB){
        headB = headB->next;
        curB = curB->next;
    }
    while(headA){
        if(headA == headB){
            return headA;
        }
        headA = headA->next;
        headB = headB->next;
    }
    return NULL;
}