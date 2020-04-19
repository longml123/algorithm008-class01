package com.qunar.qboss.qer.common.lianxi;

public class MaxArea {
    public static void main(String[] args) {
        int[] height ={1,8,6,2,5,4,8,3,7};
//        int maxArea = maxArea(height);

//        int maxArea01 = maxArea01(height);
        int maxArea02 = maxArea02(height);
        System.out.println("最大容量"+ maxArea02);
    }

    private static int maxArea02(int[] height) {
        int max = 0;
        for(int i = 0, j = height.length -1; i < j; ){
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            int area = (j - i + 1) * minHeight;
            max = Math.max(max, area);
        }
        return max;
    }

    /**
     * 时间复杂度O(n)
     * 左右边界 i，j
     * 向中间收敛，左右夹逼
     * @param height
     * @return
     */
    private static int maxArea01(int[] height) {
        int max = 0;
        int l = 0;
        int r = height.length -1;
         while (l < r){
             max = Math.max(max,(r - l) * Math.min(height[l],height[r]));
             if (height[l] <= height[r]){
                 l++;
             }else {
                 r--;
             }
         }
         return max;
    }

    public static int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length -1 ; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[j],height[i]);
                max = Math.max(max, area);
            }
        }
    return  max;
    }
}
