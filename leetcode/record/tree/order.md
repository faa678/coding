#### [144. 二叉树的前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/)

<font color=green>`简单`</font>

给你二叉树的根节点 `root` ，返回它节点值的 **前序** 遍历。

 

**示例 1：**

<img src="https://assets.leetcode.com/uploads/2020/09/15/inorder_1.jpg" alt="img" style="zoom:67%;" />

```
输入：root = [1,null,2,3]
输出：[1,2,3]
```

**示例 2：**

```
输入：root = []
输出：[]
```

**示例 3：**

```
输入：root = [1]
输出：[1]
```

**示例 4：**

<img src="https://assets.leetcode.com/uploads/2020/09/15/inorder_5.jpg" alt="img" style="zoom:67%;" />

```
输入：root = [1,2]
输出：[1,2]
```

**示例 5：**

<img src="https://assets.leetcode.com/uploads/2020/09/15/inorder_4.jpg" alt="img" style="zoom:67%;" />

```
输入：root = [1,null,2]
输出：[1,2]
```

 

**提示：**

- 树中节点数目在范围 `[0, 100]` 内
- `-100 <= Node.val <= 100`

 

**进阶：**递归算法很简单，你可以通过迭代算法完成吗？

**递归思路：**
1. 前序遍历，中左右
2. 递归

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private List<Integer> preList = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return preList;
        preList.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return preList;
    }
}
```

**迭代思路：**
1. 前序遍历，中左右
2. 需要记录前驱节点
3. 需要记录节点是否被访问过

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private List<Integer> list = new ArrayList<>();
    private List<TreeNode> preNodeList = new ArrayList<>();
    private Set<TreeNode> vSet = new HashSet<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return list;
        preNodeList.add(root); // add null, size = 1
        while(preNodeList.size() != 0) {
            TreeNode pre = preNodeList.get(preNodeList.size() - 1);
            if(!vSet.contains(pre)) {
                list.add(pre.val);
                vSet.add(pre);
            }
            if(pre.left != null && !vSet.contains(pre.left)) {
                preNodeList.add(pre.left);
                continue;
            }
            if(pre.right != null && !vSet.contains(pre.right)) {
                preNodeList.add(pre.right);
                continue;
            }
            preNodeList.remove(preNodeList.size() - 1);
        }
        return list;
    }
}
```





#### [145. 二叉树的后序遍历](https://leetcode-cn.com/problems/binary-tree-postorder-traversal/)

<font color=green>`简单`</font>

给定一个二叉树，返回它的 *后序* 遍历。

**示例:**

```
输入: [1,null,2,3]  
   1
    \
     2
    /
   3 

输出: [3,2,1]
```

**进阶:** 递归算法很简单，你可以通过迭代算法完成吗？

**递归思路：**
1. 后序遍历，左右中
2. 递归

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private List<Integer> list = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return list;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
        return list;
    }
}
```

**迭代思路：**
1. 需要记录访问过的节点
2. 需要记录前驱的节点列表
3. 后序遍历，左右中

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        List<TreeNode> preList = new ArrayList<>();
        Set<TreeNode> vSet = new HashSet<>();
        preList.add(root);
        while(preList.size() != 0) {
            TreeNode cur = preList.get(preList.size() - 1);
            while(cur.left != null || cur.right != null) {
                if(cur.left != null && !vSet.contains(cur.left)) {
                    preList.add(cur.left);
                    cur = cur.left;
                    continue;
                }
                if(cur.right != null && !vSet.contains(cur.right)) {
                    preList.add(cur.right);
                    cur = cur.right;
                    continue;
                }
                break; // 如果进了while但是进不了if死循环
            }
            TreeNode v = preList.get(preList.size() - 1);
            list.add(v.val);
            vSet.add(v);
            preList.remove(preList.size() - 1);
        }
        return list;
    }
}
```



#### [94. 二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)

<font color=green>`简单`</font>

给定一个二叉树的根节点 `root` ，返回它的 **中序** 遍历。

 

**示例 1：**

![img](https://assets.leetcode.com/uploads/2020/09/15/inorder_1.jpg)

```
输入：root = [1,null,2,3]
输出：[1,3,2]
```

**示例 2：**

```
输入：root = []
输出：[]
```

**示例 3：**

```
输入：root = [1]
输出：[1]
```

**示例 4：**

![img](https://assets.leetcode.com/uploads/2020/09/15/inorder_5.jpg)

```
输入：root = [1,2]
输出：[2,1]
```

**示例 5：**

![img](https://assets.leetcode.com/uploads/2020/09/15/inorder_4.jpg)

```
输入：root = [1,null,2]
输出：[1,2]
```

 

**提示：**

- 树中节点数目在范围 `[0, 100]` 内
- `-100 <= Node.val <= 100`

**递归思路：**
1. 中序遍历，左中右
2. 递归

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return list;
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }
}
```

**迭代思路：**

1. 中序遍历，左中右
2. 需要记录父节点
3. 需要记访问过的节点

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        List<TreeNode> preList = new ArrayList<>();
        Set<TreeNode> vSet = new HashSet<>();
        preList.add(root);
        while(preList.size() != 0) {
            TreeNode cur = preList.get(preList.size() - 1);
            while(cur.left != null && !vSet.contains(cur.left)) {
                cur = cur.left;
                preList.add(cur);
            }
            list.add(cur.val);
            vSet.add(cur);
            preList.remove(preList.size() - 1);
            if(cur.right != null && !vSet.contains(cur.right)) {
                cur = cur.right;
                preList.add(cur);
            }
        }
        return list;
    }
}
```

