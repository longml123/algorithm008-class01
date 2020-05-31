package com.qunar.qboss.qer.common.lianxi.week06;

public class ClimbStairs {

//    dp：F（n） = F（n-1）+ F（n-2);
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
         int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n ; i++) {
            dp[i] = dp[i -1] + dp[i - 2];
        }
        return dp[n];
    }
}
