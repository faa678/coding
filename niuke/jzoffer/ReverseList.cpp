#include<iostream>
using namespace std;

struct ListNode {
	int val;
	struct ListNode *next;
	ListNode(int x) :
			val(x), next(NULL) {
	}
};

ListNode* ReverseList(ListNode* pHead) {
    ListNode* outNode = NULL;//当前头结点取出
    ListNode* tmpNode = NULL;//借用临时节点
    while(pHead){
        outNode = pHead;//取出头结点
        pHead = pHead->next;//原链的新头结点
        outNode->next = tmpNode;//将取出的头结点的next指针指向tmpNode,tmpNode初始为NULL
        tmpNode = outNode;//将tmpNode指向取出的头结点,也是新链的链头
    }
    return outNode;
}

int main(){
    ListNode* a = new ListNode(1);
    ListNode* b = new ListNode(2);
    ListNode* c = new ListNode(3);
    a->next = b;
    b->next = c;
    ReverseList(a);
    return 0;
}