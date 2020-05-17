package com.qunar.qboss.qer.common.lianxi.week04;

import java.util.Arrays;

public class FindContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0;
        int si = 0;
        while (gi < g.length && si < s.length) {
            if (g[gi] <= s[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }

    public int findContentChildren01(int[] g, int[] s) {
        int count = 0;
        if (g == null || s == null) {
            return count;
        }
        Arrays.sort(g);
        Arrays.sort(s);

        for (int i : s) {
            if (i >= g[count]){
                count++;
            }
            if (count >= g.length) {
                return count;
            }

        }
        return count;
    }
}
