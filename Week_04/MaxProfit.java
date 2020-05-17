package com.qunar.qboss.qer.common.lianxi.week04;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        if (prices == null) {
            return maxProfit;
        }
        for (int i = 1; i < prices.length; i++) {
            if (prices[i-1] < prices[i]) {
                maxProfit += prices[i] - prices[i-1];
            }
        }

        return maxProfit;
    }
}
