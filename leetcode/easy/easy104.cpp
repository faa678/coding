/*
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.
*/
#include<iostream>
#include<queue>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

int depth = 0;


//使用层次遍历，记录层数
//借助队列，按顺序出队按层次遍历
queue<TreeNode*> treenodequeue;
TreeNode* currentNode;
int curLevelSize = 0;
int maxDepth(TreeNode* root){
    if(root){
        treenodequeue.push(root);
        curLevelSize = treenodequeue.size();//记录每层的节点数
    
        while(!treenodequeue.empty()){
            curLevelSize = treenodequeue.size();
            int count = 0;
            while(count < curLevelSize){
                currentNode = treenodequeue.front();
                treenodequeue.pop();
                if(currentNode->left){
                    treenodequeue.push(currentNode->left);
                }
                if(currentNode->right){
                    treenodequeue.push(currentNode->right);
                }
                
                count++;
            }
            depth++;
            
        }
    }
    return depth;
}

/*int maxDepth(TreeNode* root) {
    if(root){
        return depth + (maxDepth(root->left) > maxDepth(root->right) ? maxDepth(root->left) : maxDepth(root->right)) + 1;//递归时间复杂度太高
    }
    return depth;        
}*/

int main(){
    TreeNode* root = new TreeNode(1);
    TreeNode* third = new TreeNode(3);
    root->right = third;
    cout<<maxDepth(root);
    return 0;
}