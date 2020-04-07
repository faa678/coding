/*
Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Example 1:

Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true
Example 2:

Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false
Example 3:

Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

Output: false
*/

#include<iostream>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 };

bool isSameTree(TreeNode* p, TreeNode* q) {
    if((!p && q) || (p && !q))return false;
    else if(p && q){
        if(p->val != q->val)return false;
        else return isSameTree(p->left , q->left) && isSameTree(p->right , q->right);//递归
    } 
    return true;//剩下的情况都是正确的，将可能性多的作为剩下的
}
int main(){
    TreeNode* p = new TreeNode(1);
    TreeNode* pl = new TreeNode(1);
    TreeNode* pr = new TreeNode(2);
    p->left = pl;
    p->right = pr;
    TreeNode* q = new TreeNode(1);
    TreeNode* ql = new TreeNode(1);
    TreeNode* qr = new TreeNode(2);
    q->left = ql;
    q->right = qr;
    cout<<isSameTree(p , q)<<endl;
    return 0;
}