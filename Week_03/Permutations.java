package com.qunar.qboss.qer.common.lianxi.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
    List<List<Integer>> res = new LinkedList<>();

    public static void main(String[] args) {

    }

    /* 主函数，输入一组不重复的数字，返回它们的全排列 */
    List<List<Integer>> permute(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }
    // 路径：记录在 track 中
    // 选择列表：nums 中不存在于 track 的那些元素
    // 结束条件：nums 中的元素全都在 track 中出现
    public void backtrack(int[] nums, LinkedList<Integer> track) {
        if (nums.length == track.size()) {
            if(!res.contains(track)) {
                res.add(new ArrayList<>(track));
            }
        }

        for (int num : nums) {
            // 排除不合法的选择
            if (track.contains(num)) {
                continue;
            }
            // 做选择
            track.add(num);
            // 进入下一层决策树
            backtrack(nums,track);
            // 取消选择
            track.removeLast();

        }

    }

}
