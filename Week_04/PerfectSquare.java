package com.qunar.qboss.qer.common.lianxi.week04;

public class PerfectSquare {
    public static void main(String[] args) {


    }

    public boolean isPerfectSquare(int num){
        if (num < 2) {
            return true;
        }

        long left = 2;
        long right = num / 2;
        long mid;
        long guessSquared;
        while (left <= right) {
            mid = left + (right - left) / 2;
            guessSquared = mid * mid;
            if (guessSquared == num) {
                return true;
            }else if (guessSquared < num) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static boolean isPerfectSquare01(int num) {
        if (num < 2) return true;

        long x = num;
        while (x * x > num) {
            x = (x + x / num) / 2;
        }
        return (x * x == num);
    }
}
