#### [208. 实现 Trie (前缀树)](https://leetcode-cn.com/problems/implement-trie-prefix-tree/)

<font color=orange>`中等`</font><font color=red>`需要优化`</font>

**[Trie](https://baike.baidu.com/item/字典树/9825209?fr=aladdin)**（发音类似 "try"）或者说 **前缀树** 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。

请你实现 Trie 类：

- `Trie()` 初始化前缀树对象。
- `void insert(String word)` 向前缀树中插入字符串 `word` 。
- `boolean search(String word)` 如果字符串 `word` 在前缀树中，返回 `true`（即，在检索之前已经插入）；否则，返回 `false` 。
- `boolean startsWith(String prefix)` 如果之前已经插入的字符串 `word` 的前缀之一为 `prefix` ，返回 `true` ；否则，返回 `false` 。

 

**示例：**

```
输入
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
输出
[null, null, true, false, true, null, true]

解释
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // 返回 True
trie.search("app");     // 返回 False
trie.startsWith("app"); // 返回 True
trie.insert("app");
trie.search("app");     // 返回 True
```

 

**提示：**

- `1 <= word.length, prefix.length <= 2000`
- `word` 和 `prefix` 仅由小写英文字母组成
- `insert`、`search` 和 `startsWith` 调用次数 **总计** 不超过 `3 * 104` 次

**思路：**
1. 利用map作为父节点和孩子节点的连接

```java
class Node {
    HashMap<Character, Node> children;
    public Node() {
        this.children = new HashMap<>();
    } 
}
class Trie {
    Node root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        int len = word.length();
        if(len == 0) return;
        Node root = this.root;
        for(int i = 0; i < len; i++) {
            char c = word.charAt(i);
            HashMap<Character, Node> childMap = root.children;
            if(!childMap.containsKey(c)) {
                childMap.put(c, new Node());
            }
            root = childMap.get(c); // root的children肯定存在，因为new Node()的时候初始化了
        }
        if(root.children.containsKey(' '))
            return;
        root.children.put(' ', null);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        int len = word.length();// len >= 1
        Node root = this.root;
        for(int i = 0; i < len; i++) {
            char c = word.charAt(i);
            HashMap<Character, Node> childMap = root.children;
            if(!childMap.containsKey(c))
                return false;
            root = childMap.get(c);
        }
        if(!root.children.containsKey(' ')) return false; // word是前缀的情况
        return true;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        int len = prefix.length();// len >= 1
        Node root = this.root;
        for(int i = 0; i < len; i++) {
            char c = prefix.charAt(i);
            HashMap<Character, Node> childMap = root.children;
            if(!childMap.containsKey(c))
                return false;
            root = childMap.get(c);
        }
        return true;

    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
```



#### [677. 键值映射](https://leetcode-cn.com/problems/map-sum-pairs/)

<font color=orange>`中等`</font><font color=red>`需要优化`</font>

实现一个 `MapSum` 类，支持两个方法，`insert` 和 `sum`：

- `MapSum()` 初始化 `MapSum` 对象
- `void insert(String key, int val)` 插入 `key-val` 键值对，字符串表示键 `key` ，整数表示值 `val` 。如果键 `key` 已经存在，那么原来的键值对将被替代成新的键值对。
- `int sum(string prefix)` 返回所有以该前缀 `prefix` 开头的键 `key` 的值的总和。

 

**示例：**

```
输入：
["MapSum", "insert", "sum", "insert", "sum"]
[[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
输出：
[null, null, 3, null, 5]

解释：
MapSum mapSum = new MapSum();
mapSum.insert("apple", 3);  
mapSum.sum("ap");           // return 3 (apple = 3)
mapSum.insert("app", 2);    
mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
```

 

**提示：**

- `1 <= key.length, prefix.length <= 50`
- `key` 和 `prefix` 仅由小写英文字母组成
- `1 <= val <= 1000`
- 最多调用 `50` 次 `insert` 和 `sum`

**思路：**
1. 利用map存储孩子节点
2. 利用node的val存储字符串的val

```java
class Node {
    int val;
    HashMap<Character, Node> children = new HashMap<>();
    public Node(int val) {
        this.val = val;
        this.children = new HashMap<>();
    }
}
class MapSum {
    Node root;
    int sum;
    /** Initialize your data structure here. */
    public MapSum() {
        this.root = new Node(0);
        this.sum = 0;
    }
    
    public void insert(String key, int val) {
        int len = key.length();
        if(len == 0) return;
        Node root = this.root;
        for(int i = 0; i < len; i++) {
            char c = key.charAt(i);
            HashMap<Character, Node> childMap = root.children;
            if(!childMap.containsKey(c)) {
                childMap.put(c, new Node(0));
            }
            root = childMap.get(c);
        }
        root.children.put(' ', new Node(val));
    }
    
    public int sum(String prefix) {
        int len = prefix.length();
        sum = 0;
        if(len == 0) return sum;
        Node root = this.root;
        for(int i = 0; i < len; i++) {
            char c = prefix.charAt(i);
            HashMap<Character, Node> childMap = root.children;
            if(!childMap.containsKey(c)) {
                return 0;
            }
            root = childMap.get(c);
        }
        calSum(root.children);
        int ret = sum;
        return ret;
    }

    private void calSum(HashMap<Character, Node> roots) {
        if(roots == null) return;
        for(char k : roots.keySet()) {
            if(roots.get(k) == null) 
                continue;
            if(roots.get(k).val != 0)
                sum += roots.get(k).val;
            calSum(roots.get(k).children);
        }
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
```

