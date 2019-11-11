#include<iostream>
#include<vector>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

TreeNode* reConstructBinaryTree(vector<int> pre,vector<int> vin) {
    if(pre.size() == 0)return NULL;
    TreeNode* root = new TreeNode(pre[0]);
    int len = pre.size(), root_pos = 0;
    for(int i = 0; i < len; i++){
        if(vin[i] == pre[0]){
            root_pos = i;
            break;
        }
    }
    vector<int> left_pre, left_in, right_pre, right_in;
    for(int i = 0; i < root_pos; i++){
        left_pre.emplace_back(pre[i + 1]);
        left_in.emplace_back(vin[i]);
    }
    for(int i = root_pos + 1; i < len; i++){
        right_pre.emplace_back(pre[i]);
        right_in.emplace_back(vin[i]);
    }
    root->left = reConstructBinaryTree(left_pre, left_in);
    root->right = reConstructBinaryTree(right_pre, right_in);
    return root;
}

int main(){
    return 0;
}