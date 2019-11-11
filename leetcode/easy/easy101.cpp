/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
*/
#include<iostream>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

bool isTwoSymmetric(TreeNode* p , TreeNode* q){
    if((!p && q) || (p && !q))return false;
    else if(p && q){
        if(p->val != q->val)return false;
        else return isTwoSymmetric(p->left , q->right) && isTwoSymmetric(p->right , q->left);//递归
    } 
    return true;
}

bool isSymmetric(TreeNode* root) {//可以转化成上一题求两棵树是否相同的问题(左右子树对称，不是相同)
    if(!root) return true;
    else return isTwoSymmetric(root->left , root->right);
    return false;        
}

int main(){
    TreeNode* r = new TreeNode(1);
    TreeNode* rl = new TreeNode(1);
    TreeNode* rr = new TreeNode(2);
    r->left = rl;
    r->right = rr;
    cout<<isSymmetric(r)<<endl;
    return 0;
}