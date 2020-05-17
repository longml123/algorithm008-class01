package com.qunar.qboss.qer.common.lianxi.week04;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValues {

    public List<Integer> largestValues(TreeNode root){
        List<Integer> res = new ArrayList<>();
        levelOrder(root,0,res);
        return res;
    }

    private void levelOrder(TreeNode root, int level, List<Integer> res) {
        if (root == null) {
            return;
        }

        if (level >= res.size()) {
            res.add(root.val);
        }else {
            int maxValue = Math.max(res.get(level),root.val);
            res.set(level,maxValue);
        }

        levelOrder(root.left,level + 1, res);
        levelOrder(root.right, level + 1, res);
    }

    public  List<Integer> largestValues01(TreeNode root){
        List<Integer> reslut = new ArrayList<>();
        if (root == null) {
            return reslut;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int min = Integer.MIN_VALUE;
            for (int i = 0; i < size ; i++) {
                TreeNode tmp = queue.poll();
                min = Math.max(min,tmp.val);

                if (root.left != null) {
                    queue.add(root.left);
                }
                if (root.right != null) {
                    queue.add(root.right);
                }
            }
            reslut.add(min);
        }

        return reslut;
    }

    public List<Integer> largestValues02(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        dfs(res,root,0);
        return res;
    }

    private void dfs(List<Integer> res, TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (level == res.size()) {
            res.add(root.val);
        }else {
            res.set(level,Math.max(res.get(level),root.val));
        }

        if (root.left != null) {
            dfs(res,root.left,level + 1);
        }

        if (root.right != null) {
            dfs(res,root.right,level + 1);
        }



    }

}
