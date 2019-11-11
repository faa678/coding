/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
*/
#include<iostream>
#include<vector>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 };

int b[] = {1,2,3,4,5,6,7};
vector<int> a(b , b + 7);//是7不是6

TreeNode *binarySearch(vector<int>& a, int start, int end){//a的声明使用引用，不然时间和内存爆炸
    TreeNode *cur;
    if(start>=0 && end < a.size() && start <= end){
        int mid = (start+end)/2;
        cur = new TreeNode(a[mid]);
        cur->left = binarySearch(a,start,mid-1);
        cur->right = binarySearch(a,mid+1,end);
    }
    return cur;
}


TreeNode* sortedArrayToBST(vector<int>& nums) {//用递归，二分查找（每棵子树都是左<中<右）
    TreeNode *root = binarySearch(nums,0,nums.size()-1);
    return root;        
}

int main(){
    binarySearch(a, 0, 6);
    return 0;
}