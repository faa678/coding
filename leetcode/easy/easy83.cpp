/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2
Example 2:

Input: 1->1->2->3->3
Output: 1->2->3
*/
#include<iostream>
using namespace std;
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
 };
ListNode* deleteDuplicates(ListNode* head) {
    if(!head)return NULL;
    else{
        ListNode* currentNode = head;//设置一个当前节点和下一个节点的标志为
        ListNode* nextNode = currentNode->next;
        while(currentNode->next){
            if(currentNode->val == nextNode->val){
                if(nextNode->next){
                    nextNode = nextNode->next;//如果当前节点的值和后继节点的值相同，继续向后找
                }
                else
                {
                    currentNode->next = NULL;//找到链尾
                }
                
            }
            else{
                currentNode->next = nextNode;//值不相同，当前节点的后继指向此节点
                currentNode=nextNode;
            }
        }
        return head;  
    }        
}
int main(){
    ListNode* head = new ListNode(1);//链表的声明
    ListNode* second = new ListNode(1);
    ListNode* third = new ListNode(2);
    head->next=second;
    second->next=third;
    third->next=NULL;
    ListNode* test = deleteDuplicates(head);
    while(test){
        if(test->next){
            cout<<test->val<<"-";
        }
        else{
            cout<<test->val<<endl;
        }
        test=test->next;
    }
    return 0;
}

//答案
/*
    public ListNode deleteDuplicates(ListNode head) {
    ListNode current = head;
    while (current != null && current.next != null) {
        if (current.next.val == current.val) {
            current.next = current.next.next;
        } else {
            current = current.next;
        }
    }
    return head;
}
*/