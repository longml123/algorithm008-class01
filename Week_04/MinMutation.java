package com.qunar.qboss.qer.common.lianxi.week04;

import java.util.Arrays;
import java.util.HashSet;

public class MinMutation {
    public static void main(String[] args) {

    }

    /**
     * 自己写的失败想法
     * 暴力：遍历
     * @param start
     * @param end
     * @param bank
     * @return
     */
    public int minMutation(String start, String end, String[] bank) {
        if (start == null || end == null || bank == null ) {
            return -1;
        }

        char[] startArr = start.toCharArray();
        char[] endArr = end.toCharArray();
        int count = 0;
        for (int i = 0; i < startArr.length; i++) {
            if (startArr[i] != endArr[i]) {
                startArr[i] = endArr[i];
                if (Arrays.binarySearch(bank,startArr.toString()) == -1) {
                   return  -1;
                }else {
                    count++;
                }
            }

        }

        return count;
    }

    int minStepCount = Integer.MAX_VALUE;
    public int minMutation01(String start, String end, String[] bank) {
        dfs(new HashSet<String>(), 0, start, end, bank);
        return (minStepCount == Integer.MAX_VALUE) ? -1 : minStepCount;
    }

    private void dfs (HashSet<String> step, int stepCount,
                     String current, String end, String[] bank) {
        if (current.equals(end)) {
            minStepCount = Math.min(stepCount,minStepCount);
        }

        for (String s : bank) {
            int diff = 0;
            for (int i = 0; i < s.length() ; i++) {
                if (current.charAt(i) != s.charAt(i)) {
                    if (++diff > 1) {
                        break;
                    }
                }
            }

            if (diff == 1 && !step.contains(s)) {
                step.add(s);
                dfs(step,stepCount + 1 ,s,end,bank);
                step.remove(s);
            }
        }

    }




}
