package com.qunar.qboss.qer.common.lianxi.week04;

import java.util.Scanner;

public class MySqrt {
    public static void main(String[] args) {
        System.out.println("请输入要要求平方根整数：");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int coinCount = scanner.nextInt();
//            int sqrt = mySqrt(coinCount);
            int sqrt01 = mySqrt01(coinCount);
            System.out.println("开平方后的整数部分：" + sqrt01);

        }
    }

    /**
     * 二分查找
     * 由于 xx 平方根的整数部分ans 是满足 k^2≤x 的最大 k 值，
     * 因此我们可以对 k 进行二分查找，从而得到答案。
     *
     * 二分查找的下界为 0，上界可以粗略地设定为 x。
     * 在二分查找的每一步中，我们只需要比较中间元素 mid 的平方与 x 的大小关系，
     * 并通过比较的结果调整上下界的范围。由于我们所有的运算都是整数运算，
     * 不会存在误差，因此在得到最终的答案 ans 后，也就不需要再去尝试  1ans+1 了。
     *
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int left = 0;
        int right = x;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left)/2;
            if ((long)mid * mid <= x){
                ans = mid ;
                left = mid + 1;
            }else {
                right = mid -1;
            }
        }
        return ans;
    }

    /**
     * 牛顿迭代法
     * 使用牛顿法可以得到一个正实数的算术平方根，因为题目中说“结果只保留整数部分”，因此，我们把使用牛顿法得到的浮点数转换为整数即可。
     *
     * 这里给出牛顿法的思想：
     *
     * 在迭代过程中，以直线代替曲线，用一阶泰勒展式（即在当前点的切线）代替原曲线，求直线与 xx 轴的交点，重复这个过程直到收敛。
     *
     * @param x
     * @return
     */
    public static int mySqrt01(int a) {
        long x = a;
        while (x * x > a) {
            x = (x + x / a) / 2;
        }
        return (int)x;
    }
}
