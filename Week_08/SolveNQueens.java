package com.qunar.qboss.qer.common.lianxi.week08;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SolveNQueens {
    int n;
    int[] rows;
    int[] hills;
    int[] dales;
    int[] queens;
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        rows = new int[n];
        hills = new int[4 * n - 1];
        dales = new int[2 * n - 1];
        queens = new int[n];
        //回溯启动
        backtrack(0);
        return result;
    }

    /**递归-回溯法
     * 放置皇后位置
     * @param row
     */
    private void backtrack(int row) {
        if (row >= n) return;
        for (int col = 0; col < n; col++) {
            if (isNotUnderAttack(col, col)) {
                //皇后不受攻击
                //2、放置皇后以及添加攻击位置
                placeQueen(row, col);

                if (row  == n - 1) {
                    //1、递归终止条件，达到最大层，添加结果到结果集中
                    addSolution();
                }
                //3、进入下一层
                backtrack(row + 1);


                //4、清理本层参数（回溯），去掉当前层皇后以及攻击位置
                removeQueen(row, col);
            }
        }
    }

    /**
     * 判断是否收到攻击
     * @param row
     * @param col
     * @return
     */
    private boolean isNotUnderAttack(int row, int col) {
        int res = rows[col] + hills[row - col + 2 * n] + dales[row + col];
        return (res == 0) ? true : false;
    }

    /**
     * 添加皇后
     * @param row
     * @param col
     */
    private void placeQueen(int row, int col) {
        queens[row] = col;
        rows[col] = 1;
        // "hill" diagonals
        hills[row - col + 2 * n] = 1;
        //"dale" diagonals
        dales[row + col] = 1;
    }

    /**
     * 移除皇后
     * @param row
     * @param col
     */
    private void removeQueen(int row, int col) {
        queens[row] = 0;
        rows[col] = 0;
        hills[row - col + 2 * n] = 0;
        dales[row + col] = 0;
    }

    /**
     * 添加解决方案
     */
    private void addSolution() {
        List<String> solution = new ArrayList<>();
        for (int row = 0; row < n; row++) {
            int col = queens[row];
            StringBuilder sb = new StringBuilder();
        /*for (int solutionCol = 0; solutionCol < n; solutionCol++) {
            if (col == solutionCol){
                sb.append("Q");
                continue;
            }
            sb.append(".");
        }*/
            for(int j = 0; j < col; ++j) {
                sb.append(".");
            }
            sb.append("Q");
            for(int j = 0; j < n - col - 1; ++j) {
                sb.append(".");
            }
            solution.add(sb.toString());
        }
        result.add(solution);
    }

}


