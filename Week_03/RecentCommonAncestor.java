package com.qunar.qboss.qer.common.lianxi.tree;

public class RecentCommonAncestor {

    private  TreeNode ans;

    public RecentCommonAncestor(){
        this.ans = null;
    }

    /**
     * 方法一：递归
     * 这种方法非常直观。先深度遍历该树。当你遇到节点 p 或 q 时，返回一些布尔值作为标记。
     * 标记有助于确定是否在任何路径中找到了所需的节点。最不常见的祖先将是两个子树递归都返回 true 标记的节点。
     * 它也可以是一个节点，它本身是 p 或 q 中的一个，对于这个节点,子树递归返回一个 true 标记。
     *
     * 让我们看看基于这个想法的正式算法。
     *
     * 算法：
     * 从根节点开始遍历树。
     * 如果当前节点本身是 p 或 q 中的一个，我们会将变量 mid 标记为 true，并继续搜索左右分支中的另一个节点。
     * 如果左分支或右分支中的任何一个返回 true，则表示在下面找到了两个节点中的一个。
     * 如果在遍历的任何点上，left、right 或者 mid 三个标记中的任意两个变为 true，
     * 这意味着我们找到了节点 p 和 q 的最近公共祖先。
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Traverse the tree
        this.recurseTree(root, p, q);
        return this.ans;
    }

    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {
        // If reached the end of a branch, return false.
        if (currentNode == null) {
            return false;
        }

        // Left Recursion. If left recursion returns true, set left = 1 else 0
        int left = this.recurseTree(currentNode.left,p,q) ? 1 : 0;
        // Right Recursion
        int right = this.recurseTree(currentNode.right, p,q) ? 1:0;
        // If the current node is one of p or q
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;

        // If any two of the flags left, right or mid become True
        if (mid + left + right >= 2) {
            this.ans = currentNode;
        }
        // Return true if any one of the three bool values is True.
        return  (mid + left + right > 0);
    }

    public TreeNode lowestCommonAncestor01(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode leftCommonAncestorNode = lowestCommonAncestor01(root.left, p, q);
        TreeNode rightCommonAncestorNode = lowestCommonAncestor01(root.right, p, q);
        //在左子树中没有找到，那一定在右子树中
        if (leftCommonAncestorNode == null) {
            return rightCommonAncestorNode;
        }
        //在右子树中没有找到，那一定在左子树中
        if (rightCommonAncestorNode == null) {
            return  leftCommonAncestorNode;
        }
        //不在左子树，也不在右子树，就在根节点
        return root;
    }

}
