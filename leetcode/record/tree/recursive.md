#### [104. 二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/)

<font color="green">`简单`</font>

给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

**说明:** 叶子节点是指没有子节点的节点。

**示例：**
给定二叉树 `[3,9,20,null,null,15,7]`，

```
    3
   / \
  9  20
    /  \
   15   7
```

返回它的最大深度 3 。

**思路：**

1. 子树的最大深度 + 1
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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int maxDep = 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
```



#### [110. 平衡二叉树](https://leetcode-cn.com/problems/balanced-binary-tree/)

<font color="green">`简单`</font>

给定一个二叉树，判断它是否是高度平衡的二叉树。

本题中，一棵高度平衡二叉树定义为： 

> 一个二叉树*每个节点* 的左右两个子树的高度差的绝对值不超过 1 。

 

**示例 1：**

![img](https://assets.leetcode.com/uploads/2020/10/06/balance_1.jpg)

```
输入：root = [3,9,20,null,null,15,7]
输出：true
```

**示例 2：**

![img](https://assets.leetcode.com/uploads/2020/10/06/balance_2.jpg)

```
输入：root = [1,2,2,3,3,null,null,4,4]
输出：false
```

**示例 3：**

```
输入：root = []
输出：true
```

 

**提示：**

- 树中的节点数在范围 `[0, 5000]` 内
- `-104 <= Node.val <= 104`

**思路：**

1. 遍历每一个节点，递归
2. 判断每个节点是否 |左子树height - 右子树height| <= 1

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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        else if(root != null && Math.abs(treeHeight(root.left) - treeHeight(root.right)) > 1) {
            return false;
        } 
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int treeHeight(TreeNode root) {
        if(root == null) return 0;
        return Math.max(treeHeight(root.left), treeHeight(root.right)) + 1;
    }
}
```



#### [543. 二叉树的直径](https://leetcode-cn.com/problems/diameter-of-binary-tree/)

<font color="green">`简单`</font>

给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。

 

**示例 :**
给定二叉树

```
          1
         / \
        2   3
       / \     
      4   5    
```

返回 **3**, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。

 

**注意：**两结点之间的路径长度是以它们之间边的数目表示。

**思路：**

1. 遍历每个节点，递归
2. 计算节点左子树height + 右子树height （路径长度 = 节点数 - 1）

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
    private int maxLen = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        maxLen = Math.max(maxLen, maxDepth(root.left) + maxDepth(root.right)); // 路径长度 = 节点数 - 1
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        return maxLen;
    }

    private int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
```



#### [226. 翻转二叉树](https://leetcode-cn.com/problems/invert-binary-tree/)

<font color="green">`简单`</font>

翻转一棵二叉树。

**示例：**

输入：

```
     4
   /   \
  2     7
 / \   / \
1   3 6   9
```

输出：

```
     4
   /   \
  7     2
 / \   / \
9   6 3   1
```

**思路:**

1. 遍历每一个节点，递归
2. 左孩子  <--> 右孩子

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
    public TreeNode invertTree(TreeNode root) {
        exchange(root);
        return root;
    }

    private void exchange(TreeNode root) {
        if(root == null) return;
        // 交换左孩子和右孩子
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        exchange(root.left);
        exchange(root.right);
    }
}
```



#### [617. 合并二叉树](https://leetcode-cn.com/problems/merge-two-binary-trees/)

<font color="green">`简单`</font>

给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。

你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则**不为** NULL 的节点将直接作为新二叉树的节点。

**示例 1:**

```
输入: 
	Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  
输出: 
合并后的树:
	     3
	    / \
	   4   5
	  / \   \ 
	 5   4   7
```

**注意:** 合并必须从两个树的根节点开始。

**思路：**

