package com.faa.leetcode.search.backtracking;

import java.util.ArrayList;
import java.util.List;

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class Binary_Tree_Paths {

    List<String> list = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");
        return list;

    }

    private String dfs(TreeNode root, String path) {
        if(root == null) return "";
        if(root.left == null && root.right == null) {
            path += root.val;
            list.add(path);
        }
        path += root.val + "->";
        if(root.left != null)
            dfs(root.left, path);
        if(root.right != null)
            dfs(root.right, path);

        return path;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);
        TreeNode l2 = new TreeNode(5);
        root.left = l1;
        root.right = r1;
        l1.left = l2;

        System.out.println(new Binary_Tree_Paths().binaryTreePaths(root));

    }

}
