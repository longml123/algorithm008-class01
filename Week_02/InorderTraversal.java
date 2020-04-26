package com.qunar.qboss.qer.common.lianxi.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    public static void main(String[] args) {
//        inorderTraversal0();
//        inorderTraversal1();
    }

    /**
     * 递归中旬遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal0(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return  result;
    }

    private void helper(TreeNode root, List<Integer> result) {
        if (root != null){
            if (root.left != null){
                helper(root.left,result);
            }

            result.add(root.val);

            if (root.right != null){
                helper(root.right, result);
            }
        }
    }

    /**
     * 基于栈的遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cuur = root;//当前节点

        while (cuur != null || !stack.empty()){
            //从根节点到最左节点一次入栈
            while (cuur != null){
                stack.push(cuur);
                cuur = cuur.left;
            }

            //最左节点出站；获取值，存在放到集合；
            cuur = stack.pop();
            result.add(cuur.val);
            cuur = cuur.right;
        }
        return  result;
    }


    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cuur = root;//当前节点
        while (cuur != null || !stack.empty()){
            while (root != null){
                result.add(cuur.val);
                stack.push(cuur.left);
                cuur = cuur.right;
            }
            stack.pop();
        }

        Collections.sort(result);
        return result;
    }

}
