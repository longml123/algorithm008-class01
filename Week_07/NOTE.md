Skip to content
Search or jump to…

Pull requests
Issues
Marketplace
Explore
 
@longml123 
Learn Git and GitHub without any code!
Using the Hello World guide, you’ll start a branch, write comments, and open a pull request.


GitHubWangJ
/
algorithm008-class01
forked from algorithm008-class01/algorithm008-class01
0
0135
 Code
 Pull requests 0 Actions
 Projects 0
 Wiki
 Security 0
 Insights
algorithm008-class01/Week_07/NOTE.md
@GitHubWangJ GitHubWangJ 提交极客时间算法训练营第八期第七周作业总结
1ff8681 yesterday
@GeekUniversity@GitHubWangJ
204 lines (127 sloc)  6.22 KB
  
学习笔记

[TOC]

第13课-字典树和并查集
字典树 Trie
内容
字典树的基本结构
字典树的基本性质
字典树的核心思想
基本结构
字典树，即Trie(发音同try)树，又称单词查找树或键树，是一种树形结构。典型应用是用于统计和排序大量的字符串(但不仅限于字符串)，所以经常被搜索引擎系统用于文本词频统计。

它的优点是：最大限度的减少无谓的字符串比较，查询效率比哈希表高。

基本性质
结点本身不存完整单词；
从根结点到某一结点，路径上经过的字符连接起来，为该结点对应的字符串；
每个结点的所有子结点路径代表的字符都不相同。
核心思想
Trie 树的核心思想是空间换时间。
利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的。
实战题目
https://leetcode-cn.com/problems/implement-trie-prefix-tree/
https://leetcode-cn.com/problems/word-search-ii/
并查集 Disjoint Set
适用场景
组团、配对问题
Group or not ?
基本操作
makeSet(s):建立一个新的并查集，其中包含 s 个单元素集合。
unionSet(x, y):把元素 x 和元素 y 所在的集合合并，要求 x 和 y 所在的集合不相交，如果相交则不合并。
find(x):找到元素 x 所在的集合的代表，该操作也可以用于判断两个元素是否位于同一个集合，只要将它们各自的代表比较一下就可以了。
步骤
初始化
查询、合并
路径压缩
Java 实现
class UnionFind {
    private int count = 0;
    private int[] parent;
    
    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    
    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p; 
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        parent[rootP] = rootQ;
        count--; 
    }
}
实战题目
• https://leetcode-cn.com/problems/friend-circles • https://leetcode-cn.com/problems/number-of-islands/ • https://leetcode-cn.com/problems/surrounded-regions/

第14课-高级搜索
剪枝
实战练习
• https://leetcode-cn.com/problems/climbing-stairs/ • https://leetcode-cn.com/problems/generate-parentheses/

回溯法
回溯法采用试错的思想，它尝试分步的去解决一个问题。在分步解决问题的过程中，当它通过尝试发现现有的分步答案不能得到有效的正确的解答的时候，它将取消上一步甚至是上几步的计算，再通过其它的可能的分步解答再次尝试寻找问题的答案。

回溯法通常用最简单的递归方法来实现，在反复重复上述的步骤后可能出现两种情况:

找到一个可能存在的正确的答案
在尝试了所有可能的分步方法后宣告该问题没有答案
在最坏的情况下，回溯法会导致一次复杂度为指数时间的计算。

实战练习
https://leetcode-cn.com/problems/n-queens/ https://leetcode-cn.com/problems/valid-sudoku/description/ https://leetcode-cn.com/problems/sudoku-solver/#/description

双向 BFS
实战题目
https://leetcode-cn.com/problems/word-ladder/
https://leetcode-cn.com/problems/minimum-genetic-mutation/
启发式搜索(A*)
基于BFS代码
A search，重点是估价函数*
估价函数
启发式函数: h(n)，它用来评价哪些结点最有希望的是一个我们要找的结点，h(n) 会返回一个非负实数,也可以认为是从结点n的目标结点路径的估计成本。

启发式函数是一种告知搜索方向的方法。它提供了一种明智的方法来猜测哪个邻居结点会导向一个目标。

第15课-红黑树和AVL树
红黑树
Red-black Tree

红黑树是一种近似平衡的二叉搜索树(Binary Search Tree)，它能够确保任何一个结点的左右子树的高度差小于两倍。具体来说，红黑树是满足如下条件的二叉搜索树：

每个结点要么是红色，要么是黑色。
根节点是黑色。
每个叶节点(NIL节点，空节点)是黑色的。
不能有相邻接的两个红色节点。
从任一节点到其每个叶子的所有路径都包含相同数目的黑色节点。
关键性质
从根到叶子的最长的可能路径不多于最短的可能路径的两倍长。

AVL树
发明者 G. M. Adelson-Velsky 和 Evgenii Landis
Balance Factor(平衡因子)：是它的左子树的高度减去它的右子树的高度(有时相反)。balance factor = {-1, 0, 1}
通过旋转操作来进行平衡(四种)
记录左右子树高度
旋转操作
左旋

子树形态:右右子树 —> 左旋

右旋

子树形态:左左子树 —> 右旋

左右旋

子树形态:左右子树 —> 左右旋

右左旋

子树形态:右左子树 —> 右左旋

AVL树总结
平衡二叉搜索树
每个结点存 balance factor = {-1, 0, 1}
四种旋转操作
不足：结点需要存储额外信息、且调整次数频繁
红黑树和AVL树对比
AVL trees provide faster lookups than Red Black Trees because they are more strictly balanced.
Red Black Trees provide faster insertion and removal operations than AVL trees as fewer rotations are done due to relatively relaxed balancing.
AVL trees store balance factors or heights with each node, thus requires storage for an integer per node whereas Red Black Tree requires only 1 bit of information per node.
Red Black Trees are used in most of the language libraries like map, multimap, multisetin C++ whereas AVL trees are used in databases where faster retrievals are required.
