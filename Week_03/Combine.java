package com.qunar.qboss.qer.common.lianxi.recursion;

import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
public class Combine {
    List<List<Integer>> output = new LinkedList();
    int n;
    int k;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backtrack(1, new LinkedList<Integer>());
        return output;
    }

    private  void backtrack(int first, LinkedList<Integer> curr) {
        // if the combination is done
        if (curr.size() == k) {
            output.add(new LinkedList(curr));
        }

        for (int i = first; i < n + 1; i++) {
            // add i into the current combination
            curr.add(i);
            // use next integers to complete the combination
            backtrack(i + 1, curr);
            // backtrack
            curr.removeLast();

        }
    }



}