思路：
1. 同时以相同方式遍历两棵树，递归
2. 按照规则合并节点到root1：
	* root1 和 root2 都为空时，返回空
	* root1 为空，创建新节点，附上 root2 的 val，设置左右子树
	* root2 为空，val 不变，设置左右子树
	* 都不为空，val 相加，设置左右子树

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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return null;
        else if(root1 == null) {
            // root1 为 null 时创建新节点
            root1 = new TreeNode(root2.val);
            // 需要设置左右孩子
            root1.left = mergeTrees(null, root2.left);  
            root1.right = mergeTrees(null, root2.right); 
        }
        else if(root2 == null) {
            root1.left = mergeTrees(root1.left, null);
            root1.right = mergeTrees(root1.right, null);
        }
        else {
            root1.val = root1.val + root2.val;
            root1.left = mergeTrees(root1.left, root2.left);
            root1.right = mergeTrees(root1.right, root2.right);
        }
        return root1;
    }
}
```



#### [112. 路径总和](https://leetcode-cn.com/problems/path-sum/)

<font color="green">`简单`</font>

给你二叉树的根节点 `root` 和一个表示目标和的整数 `targetSum` ，判断该树中是否存在 **根节点到叶子节点** 的路径，这条路径上所有节点值相加等于目标和 `targetSum` 。

**叶子节点** 是指没有子节点的节点。

 

**示例 1：**

![img](https://assets.leetcode.com/uploads/2021/01/18/pathsum1.jpg)

```
输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
输出：true
```

**示例 2：**

![img](https://assets.leetcode.com/uploads/2021/01/18/pathsum2.jpg)

```
输入：root = [1,2,3], targetSum = 5
输出：false
```

**示例 3：**

```
输入：root = [1,2], targetSum = 0
输出：false
```

 

**提示：**

- 树中节点的数目在范围 `[0, 5000]` 内
- `-1000 <= Node.val <= 1000`
- `-1000 <= targetSum <= 1000`

**思路：**
1. 根节点向叶子结点遍历
2. 判断targetSum减到叶子结点的val是否为0，用targetSum - root.val递归

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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        if(root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
```



#### [437. 路径总和 III](https://leetcode-cn.com/problems/path-sum-iii/)

<font color="orange">`中等`</font>

给定一个二叉树，它的每个结点都存放着一个整数值。

找出路径和等于给定数值的路径总数。

路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。

二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。

**示例：**

```
root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

返回 3。和等于 8 的路径有:

1.  5 -> 3
2.  5 -> 2 -> 1
3.  -3 -> 11
```

**思路：**
1. 每个节点都要作为起点遍历一次 （第一层递归）
2. 向下取和，满足要求进行记录，并继续向下取和直到叶子结点 （第二层递归）

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

    private int count;

    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        doSumPath(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return count;
    }

    private void doSumPath(TreeNode root, int targetSum) {
        if(root == null) return;
        if(targetSum == root.val) count++;
        doSumPath(root.left, targetSum - root.val);
        doSumPath(root.right, targetSum - root.val);
    }
}
```



#### [572. 另一个树的子树](https://leetcode-cn.com/problems/subtree-of-another-tree/)

<font color="green">`简单`</font>

给定两个非空二叉树 **s** 和 **t**，检验 **s** 中是否包含和 **t** 具有相同结构和节点值的子树。**s** 的一个子树包括 **s** 的一个节点和这个节点的所有子孙。**s** 也可以看做它自身的一棵子树。

**示例 1:**
给定的树 s:

```
     3
    / \
   4   5
  / \
 1   2
```

给定的树 t：

```
   4 
  / \
 1   2
```

返回 **true**，因为 t 与 s 的一个子树拥有相同的结构和节点值。

**示例 2:**
给定的树 s：

```
     3
    / \
   4   5
  / \
 1   2
    /
   0
```

给定的树 t：

```
   4
  / \
 1   2
```

返回 **false**。

**思路：**
1. 遍历大树的每一个节点，找到值等于子树根节点的节点，递归
2. 判断节点左右子节点是否相同，递归

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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(traceTree(root, subRoot)) return true;
        if(root != null)
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        return false;
    }
    private boolean traceTree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) return true;
        if(!(root != null && subRoot != null)) return false;
        if(root.val == subRoot.val) 
            return traceTree(root.left, subRoot.left) && traceTree(root.right, subRoot.right);
        return false;
    }
}
```



#### [101. 对称二叉树](https://leetcode-cn.com/problems/symmetric-tree/)

<font color="green">`简单`</font>

