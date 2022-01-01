#### [669. 修剪二叉搜索树](https://leetcode-cn.com/problems/trim-a-binary-search-tree/)

<font color=orange>`中等`</font> <font color="red">`<需要重复做>`</font>

给你二叉搜索树的根节点 `root` ，同时给定最小边界`low` 和最大边界 `high`。通过修剪二叉搜索树，使得所有节点的值在`[low, high]`中。修剪树不应该改变保留在树中的元素的相对结构（即，如果没有被移除，原有的父代子代关系都应当保留）。 可以证明，存在唯一的答案。

所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。

 

**示例 1：**

![img](https://assets.leetcode.com/uploads/2020/09/09/trim1.jpg)

```
输入：root = [1,0,2], low = 1, high = 2
输出：[1,null,2]
```

**示例 2：**

![img](https://assets.leetcode.com/uploads/2020/09/09/trim2.jpg)

```
输入：root = [3,0,4,null,2,null,null,1], low = 1, high = 3
输出：[3,2,null,1]
```

**示例 3：**

```
输入：root = [1], low = 1, high = 2
输出：[1]
```

**示例 4：**

```
输入：root = [1,null,2], low = 1, high = 3
输出：[1,null,2]
```

**示例 5：**

```
输入：root = [1,null,2], low = 2, high = 4
输出：[2]
```

 

**提示：**

- 树中节点数在范围 `[1, 104]` 内
- `0 <= Node.val <= 104`
- 树中每个节点的值都是唯一的
- 题目数据保证输入是一棵有效的二叉搜索树
- `0 <= low <= high <= 104`

**思路：**
1. 给定的是有效的bst，说明根节点不符合条件，则其孩子也都不符合
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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) return null;
        if(root.val < low) {
            return trimBST(root.right, low, high);
        }
        else if(root.val > high) {
            return trimBST(root.left, low, high);
        }
        else {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        }
        return root;
    }
}
```



#### [230. 二叉搜索树中第K小的元素](https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/)

<font color=orange>`中等`</font>

给定一个二叉搜索树的根节点 `root` ，和一个整数 `k` ，请你设计一个算法查找其中第 `k` 个最小元素（从 1 开始计数）。

 

**示例 1：**

![img](https://assets.leetcode.com/uploads/2021/01/28/kthtree1.jpg)

```
输入：root = [3,1,4,null,2], k = 1
输出：1
```

**示例 2：**

![img](https://assets.leetcode.com/uploads/2021/01/28/kthtree2.jpg)

```
输入：root = [5,3,6,2,4,null,null,1], k = 3
输出：3
```

 

 

**提示：**

- 树中的节点数为 `n` 。
- `1 <= k <= n <= 104`
- `0 <= Node.val <= 104`

 

**进阶：**如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 `k` 小的值，你将如何优化算法？

**思路：**
1. 中序遍历
2. 记录遍历到的节点的个数
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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        List<TreeNode> preList = new ArrayList<>();
        Set<TreeNode> vSet = new HashSet<>(); // 需要记录节点是否被访问过
        preList.add(root);
        while(preList.size() != 0) {
            TreeNode cur = preList.get(preList.size() - 1);
            if(cur.left != null && !vSet.contains(cur.left)) {
                preList.add(cur.left);
                vSet.add(cur.left);
                continue;
            }
            list.add(cur.val);
            System.out.println(cur.val);
            preList.remove(preList.size() - 1);
            if(list.size() == k) {
                return list.get(k - 1);
            }
            if(cur.right != null && !vSet.contains(cur.right)) {
                preList.add(cur.right);
                vSet.add(cur.right);
            }
        }
        return 0;
    }
}
```



#### [538. 把二叉搜索树转换为累加树](https://leetcode-cn.com/problems/convert-bst-to-greater-tree/)

<font color=orange>`中等`</font><font color=red>`需要优化`</font>

给出二叉 **搜索** 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 `node` 的新值等于原树中大于或等于 `node.val` 的值之和。

提醒一下，二叉搜索树满足下列约束条件：

