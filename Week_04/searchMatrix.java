package com.qunar.qboss.qer.common.lianxi.week04;

/**
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 */
public class searchMatrix {
    /**
     * 二分查找
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (row == 0 || col == 0) return false;

        int left = 0;
        int right = row * col - 1;
        int  pivotIdx;
        int  pivotElement;
        while (left <= right) {
            pivotIdx = left + (right - left) / 2;
            pivotElement = matrix[pivotIdx / col][pivotIdx % col];
            if (target == pivotElement) {
                return true;
            }else if (target < pivotElement) {
                right = pivotIdx - 1;
            }else {
                left = pivotIdx + 1;
            }
        }
        return false;
    }

    /**
     * 纯暴力
     * 遍历
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix01(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0 ) return false;
        for (int[] row : matrix) {
            for (int col : row) {
                if (col == target) return true;
            }
        }
        return false;
    }
}
