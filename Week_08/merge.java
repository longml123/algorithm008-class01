package com.qunar.qboss.qer.common.lianxi.week08;

import java.util.Arrays;

/**
 * 56. 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 */
public class merge {

    /**
     * 一、合并 2 个区间
     * 2 个区间的关系有以下 6 种，但是其实可以变成上面 3 种情况
     * （只需要假设 第一个区间的起始位置 \leq≤ 第二个区间的起始位置，如果不满足这个假设，
     * 交换这两个区间）。这 3 种情况的合并的逻辑都很好写。
     *
     * 二、合并 n 个区间
     * 先根据区间的起始位置排序，再进行 n -1n−1 次 两两合并。
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals){
        // 先按照区间起始位置排序
        Arrays.sort(intervals,(v1,v2) -> v1[0] -v2[0]);

        // 遍历区间
        int[][] result = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval : intervals) {
            // 如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置，
            // 则不合并，直接将当前区间加入结果数组。
            if (idx == -1 || interval[0] > result[idx][1]) {
                result[++idx] = interval;
            }else {
                // 反之将当前区间合并至结果数组的最后区间
                result[idx][1] = Math.max(result[idx][1],interval[1]);
            }
        }
        return Arrays.copyOf(result,idx + 1);
    }
}