给定一个二叉树，检查它是否是镜像对称的。

 

例如，二叉树 `[1,2,2,3,4,4,3]` 是对称的。

```
    1
   / \
  2   2
 / \ / \
3  4 4  3
```

 

但是下面这个 `[1,2,2,null,3,null,3]` 则不是镜像对称的:

```
    1
   / \
  2   2
   \   \
   3    3
```

 **思路：**
1. 比较左子树和右子树每个节点的值
2. 对左子树 左中右 右子树 右中左 同时递归比较节点的值

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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return traceTree(root.left, root.right);
    }
    private boolean traceTree(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        if(!(root1 != null && root2 != null)) return false;
        if(root1.val != root2.val) return false;
        return traceTree(root1.left, root2.right) && traceTree(root1.right, root2.left);
    }
}
```



#### [111. 二叉树的最小深度](https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/)

<font color="green">`简单`</font> <font color="red">`<需要重复做>`</font>

给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

**说明：**叶子节点是指没有子节点的节点。

 

**示例 1：**

![img](https://assets.leetcode.com/uploads/2020/10/12/ex_depth.jpg)

```
输入：root = [3,9,20,null,null,15,7]
输出：2
```

**示例 2：**

```
输入：root = [2,null,3,null,4,null,5,null,6]
输出：5
```

 

**提示：**

- 树中节点数的范围在 `[0, 105]` 内
- `-1000 <= Node.val <= 1000`

**思路：**
1. 递归计算左右子树的深度
2. 对于等于0的子树（不存在当前节点），舍弃，使用另外的子树

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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if(left == 0) return right + 1;
        if(right == 0) return left + 1;
        return Math.min(left, right) + 1;
    }
}
```



#### [404. 左叶子之和](https://leetcode-cn.com/problems/sum-of-left-leaves/)

<font color="green">`简单`</font>

计算给定二叉树的所有左叶子之和。

**示例：**

```
    3
   / \
  9  20
    /  \
   15   7

在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
```

**思路：**
1. 遍历每一个节点及每个节点的左右子树，递归
2. 设置一个是否为左孩子的标记
3. 对左孩子同时为叶子结点的val进行累加

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
    private int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        doSum(root.left, true);
        doSum(root.right, false);
        return sum;
    }
    private void doSum(TreeNode root, boolean left) {
        if(root == null) return;
        if(root.left == null && root.right == null && left) {
            sum += root.val;
        }
        doSum(root.left, true);
        doSum(root.right, false);
    }
}
```



#### [687. 最长同值路径](https://leetcode-cn.com/problems/longest-univalue-path/)

<font color="orange">`中等`</font> <font color="red">`<需要重复做>`</font>

给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。

**注意**：两个节点之间的路径长度由它们之间的边数表示。

**示例 1:**

输入:

```
    5
   / \
  4   5
 / \   \
1   1   5
```

输出:

```
2
```

**示例 2:**

输入:

```
    1
   / \
  4   5
 / \   \
4   4   5
```

输出:

```
2
```

**注意:** 给定的二叉树不超过10000个结点。 树的高度不超过1000。

**思路：**
1. 对每一个节点计算一遍其左右子树符合条件的路径长度（左子树的最大深度 + 右子树的最大深度）（val限制）。递归
2. 孩子节点.val == 当前节点.val，长度 + 1

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

    private int mx = 0;

    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        mx = Math.max(capDepth(root.left, root.val) + capDepth(root.right, root.val), mx); // 分别计算左右子树的限制条件下的最大深度
        longestUnivaluePath(root.left);
        longestUnivaluePath(root.right);
        return mx;
    }
    private int capDepth(TreeNode root, int pre) { // 限制条件下的最大深度
        if(root == null || root.val != pre) return 0;
        int l = 0, r = 0;
        if(root != null && root.val == pre) {
            l++; r++;
            l += capDepth(root.left, pre);
            r += capDepth(root.right, pre);
        }
        return Math.max(l, r);
    }
}
```



#### [337. 打家劫舍 III](https://leetcode-cn.com/problems/house-robber-iii/)

<font color="orange">`中等`</font> <font color="red">`<需要重复做>`</font>

