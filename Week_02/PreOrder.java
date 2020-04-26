package com.qunar.qboss.qer.common.lianxi.tree;

import java.util.*;

/**
 * 前序遍历（根左右）
 *
 */
public class PreOrder {

    /**
     * 迭代
     * 前序遍历（根左右）
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) return res;

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()){
            Node cur = stack.pop();
            res.add(cur.val);
            for (int i = cur.children.size() - 1; i >= 0; i--) {
                Node children = cur.children.get(i);
                if(children != null){
                    stack.push(children);
                }
            }
        }
        return res;
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> preorder01(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) return res;
        heper(root,res);
        return res;
    }

    private void heper(Node root, List<Integer> res) {
        if (root != null) return;
        res.add(root.val);
        for (Node child : root.children) {
            if (child != null){
                heper(child,res);
            }
        }
    }




}
