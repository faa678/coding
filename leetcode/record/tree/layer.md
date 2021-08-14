#### [637. 二叉树的层平均值](https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/)

<font color=green>`简单`</font>

给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。

 

**示例 1：**

```
输入：
    3
   / \
  9  20
    /  \
   15   7
输出：[3, 14.5, 11]
解释：
第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
```

 

**提示：**

- 节点值的范围在32位有符号整数范围内。

**思路：**
1. 需要分层获取节点，层次遍历
2. 需要记录每一层，可以使用两个链表记当前层和下一层

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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ret = new ArrayList<>();
        if(root == null) return ret;
        List<TreeNode> curLevel = new ArrayList<>();
        List<TreeNode> nextLevel = new ArrayList<>();
        curLevel.add(root);
        while(curLevel.size() + nextLevel.size() != 0) {
            int len = curLevel.size();
            double tmp = 0;
            while(curLevel.size() != 0) {
                TreeNode curNode = curLevel.get(curLevel.size() - 1);
                tmp += curNode.val;
                curLevel.remove(curLevel.size() - 1);
                addChild(nextLevel, curNode);
            }
            ret.add(tmp / len);
            if(nextLevel.size() != 0) {
                List<TreeNode> tmpLevel = curLevel;
                curLevel = nextLevel;
                nextLevel = tmpLevel;
            }
        }
        return ret;
    }
    private void addChild(List<TreeNode> nextLevel, TreeNode root) {
        if(root.left != null) nextLevel.add(root.left);
        if(root.right != null) nextLevel.add(root.right);
    }
}
```



#### [513. 找树左下角的值](https://leetcode-cn.com/problems/find-bottom-left-tree-value/)

<font color=orange>`中等`</font>

给定一个二叉树的 **根节点** `root`，请找出该二叉树的 **最底层 最左边** 节点的值。

假设二叉树中至少有一个节点。

 

**示例 1:**

![img](https://assets.leetcode.com/uploads/2020/12/14/tree1.jpg)

```
输入: root = [2,1,3]
输出: 1
```

**示例 2:**

![img](https://assets.leetcode.com/uploads/2020/12/14/tree2.jpg)

```
输入: [1,2,3,4,null,5,6,null,null,7]
输出: 7
```

 

**提示:**

- 二叉树的节点个数的范围是 `[1,104]`
- `-231 <= Node.val <= 231 - 1` 

**思路：**
1. 需要找到最底层的最左边的节点，层次遍历
2. 最底层通过保存每节点的列表是否为空判断
3. 最左边通过从右向左加入链表取尾元素

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
    public int findBottomLeftValue(TreeNode root) {
        LinkedList<TreeNode> curLevel = new LinkedList<>();
        LinkedList<TreeNode> nextLevel = new LinkedList<>();
        curLevel.add(root);
        int bottomLeft = 0;
        while(curLevel.size() + nextLevel.size() != 0) {
            while(curLevel.size() != 0) {
                addChild(nextLevel, curLevel.getLast());
                bottomLeft = curLevel.getLast().val;
                curLevel.removeLast();
            }
            if(nextLevel.size() != 0) {
                LinkedList<TreeNode> tmp = curLevel;
                curLevel = nextLevel;
                nextLevel = tmp;
            }
        }
        return bottomLeft;
    }
    private void addChild(LinkedList<TreeNode> nextLevel, TreeNode root) {
        // 注意存放子节点的顺序
        if(root.right != null) nextLevel.addFirst(root.right);
        if(root.left != null) nextLevel.addFirst(root.left);
    }
}
```

