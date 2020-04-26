package com.qunar.qboss.qer.common.lianxi.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal01 {


    /**
     * 遍历，链表
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode node =  stack.pollLast();
            result.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return result;
    }

    /**
     * 遍历，栈
     * @param root
     * @return
     */
    public  List<Integer> preorderTraversal02(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cuur = root;//当前节点
        while (cuur != null && !stack.empty()){
            while (cuur != null){
//                访问p节点；
//                p的右子树入S;
//                p = p的左子树;
                result.add(cuur.val);
                stack.push(cuur.right);
                cuur = cuur.left;
            }
            stack.pop();
        }
        return  result;
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal01(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            helper(root, result);
            return  result;
    }

    private void helper(TreeNode root, List<Integer> result) {
        //前序遍历，根左右
        if (root != null){
            result.add(root.val);
            if (root.left != null){
                helper(root.left,result);
            }
            if (root.right != null){
                helper(root.right, result);
            }
        }
    }
}
