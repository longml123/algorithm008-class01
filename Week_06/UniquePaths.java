package com.qunar.qboss.qer.common.lianxi.week06;

import java.util.Arrays;

public class UniquePaths {
    /**
     * 动态规划
     *
     * 我们令 dp[i][j] 是到达 i, j 最多路径
     *
     * 动态方程：dp[i][j] = dp[i-1][j] + dp[i][j-1]
     *
     * 注意，对于第一行 dp[0][j]，或者第一列 dp[i][0]，由于都是在边界，所以只能为 1
     *
     * 时间复杂度：O(m*n)O(m∗n)
     *
     * 空间复杂度：O(m * n)O(m∗n)
     *
     * 优化：因为我们每次只需要 dp[i-1][j],dp[i][j-1]
     *
     * 所以我们只要记录这两个数，直接看代码吧！
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths00(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n ; i++) dp[0][i] = 1;
        for (int i = 0; i < m ; i++) dp[i][0] = 1;
        for (int i = 1; i < m ; i++){
            for (int j = 1; j < n ; j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    /**
     * 优化1
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths01(int m, int n) {
        int[] pre = new int[n];
        int[] cur = new int[n];
        Arrays.fill(pre,1);
        Arrays.fill(cur,1);
        for (int i = 1; i < m ; i++){
            for (int j = 1; j < n ; j++){
                //当前值= 当前值上一个位置值 + 之前值
                cur[j] = cur[j - 1] + pre[j];
            }
            pre = cur.clone();
        }
        return pre[n - 1];
    }

    public int uniquePaths02(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur,1);
        for (int i = 1; i < m ; i++){
            for (int j = 1; j < n ; j++){
                //当前值= 当前值上一个位置值 + 之前值
                cur[j] += cur[j - 1];
            }
        }
        return cur[n - 1];
    }
    public static int uniquePaths03(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }

        if (m == 1 || n == 1) {
            return 1;
        }
        if (m == 2 && n == 2) {
            return 2;
        }
        int a = uniquePaths03(m - 1, n);
        int b = uniquePaths03(m, n - 1);
        return a + b;
    }

    public static int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }

        int[][] a = new int[n][m];
        a[0][0] = 0;
        a[0][1] = 1;
        a[1][0] = 1;
        a[1][1] = 2;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (i <= 1 && j <= 1) {
                    continue;
                }
                if (i == 0) {
                    a[i][j] = a[i][j-1];
                } else if (j == 0){
                    a[i][j] = a[i - 1][j];
                } else {
                    a[i][j] = a[i][j - 1] + a[i - 1][j];
                }
            }
        }
        return a[n - 1][m - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths03(7, 3));
    }

}
