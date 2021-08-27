#### [167. 两数之和 II - 输入有序数组](https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/)

<font color=green>`简单`</font><font color=orange>`需要使用双指针方法做一遍`</font>

给定一个已按照 **升序排列** 的整数数组 `numbers` ，请你从数组中找出两个数满足相加之和等于目标数 `target` 。

函数应该以长度为 `2` 的整数数组的形式返回这两个数的下标值*。*`numbers` 的下标 **从 1 开始计数** ，所以答案数组应当满足 `1 <= answer[0] < answer[1] <= numbers.length` 。

你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。

**示例 1：**

```
输入：numbers = [2,7,11,15], target = 9
输出：[1,2]
解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
```

**示例 2：**

```
输入：numbers = [2,3,4], target = 6
输出：[1,3]
```

**示例 3：**

```
输入：numbers = [-1,0], target = -1
输出：[1,2]
```

 

**提示：**

- `2 <= numbers.length <= 3 * 104`
- `-1000 <= numbers[i] <= 1000`
- `numbers` 按 **递增顺序** 排列
- `-1000 <= target <= 1000`
- 仅存在一个有效答案

**思路：**

1. 遍历数组，用target减每一个元素，判断差是否存在数组中
2. 使用HashMap，在遍历的过程中添map中

```java
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int []ret = new int[2];
        int len = numbers.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++) {
            int gap = target - numbers[i];
            if(map.containsKey(gap)) {
                ret[1] = i + 1;
                ret[0] = map.get(gap);
                break;
            }
            map.put(numbers[i], i + 1);
        }
        return ret;
    }
}
```



#### [633. 平方数之和](https://leetcode-cn.com/problems/sum-of-square-numbers/)

<font color=orange>`中等`</font>

给定一个非负整数 `c` ，你要判断是否存在两个整数 `a` 和 `b`，使得 `a2 + b2 = c` 。

 

**示例 1：**

```
输入：c = 5
输出：true
解释：1 * 1 + 2 * 2 = 5
```

**示例 2：**

```
输入：c = 3
输出：false
```

**示例 3：**

```
输入：c = 4
输出：true
```

**示例 4：**

```
输入：c = 2
输出：true
```

**示例 5：**

```
输入：c = 1
输出：true
```

 

**提示：**

- `0 <= c <= 231 - 1`

**思路：**
1. 使用双指针从两边向中间聚拢
2. r = (c / 2 + 1) ^ 2 > c （中间结果可能溢出）
3. r = (int)(Math.sqrt(c)) + 1;

```java
class Solution {
    public boolean judgeSquareSum(int c) {
        int l = 0, r = (int)(Math.sqrt(c)) + 1;
        while(l <= r) {
            int tmp = l * l + r * r;
            if(tmp == c) 
                return true;
            if(tmp < c) 
                l++;
            else 
                r--;
        }
        return false;
    }
}
```



#### [345. 反转字符串中的元音字母](https://leetcode-cn.com/problems/reverse-vowels-of-a-string/)

<font color=green>`简单`</font>

给你一个字符串 `s` ，仅反转字符串中的所有元音字母，并返回结果字符串。

元音字母包括 `'a'`、`'e'`、`'i'`、`'o'`、`'u'`，且可能以大小写两种形式出现。

 

**示例 1：**

```
输入：s = "hello"
输出："holle"
```

**示例 2：**

```
输入：s = "leetcode"
输出："leotcede"
```

 

**提示：**

- `1 <= s.length <= 3 * 105`
- `s` 由 **可打印的 ASCII** 字符组成

**思路：**
1. 包含大写字母
2. 从两边非同步往中间聚拢，都遇到元音字母时交换

```java
class Solution {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        char[] cs = s.toCharArray();
        int len = cs.length;
        int l = 0, r = len - 1;
        while(l < r) {
            while(l < r && !set.contains(Character.toLowerCase(cs[l])))
                l++;
            while(l < r && !set.contains(Character.toLowerCase(cs[r])))
                r--;
            swap(cs, l++, r--);
        }
        return new String(cs);
    }
    private void swap(char[] cs, int i, int j) {
        char t = cs[i];
        cs[i] = cs[j];
        cs[j] = t;
    }
}
```



#### [680. 验证回文字符串 Ⅱ](https://leetcode-cn.com/problems/valid-palindrome-ii/)

<font color=green>`简单`</font>

给定一个非空字符串 `s`，**最多**删除一个字符。判断是否能成为回文字符串。

 

**示例 1:**

```
输入: s = "aba"
输出: true
```

**示例 2:**

```
输入: s = "abca"
输出: true
解释: 你可以删除c字符。
```

**示例 3:**

```
输入: s = "abc"
输出: false
```

 

**提示:**

- `1 <= s.length <= 105`
- `s` 由小写英文字母组成

**思路：**
1. 从两边往中间聚拢，遇到不同的左边或者右边跳一个字符
2. 判断剩下的部分是否回文，两种情况

```java
class Solution {
    public boolean validPalindrome(String s) {
        char[] cs = s.toCharArray();
        int len = cs.length;
        int l = 0, r = len - 1;
        while(l < r) {
            if(cs[l] != cs[r]) {
                return isPalin(cs, l + 1, r) || isPalin(cs, l, r - 1);
            }
            l++; r--;
        }
        return true;
    }
    public boolean isPalin(char[] cs, int l, int r) {
        while(l < r) {
            if(cs[l] != cs[r]) 
                return false;
            l++; r--;
        }
        return true;
    }
}
```



#### [88. 合并两个有序数组](https://leetcode-cn.com/problems/merge-sorted-array/)

