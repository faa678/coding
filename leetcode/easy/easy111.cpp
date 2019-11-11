/*
111. Minimum Depth of Binary Tree

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its minimum depth = 2.
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

queue<TreeNode*> nodeQueue;
int depth = 0, curlevelSize = 0, nextlevelSize = 0, count = 0;//深度，当前层节点数，下层节点数，与当前层节点数比较的count
int minDepth(TreeNode* root) {//使用层次遍历
    if(!root)return depth;
    nodeQueue.push(root);
    curlevelSize = 1;
    depth = 1;
    while(count < curlevelSize){
        TreeNode* current = nodeQueue.front();
        nodeQueue.pop();
        count++;
        
        if(!current->left && !current->right)return depth;//遇到的第一个没有左右子树的节点，返回其高度
        if(current->left){
            nodeQueue.push(current->left);
            nextlevelSize++;
        }
        if(current->right){
            nodeQueue.push(current->right);
            nextlevelSize++;
        }
        if(count == curlevelSize){//count==当前层节点数时，说明当前层节点遍历完
            curlevelSize = nextlevelSize;//到下一层节点
            nextlevelSize = 0;
            count = 0;
            depth++;
        }
    }
    return depth;
     
}
int main(){
    TreeNode* root = new TreeNode(1);
    TreeNode* third = new TreeNode(3);
    root->right = third;
    cout << minDepth(root);
    return 0;
}