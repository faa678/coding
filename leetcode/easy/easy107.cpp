/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
*/
#include<iostream>
#include<vector>
#include<queue>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

vector<vector<int> > levelOrderBottom(TreeNode* root) {
    vector<vector<int> > a;
    TreeNode* currentNode;
    queue<TreeNode*> treeNodeQueue;
    int curLevelSize = 0;
    //和上一题一样用层次遍历，再倒置
    //不知道哪儿出错，vector里多加了一个空[]
    if(root){
        treeNodeQueue.push(root);
        vector<int> rootVal;
        rootVal.push_back(root->val);
        a.push_back(rootVal);
        while(!treeNodeQueue.empty()){
            vector<int> currentLevel;
            curLevelSize = treeNodeQueue.size();
            int count = 0;
            while(count < curLevelSize){//判断当前层是否遍历结束
                currentNode = treeNodeQueue.front();
                treeNodeQueue.pop();
                if(currentNode->left){
                    treeNodeQueue.push(currentNode->left);
                    currentLevel.push_back(currentNode->left->val);
                }
                if(currentNode->right){
                    treeNodeQueue.push(currentNode->right);
                    currentLevel.push_back(currentNode->right->val);
                }
                count++;
            }
            a.push_back(currentLevel);
        }
    }
    vector<vector<int> > b;
    if(a.size()>0)
    for(int i = a.size()-1; i--; i>=0){
        b.push_back(a[i]);
    }
    return b;
}

int main(){
    TreeNode* root = new TreeNode(1);
    TreeNode* third = new TreeNode(3);
    root->right = third;
    for(int i = 0; i < levelOrderBottom(root).size(); i++){
        for(int j = 0; j < levelOrderBottom(root)[i].size(); j++){
            cout<<levelOrderBottom(root)[i][j]<<" ";
        }
    }
    return 0;
}