<font color=green>`简单`</font>

给你两个按 **非递减顺序** 排列的整数数组 `nums1` 和 `nums2`，另有两个整数 `m` 和 `n` ，分别表示 `nums1` 和 `nums2` 中的元素数目。

请你 **合并** `nums2` 到 `nums1` 中，使合并后的数组同样按 **非递减顺序** 排列。

**注意：**最终，合并后数组不应由函数返回，而是存储在数组 `nums1` 中。为了应对这种情况，`nums1` 的初始长度为 `m + n`，其中前 `m` 个元素表示应合并的元素，后 `n` 个元素为 `0` ，应忽略。`nums2` 的长度为 `n` 。

 

**示例 1：**

```
输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
输出：[1,2,2,3,5,6]
解释：需要合并 [1,2,3] 和 [2,5,6] 。
合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
```

**示例 2：**

```
输入：nums1 = [1], m = 1, nums2 = [], n = 0
输出：[1]
解释：需要合并 [1] 和 [] 。
合并结果是 [1] 。
```

**示例 3：**

```
输入：nums1 = [0], m = 0, nums2 = [1], n = 1
输出：[1]
解释：需要合并的数组是 [] 和 [1] 。
合并结果是 [1] 。
注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
```

 

**提示：**

- `nums1.length == m + n`
- `nums2.length == n`
- `0 <= m, n <= 200`
- `1 <= m + n <= 200`
- `-109 <= nums1[i], nums2[j] <= 109`

 

**进阶：**你可以设计实现一个时间复杂度为 `O(m + n)` 的算法解决此问题吗？



**思路：**

1. 两个数组，一个数组分配一个指针
2. 顺序比较，写入临时数组，剩下的直接复制到临时数组
3. 复制到nums1

```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m + n];
        int i = 0, j = 0;
        while(i < m && j < n) {
            if(nums1[i] <= nums2[j]) {
                nums[i + j] = nums1[i];
                i++;
                continue;
            }
            nums[i + j] = nums2[j];
            j++;
        }
        while(i < m) {
            nums[i + j] = nums1[i];
            i++;
        }
        while(j < n) {
            nums[i + j] = nums2[j];
            j++;
        }
        for(int k = 0; k < m + n; k++) {
            nums1[k] = nums[k];
        }
    }
}
```



#### [141. 环形链表](https://leetcode-cn.com/problems/linked-list-cycle/)

<font color=green>`简单`</font>

给定一个链表，判断链表中是否有环。

如果链表中有某个节点，可以通过连续跟踪 `next` 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 `pos` 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 `pos` 是 `-1`，则在该链表中没有环。**注意：`pos` 不作为参数进行传递**，仅仅是为了标识链表的实际情况。

如果链表中存在环，则返回 `true` 。 否则，返回 `false` 。

 

**进阶：**

你能用 *O(1)*（即，常量）内存解决此问题吗？

 

**示例 1：**

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist.png)

```
输入：head = [3,2,0,-4], pos = 1
输出：true
解释：链表中有一个环，其尾部连接到第二个节点。
```

**示例 2：**

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test2.png)

```
输入：head = [1,2], pos = 0
输出：true
解释：链表中有一个环，其尾部连接到第一个节点。
```

**示例 3：**

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test3.png)

```
输入：head = [1], pos = -1
输出：false
解释：链表中没有环。
```

 

**提示：**

- 链表中节点的数目范围是 `[0, 104]`
- `-105 <= Node.val <= 105`
- `pos` 为 `-1` 或者链表中的一个 **有效索引** 。



**思路：**

1. 快慢指针
2. 快指针套圈慢指针说明有环

```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode fast = head.next, slow = head;
        while(fast != null && slow != null) {
            if(fast.next == null) return false;
            if(fast == slow) return true;
            fast = fast.next.next;
            slow = slow.next;
        }
        return false; // 一个节点的情况
    }
}
```



#### [524. 通过删除字母匹配到字典里最长单词](https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/)

<font color=orange>`中等`</font>

给你一个字符串 `s` 和一个字符串数组 `dictionary` 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 `s` 中的某些字符得到。

如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。

 

**示例 1：**

```
输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
输出："apple"
```

**示例 2：**

```
输入：s = "abpcplea", dictionary = ["a","b","c"]
输出："a"
```

 

**提示：**

- `1 <= s.length <= 1000`
- `1 <= dictionary.length <= 1000`
- `1 <= dictionary[i].length <= 1000`
- `s` 和 `dictionary[i]` 仅由小写英文字母组成



**思路：**
1. 分解步骤
2. 遍历list中的每一个字符串，分别判断是否为子串
3. 使用双指针异步比较母串和子串中的字符

```java
class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        char[] cs = s.toCharArray();
        int len = cs.length;
        String longest = "";
        for(int i = 0; i < dictionary.size(); i++) {
            String tmp = dictionary.get(i);
            if(isIncluded(cs, tmp)) {
                if(tmp.length() > longest.length()) {
                    longest = tmp;
                }
                else if(tmp.length() == longest.length() && tmp.compareTo(longest) < 0) {
                    longest = tmp;
                }
            }
        }
        return longest;
    }
    private boolean isIncluded(char[] cs, String l) {
        char[] ls = l.toCharArray();
        int l1 = cs.length, l2 = ls.length;
        int i = 0, j = 0;
        while(i < l1 && j < l2) {
            if(cs[i] == ls[j]) 
                j++; // 相等的时候子串才移动
            i++;
        }
        return j == l2;
    }
}
```

