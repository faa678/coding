package com.faa.coding.jzoffer;

/**
 * @author ：faa
 * @description：TODO
 * @date ：2020/6/3 13:30
 */

public class JZ17_HasSubtree {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root2 == null) return false;
            if(root1.val == root2.val) {
                if (isEqual(root1, root2))
                    return true;
            }
            return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);

    }

    private boolean isEqual(TreeNode root1, TreeNode root2) {
        if(root2 == null) return true;
        if(root1 == null) return false;
        if(root1.val != root2.val)
            return false;
        boolean t = isEqual(root1.left, root2.left) && isEqual(root1.right, root2.right);

        return t;
    }

}
