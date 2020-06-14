package com.qunar.qboss.qer.common.lianxi.week08;

public class hammingWeight {


    /**
     * 我们可以把前面的算法进行优化。我们不再检查数字的每一个位，
     * 而是不断把数字最后一个 1 反转，并把答案加一。当数字变成 00 的时候偶，
     * 我们就知道它没有 1 的位了，此时返回答案。
     *
     * 这里关键的想法是对于任意数字 n ，将 n 和 n - 1 做与运算，
     * 会把最后一个 1 的位变成 0 。为什么？考虑 n 和 n - 1 的二进制表示。
     *
     *在二进制表示中，数字 n 中最低位的 1 总是对应 n - 1 中的 0 。
     * 因此，将 n 和 n - 1 与运算总是能把 n 中最低位的 1 变成 0，并保持其他位不变。
     *
     * 使用这个小技巧，代码变得非常简单。
     *
     * @param n
     * @return
     */
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            count++;
            n = (n & (n - 1));
        }
        return count;
    }

    /**
     *循环和位移动
     *
     * 这个方法比较直接。我们遍历数字的 32 位。如果某一位是 11 ，将计数器加一。
     *
     * 我们使用 位掩码 来检查数字的第 i^{th}位。一开始，掩码 m=1m=1 因为 11 的二进制表示是
     * 0000 0000 0000 0000 0000 0000 0000 0001
     *
     * 显然，任何数字跟掩码 11 进行逻辑与运算，
     * 都可以让我们获得这个数字的最低位。检查下一位时，我们将掩码左移一位。
     * 0000 0000 0000 0000 0000 0000 0000 0010
     *
     * 并重复此过程。
     *
     * @param n
     * @return
     */
    public int hammingWeight01(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }
}
