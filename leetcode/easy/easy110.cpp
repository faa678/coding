/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.
*/
#include<iostream>
#include<vector>
#include<math.h>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

bool is_balanced = true;
bool isBalanced(TreeNode* root) {

    return is_balanced;     
}



/*
简化递归
如果我们发现子树不平衡，则不计算具体的深度，而是直接返回-1。那么优化后的方法为：对于每一个节点，我们通过checkDepth方法递归获得左右子树的深度，如果子树是平衡的，则返回真实的深度，若不平衡，直接返回-1

bool isBalanced(TreeNode* root){
    if(checkDepth(root) == -1) return false;
    return true;
}

int checkDepth(TreeNode* root){
    if(root){
        int left = checkDepth(root->left);
        if(left == -1) return -1;
        int right = checkDepth(root->right);
        if(right == -1)return -1;
        int diff = abs(left - right);
        if(diff > 1)return -1;
        else return max(left, right) + 1;
    }
    return 0;
}
*/
/*
//递归
int treeHeight(TreeNode* root){
    if(root){
        return max((treeHeight(root->left) , treeHeight(root->right)) + 1;
    }
    return 0;
}

bool isBalanced(TreeNode* root) {
    if(root){
        if (abs(treeHeight(root->left) - treeHeight(root->right)) > 1) return false;//有一棵子树不符合要求就返回false
        return isBalanced(root->left) && isBalanced(root->right);//还要交上子树
    }
    return true;      
}
*/
int main(){
    TreeNode* root = new TreeNode(3);
    return 0;
}