package com.qunar.qboss.qer.common.lianxi.week09;

public class NumDecodings {

    public static int numDecodings(String s) {
        int len = s.length();
        if (len == 0) return 0;

        // dp[i] 以 s[i] 结尾的前缀子串有多少种解码方法
        // dp[i] = dp[i - 1] * 1 if s[i] != '0'
        // dp[i] += dp
        // [i - 2] * 1 if  10 <= int(s[i - 1..i]) <= 26
        int[] dp = new int[len];
        dp[0] = 0;
        char[] sChars = s.toCharArray();
        if (sChars[0] == '0')  return 0;
        dp[0] = 1;

        for (int i = 1; i < len; i++) {
            if (sChars[i] != '0') dp[i] = dp[i - 1];

            int num = 10 * (sChars[i - 1] - '0') + (sChars[i] - '0');
            if (num >= 10 && num <= 26) {
                if (i == 1){
                    dp[i]++;
                }else{
                    dp[i] += dp[i -2];
                }
            }
        }
        return dp[len - 1];
    }


    public static int numDecodings01(String s) {
        int len = s.length();
        if (len == 0) return 0;

        // dp[i] 以 s[i] 结尾的前缀子串有多少种解码方法
        // dp[i] = dp[i - 1] * 1 if s[i] != '0'
        // dp[i] += dp
        // [i - 2] * 1 if  10 <= int(s[i - 1..i]) <= 26
        int[] dp = new int[len + 1];
        dp[0] = 1;
        char[] sChars = s.toCharArray();
        if (sChars[0] == '0')  return 0;
        dp[1] = 1;

        for (int i = 1; i < len; i++) {
            if (sChars[i] != '0') dp[i + 1] = dp[i];

            int num = 10 * (sChars[i - 1] - '0') + (sChars[i] - '0');
            if (num >= 10 && num <= 26) {
                dp[i + 1] += dp[i -1];
            }
        }
        return dp[len];
    }
}
