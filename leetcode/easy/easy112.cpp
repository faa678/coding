/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
*/
#include<iostream>
#include<stack>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

bool isLeaf(TreeNode* treeNode){
    if(!treeNode->left && !treeNode->right)return true;
    return false;
}

bool hasPathSum(TreeNode* root, int sum) {
    if(!root)return false;
    stack<TreeNode*> nodeStack;
    TreeNode* currentNode = root;
    int rtl = currentNode->val;
    if(rtl == sum && isLeaf(currentNode))return true;//如果只有一个节点并且等于sum,返回true
    nodeStack.push(currentNode);
    while(currentNode){//先序遍历
        if(currentNode->left){
            rtl+=currentNode->left->val;
            if(rtl == sum && isLeaf(currentNode->left)){//如果和等于sum并且是叶子节点，返回true
                return true;
            }
            else if(rtl != sum && isLeaf(currentNode->left)){//如果和不等于sum并且是叶子节点
                rtl -= currentNode->left->val;//更新rtl
                currentNode->left = NULL;//将此叶子节点删除
            }
            else{
                currentNode = currentNode->left;
                nodeStack.push(currentNode);//进栈
            }
        } 
        else if(currentNode->right){
            rtl+=currentNode->right->val;
            if(rtl == sum && isLeaf(currentNode->right)){
                return true;
            }
            else if(rtl != sum && isLeaf(currentNode->right)){
                rtl -= currentNode->right->val;
                currentNode->right = NULL;
            }
            else{
                currentNode = currentNode->right;
                nodeStack.push(currentNode);
            }
        }
        else{
            rtl -= nodeStack.top()->val;//连续两层的两个没有用的节点，上面那层的不好删除，先把值转成范围较大的值，第二轮删
            nodeStack.top()->val = 99999;
            nodeStack.pop();
            if(nodeStack.size() == 0)return false;//删到最后没有节点，返回false
            else currentNode = nodeStack.top();//作为当前节点
        } 
    }
    return false;        
}
/*
bool hasPathSum(TreeNode* root, int sum) {

    if(root == NULL) {
		return false;
	}
    
    bool left = false, right = false;
    sum -= root->val;
    
    
    if(root->left != NULL){
        left = hasPathSum(root->left, sum);
    }
    if(root->right != NULL){
        right = hasPathSum(root->right, sum);
    }
    if(root->left == NULL && root->right == NULL){
        if(sum == 0) return true;
    }
    
    if(left || right){
        return true;
    }
    else{
        return false;
    }
}

*/
int main(){
    TreeNode* root = new TreeNode(1);
    TreeNode* third = new TreeNode(3);
    root->right = third;
    cout<<hasPathSum(root,3);
    return 0;
}