在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。

计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。

**示例 1:**

```
输入: [3,2,3,null,3,null,1]

    3
   / \
  2   3
   \   \ 
    3   1

输出: 7 
解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
```

**示例 2:**

```
输入: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \ 
 1   3   1

输出: 9
解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
```

**思路：**
1. 需要计算经过每一个节点的间隔路径，递归
2. 当前节点加入计算，其子节点不能加入计算
3. 当前节点不加入计算，其子节点可以加入计算也可以不加入计算
4. 在对每个节点进行递归计算的时候，会有大量的重复计算，需要进行去重

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
    private int mx = 0;
    public int rob(TreeNode root) {
        if(root == null) return 0;
        mx = Math.max(mx, doRob(root, false));
        mx = Math.max(mx, doRob(root, true));
        return mx;
    }

    // 有重复的递归计算，时间复杂度太高，需要进行去重
    private Map<TreeNode, Integer> curNodeRobMxAmount = new HashMap<TreeNode, Integer>();
    private Map<TreeNode, Integer> curNodeNoRobMxAmount = new HashMap<TreeNode, Integer>();
    private int doRob(TreeNode root, boolean canRob) {
        if(root == null) return 0;
        if(canRob) {
            if(!curNodeRobMxAmount.containsKey(root)) {
                curNodeRobMxAmount.put(root, root.val + doRob(root.left, false) + doRob(root.right, false));
            }
            return curNodeRobMxAmount.get(root);
        }
        int leftT = curNodeRobMxAmount.containsKey(root.left) ? curNodeRobMxAmount.get(root.left) : doRob(root.left, true);
        int leftF = curNodeNoRobMxAmount.containsKey(root.left) ? curNodeNoRobMxAmount.get(root.left) : doRob(root.left, false);
        int rightT = curNodeRobMxAmount.containsKey(root.right) ? curNodeRobMxAmount.get(root.right) : doRob(root.right, true);
        int rightF = curNodeNoRobMxAmount.containsKey(root.right) ? curNodeNoRobMxAmount.get(root.right) : doRob(root.right, false);
        int t1 = Math.max(leftT, leftF);
        int t2 = Math.max(rightT, rightF);
        curNodeNoRobMxAmount.put(root, t1 + t2);
        return t1 + t2;
    }
}
```



#### [671. 二叉树中第二小的节点](https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/)

<font color=green>简单</font>   

给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 `2` 或 `0`。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。

更正式地说，`root.val = min(root.left.val, root.right.val)` 总成立。

给出这样的一个二叉树，你需要输出所有节点中的**第二小的值。**如果第二小的值不存在的话，输出 -1 **。**

 

**示例 1：**

![img](https://assets.leetcode.com/uploads/2020/10/15/smbt1.jpg)

```
输入：root = [2,2,5,null,null,5,7]
输出：5
解释：最小的值是 2 ，第二小的值是 5 。
```

**示例 2：**

![img](https://assets.leetcode.com/uploads/2020/10/15/smbt2.jpg)

```
输入：root = [2,2,2]
输出：-1
解释：最小的值是 2, 但是不存在第二小的值。
```

 

**提示：**

- 树中节点数目在范围 `[1, 25]` 内
- `1 <= Node.val <= 231 - 1`
- 对于树中每个节点 `root.val == min(root.left.val, root.right.val)`

**思路：**
1. 第二小的值为节点左右孩子中与父节点值不同的那个
2. 如果左右孩子都有，需要取较小的
3. 多级比较，递归

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
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null) return -1;
        int secMin = doFindSecMin(root, root.val);
        return secMin == root.val ? -1 : secMin;
    }
    
    public int doFindSecMin(TreeNode root, int mn) {
        if(root == null) return mn; 
        if(root.val != mn) return root.val;
        
        int l = mn, r = mn;
        // 每个节点的子节点数量只能为 2 或 0
        if(root.left != null) {
            l = doFindSecMin(root.left, mn);
            r = doFindSecMin(root.right, mn);
        }
        if(l == mn) return r;
        if(r == mn) return l;
        return Math.min(l, r);
    }
}
```

