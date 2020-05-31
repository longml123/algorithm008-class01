package com.qunar.qboss.qer.common.lianxi.week06;

public class MinPathSum {

    public int minPathSum(int[][] grid){
        int[] dp = new int[grid[0].length];
        int rows = grid.length -1;
        int colums = grid[0].length -1;
        for (int i = rows ; i >= 0; i--) {
            for (int j = colums; j >= 0; j--) {
                if (i != rows && j == colums) {
                    dp[j] = dp[j] + grid[i][j];
                }else if (i == rows && j != colums){
                    dp[j] = dp[j + 1] + grid[i][j];
                }else if (i != rows && j != colums){
                    dp[j] =  Math.min(dp[j],dp[j + 1]) + grid[i][j];
                }else if (i == rows && j == colums){
                    dp[j] = grid[i][j];
                }
            }
        }
        return dp[0];
    }
}
