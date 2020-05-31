package com.qunar.qboss.qer.common.lianxi.week06;

import java.util.List;

public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        // 加1可以不用初始化最后一行
        // 根据题意，行列值相同
        int[][] dp = new int[triangle.size() + 1][triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> rows = triangle.get(i);
            for (int j = 0; j < rows.size(); j++) {
                dp[i][j] = Math.min(dp[i + 1][j],dp[i + 1][j + 1]) + rows.get(j);
            }

        }
        return dp[0][0];
    }

    public int minimumTotal01(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        // dp中记录了求第i行时，第i+1的最小路径和
        int[] dp = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> rows = triangle.get(i);
            for (int j = 0; j < rows.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + rows.get(j);
            }
        }
        return dp[0];
    }

    public int minimumTotal02(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int row = triangle.size();
        int column = triangle.get(row - 1).size();
        int[][] dp = new int[row][column];

        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < row; i++) {
            for (int j = 0; j <= i ; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                }else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                }else {
                    dp[i][j] = Math.min(dp[i - 1][j],dp[i - 1][j - 1]) + triangle.get(i).get(j);
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < column; i++) {
            res = Math.min(res,dp[row - 1] [i]);
        }
        return res;
    }
}
