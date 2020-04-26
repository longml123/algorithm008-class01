package com.qunar.qboss.qer.common.lianxi.tree;

public class PostorderTraversal {

    /**
     * 后序：左-右-根
     *
     * @param root
     */
    public static void postOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.val + "");
    }

}
