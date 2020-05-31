package com.qunar.qboss.qer.common.lianxi.week06;

public class CountSubStrings {
    public int countSubstrings(String s) {
        int ans = 0;
        int n = s.length();
        for (int center = 0; center < 2 * n - 1 ; center++) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }
}
