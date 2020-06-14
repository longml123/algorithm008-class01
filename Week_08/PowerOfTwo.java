package com.qunar.qboss.qer.common.lianxi.week08;

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }

    public boolean isPowerOfTwo01(int n) {
        return n > 0 && (n & (n-1)) == 0;
    }
}
