package com.qunar.qboss.qer.common.lianxi.week09;

import java.util.Arrays;

public class lengthOfLIS {

    public static int lengthOfLIS(int[] nums){
        int len = nums.length;
        if (len == 0) return 0;

        int[] dp = new int[len];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < len; i++) {
            int maxValue = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxValue = Math.max(maxValue,dp[j]);
                }
            }
            dp[i] = maxValue + 1;
            maxans = Math.max(maxans,dp[i]);
        }

        return maxans;
    }

    public static int lengthOfLIS01(int[] nums) {
        int len = nums.length;
        if (len <= 1) return len;

        int[] dp = new int[len];
        Arrays.fill(dp,1);

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