- 节点的左子树仅包含键 **小于** 节点键的节点。
- 节点的右子树仅包含键 **大于** 节点键的节点。
- 左右子树也必须是二叉搜索树。

**注意：**本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/ 相同

 

**示例 1：**

**![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/05/03/tree.png)**

```
输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
```

**示例 2：**

```
输入：root = [0,null,1]
输出：[1,null,1]
```

**示例 3：**

```
输入：root = [1,0,2]
输出：[3,3,2]
```

**示例 4：**

```
输入：root = [3,2,4,1]
输出：[7,9,4,10]
```

 

**提示：**

- 树中的节点数介于 `0` 和 `104` 之间。
- 每个节点的值介于 `-104` 和 `104` 之间。
- 树中的所有值 **互不相同** 。
- 给定的树为二叉搜索树。

**思路：**
1. 二叉搜索树，中序遍历序列的顺序是升序排列
2. 将升序排列写数组，进行累加操作

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
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return null;
        List<Integer> list = inOrder(root); 
        list = cal(list);
        setVal(root, list);
        return root;
    }
    private List<Integer> inOrder(TreeNode root) {
        if(root == null) return null;
        List<TreeNode> preList = new ArrayList<>();
        preList.add(root);
        List<Integer> list = new ArrayList<>();
        Set<TreeNode> vSet = new HashSet<>();
        while(preList.size() != 0) {
            TreeNode cur = preList.get(preList.size() - 1);
            if(cur.left != null && !vSet.contains(cur.left)) {
                preList.add(cur.left);
                vSet.add(cur.left);
                continue;
            }
            list.add(cur.val);
            preList.remove(preList.size() - 1);
            if(cur.right != null && !vSet.contains(cur.right)) {
                preList.add(cur.right);
                vSet.add(cur.right);
            }
        }
        return list;
    }
    private void setVal(TreeNode root, List<Integer> list) {
        if(root == null) return;
        List<TreeNode> preList = new ArrayList<>();
        preList.add(root);
        Set<TreeNode> vSet = new HashSet<>();
        int index = 0;
        while(preList.size() != 0) {
            TreeNode cur = preList.get(preList.size() - 1);
            if(cur.left != null && !vSet.contains(cur.left)) {
                preList.add(cur.left);
                vSet.add(cur.left);
                continue;
            }
            cur.val = list.get(index++);
            preList.remove(preList.size() - 1);
            if(cur.right != null && !vSet.contains(cur.right)) {
                preList.add(cur.right);
                vSet.add(cur.right);
            }
        }
    }
    private List<Integer> cal(List<Integer> list) {
        int len = list.size();
        for(int i = len - 2; i >= 0; i--) {
            int newV = list.get(i) + list.get(i + 1);
            list.set(i, newV);
        }
        return list;
    }
}
```



#### [235. 二叉搜索树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)

<font color=green>`简单`</font><font color=red>`需要优化`</font>

给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

[百度百科](https://baike.baidu.com/item/最近公共祖先/8918834?fr=aladdin)中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（**一个节点也可以是它自己的祖先**）。”

例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5]

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/binarysearchtree_improved.png)

 

**示例 1:**

```
输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
输出: 6 
解释: 节点 2 和节点 8 的最近公共祖先是 6。
```

**示例 2:**

```
输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
输出: 2
解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
```

 

**说明:**

- 所有节点的值都是唯一的。
- p、q 为不同节点且均存在于给定的二叉搜索树中。

**思路：**
1. 二叉搜索树，只要找到左右子树（当前）分别包含p和q的节点即为最近公共祖先节点
2. 递归

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > q.val) {
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        return doFind(root, p, q);
    }
    private TreeNode doFind(TreeNode root, TreeNode p, TreeNode q) {
                if(root == null) return null;
        if(root == p && ifContains(root.right, q)) {
            return root;
        }
        if(root == q && ifContains(root.left, p)) {
            return root;
        }
        if(ifContains(root.left, p) && ifContains(root.right, q)) {
            return root;
        } 
        TreeNode tmp1 = doFind(root.left, p, q);
        TreeNode tmp2 = doFind(root.right, p, q);
        return tmp1 == null ? tmp2 : tmp1;
    }
    private boolean ifContains(TreeNode child, TreeNode t) {
        if(child == null) return false;
        if(child.val < t.val) {
            return ifContains(child.right, t);
        }
        else if(child.val > t.val) {
            return ifContains(child.left, t);
        }
        return true;
    }
}
```



