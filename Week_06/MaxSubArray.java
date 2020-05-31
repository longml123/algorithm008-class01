package com.qunar.qboss.qer.common.lianxi.week06;

public class MaxSubArray {
    public int maxSubArray(int[] nums){
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            }else {
                sum = num;
            }
            ans = Math.max(ans,sum);
        }
        return ans;
    }


    public int maxSubArray01(int[] nums){
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i],nums[i]);
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }
}
