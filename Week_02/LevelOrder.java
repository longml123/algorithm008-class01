package com.qunar.qboss.qer.common.lianxi.tree;

import com.qunar.qboss.qer.common.lianxi.tree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {

    public void levelOrder(com.qunar.qboss.qer.common.lianxi.tree.Node root){
        List<Integer> values = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            values.add(cur.val);
            for (Node child : cur.children) {
                queue.add(child);
            }
        }
    }

    public List<List<Integer>> levelOrder01(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) return res;
        heper(root, 0,res);
        return res;
    }

    private void heper(Node root, int level, List<List<Integer>> res) {
        if (root != null) return;
        //判断是否是新的一层
        if (level + 1 > res.size()){
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        //处理子节点
        for (Node child : root.children) {
            if (child != null)
                heper(child,level + 1,res);
        }
    }

    public List<List<Integer>> levelOrder02(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) return res;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            //外层循环为一层
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            while (count-- > 0){
                //将当前元素的非空子节点压入栈
                Node cur = queue.poll();
                list.add(cur.val);
                for (Node child : cur.children) {
                    if (child != null){
                        queue.add(child);
                    }
                }
            }
            res.add(list);
        }
        return res;
    }


}