#### [236. 二叉树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/)

<font color=orange>`中等`</font><font color=red>`需要优化`</font>

给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

[百度百科](https://baike.baidu.com/item/最近公共祖先/8918834?fr=aladdin)中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（**一个节点也可以是它自己的祖先**）。”

 

**示例 1：**

![img](https://assets.leetcode.com/uploads/2018/12/14/binarytree.png)

```
输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输出：3
解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
```

**示例 2：**

![img](https://assets.leetcode.com/uploads/2018/12/14/binarytree.png)

```
输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
输出：5
解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
```

**示例 3：**

```
输入：root = [1,2], p = 1, q = 2
输出：1
```

 

**提示：**

- 树中节点数目在范围 `[2, 105]` 内。
- `-109 <= Node.val <= 109`
- 所有 `Node.val` `互不相同` 。
- `p != q`
- `p` 和 `q` 均存在于给定的二叉树中。

**思路：**
1. 判断当前节点的左右子树是否分别包含p，q
2. 递归

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) return root;
        if(ifContains(root.left, p) && ifContains(root.right, q))
            return root;
        if(ifContains(root.left, q) && ifContains(root.right, p))
            return root;
        TreeNode tmp = lowestCommonAncestor(root.left, p, q);
        return tmp == null ? lowestCommonAncestor(root.right, p, q) : tmp;
    }
    private boolean ifContains(TreeNode root, TreeNode t) {
        if(root == null) return false;
        if(root == t) return true;
        return ifContains(root.left, t) || ifContains(root.right, t);
    }
}
```



#### [108. 将有序数组转换为二叉搜索树](https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/)

难度简单812

给你一个整数数组 `nums` ，其中元素已经按 **升序** 排列，请你将其转换为一棵 **高度平衡** 二叉搜索树。

**高度平衡** 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。

 

**示例 1：**

![img](https://assets.leetcode.com/uploads/2021/02/18/btree1.jpg)

```
输入：nums = [-10,-3,0,5,9]
输出：[0,-3,9,-10,null,5]
解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
```

**示例 2：**

![img](https://assets.leetcode.com/uploads/2021/02/18/btree.jpg)

```
输入：nums = [1,3]
输出：[3,1]
解释：[1,3] 和 [3,1] 都是高度平衡二叉搜索树。
```

 

**提示：**

- `1 <= nums.length <= 104`
- `-104 <= nums[i] <= 104`
- `nums` 按 **严格递增** 顺序排列

**思路：**
1. 每次选取数组中间的值构建当前root节点，分割左右子数组为左右子树
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return doTrans(nums, 0, nums.length - 1);
    }
    private TreeNode doTrans(int[] nums, int start, int end) {
        int len = end - start + 1;
        if(len <= 0) return null;
        TreeNode root = new TreeNode(nums[start + len / 2]);
        root.left = doTrans(nums, start, start + len / 2 - 1);
        root.right = doTrans(nums, start + len / 2 + 1, end);
        return root;
    }
}
```



#### [109. 有序链表转换二叉搜索树](https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/)

<font color=orange>`中等`</font>

给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树*每个节点* 的左右两个子树的高度差的绝对值不超过 1。

**示例:**

```
给定的有序链表： [-10, -3, 0, 5, 9],

一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5
```

**思路：**
1. 链表转数组
2. 中间的元素为根
3. 递归构造左右子树

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> arr = listToArray(head);
        int len = arr.size();
        return doListToBST(arr, 0, len - 1);
    }
    private TreeNode doListToBST(List<Integer> arr, int start, int end) {
        if(start > end) return null;
        int len = end - start + 1;
        TreeNode root = new TreeNode(arr.get(start + len / 2));
        root.left = doListToBST(arr, start, start + len / 2 - 1);
        root.right = doListToBST(arr, start + len / 2 + 1, end);
        return root;
    }
    private List<Integer> listToArray(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        while(head != null) {
            arr.add(head.val);
            head = head.next;
        }
        return arr;
    }
}
```



#### [653. 两数之和 IV - 输入 BST](https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/)

<font color=green>`简单`</font>

给定一个二叉搜索树 `root` 和一个目标结果 `k`，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 `true`。

 

**示例 1：**

![img](https://assets.leetcode.com/uploads/2020/09/21/sum_tree_1.jpg)

```
输入: root = [5,3,6,2,4,null,7], k = 9
输出: true
```

**示例 2：**

![img](https://assets.leetcode.com/uploads/2020/09/21/sum_tree_2.jpg)

```
输入: root = [5,3,6,2,4,null,7], k = 28
输出: false
```

**示例 3：**

```
输入: root = [2,1,3], k = 4
输出: true
```

**示例 4：**

```
输入: root = [2,1,3], k = 1
输出: false
```

**示例 5：**

```
输入: root = [2,1,3], k = 3
输出: true
```

 

**提示:**

- 二叉树的节点个数的范围是 `[1, 104]`.
- `-104 <= Node.val <= 104`
- `root` 为二叉搜索树
- `-105 <= k <= 105`

**思路：**
1. 遍历树，用k减当前节点的值，判断结果是否已经遍历过
2. 递归
3. 维护一个访问过的节点的map

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
    Set<Integer> valSet = new HashSet<>();
    Set<TreeNode> vSet = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        if(!vSet.contains(root) && valSet.contains(k - root.val)) return true;
        vSet.add(root);
        valSet.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}
```



#### [530. 二叉搜索树的最小绝对差](https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/)

<font color=green>`简单`</font>

给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。

 

**示例：**

```
输入：

   1
    \
     3
    /
   2

输出：
1

解释：
最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
```

 

**提示：**

- 树中至少有 2 个节点。
- 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同

**思路：**
1. 中序遍历（左中右），得到升序列表
2. 比较每两个相邻元素之间的差

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
    public int getMinimumDifference(TreeNode root) {
        treeToList(root);
        int mn = Math.abs(list.get(1) - list.get(0));
        for(int i = 2; i < list.size(); i++) {
            mn = Math.min(mn, Math.abs(list.get(i) - list.get(i - 1)));
        }
        return mn;
    }
    private void treeToList(TreeNode root) {
        if(root == null) return;
        treeToList(root.left);
        list.add(root.val);
        treeToList(root.right);
    }
}
```



#### [501. 二叉搜索树中的众数](https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/)

<font color=green>`简单`</font>

给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。

假定 BST 有如下定义：

- 结点左子树中所含结点的值小于等于当前结点的值
- 结点右子树中所含结点的值大于等于当前结点的值
- 左子树和右子树都是二叉搜索树

例如：
给定 BST `[1,null,2,2]`,

```
   1
    \
     2
    /
   2
```

`返回[2]`.

**提示**：如果众数超过1个，不需考虑输出顺序

**进阶：**你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）

**思路：**
1. 遍历，记录每个值出现的次数
2. 取出现次数最多的

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
    private Map<Integer, Integer> kMap = new HashMap<>();
    private Map<Integer, List<Integer>> vMap = new HashMap<>();
    public int[] findMode(TreeNode root) {
        trace(root);
        int mx = 0;
        for(int k : kMap.keySet()) {
            int val = kMap.get(k);
            if(val < mx) continue;
            mx = val;
            if(!vMap.containsKey(val)) {
                List<Integer> list = new ArrayList<>();
                vMap.put(val, list);
            }
            vMap.get(val).add(k);
        }
        List<Integer> tmp = vMap.get(mx);
        int len = tmp.size();
        int[] ret = new int[len];
        for(int i = 0; i < len; i++) {
            ret[i] = tmp.get(i);
        }
        return ret;
    }
    private void trace(TreeNode root) {
        if(root == null) return;
        kMap.put(root.val, kMap.getOrDefault(root.val, 0) + 1);
        trace(root.left);
        trace(root.right);
    }
}
```

