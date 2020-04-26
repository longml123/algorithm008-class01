package com.qunar.qboss.qer.common.lianxi;

import java.util.PriorityQueue;
import java.util.Queue;

public class MaxSlidingWindow {

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] leastNumbers = maxSlidingWindow02(nums, k);
        for (int i = 0; i < leastNumbers.length; i++) {
            System.out.println(leastNumbers[i]);
        }
    }


    public static int[] maxSlidingWindow01(int[] nums, int k) {
        int n = nums.length;
        if (n == 0){
            return nums;
        }

        int[] result = new int[n - k + 1];
        for (int i = 0; i < result.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < k; j++) {
                max = Math.max(max,nums[i + j]);
            }
            result[i] = max;
        }
        return result;
    }

    public static int[] maxSlidingWindow02(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k ==0){
            return new int[0];
        }
        if (k == 1) return nums;

        //滑动窗口
        Queue<Integer> maxHeap = new PriorityQueue<>((v1,v2) -> v2 -v1);
        int[] result = new int[n - k + 1];

        int index = 0;
        for (int i = 0; i < nums.length ; i++) {
            //移除滑动窗口中第一个元素
            if (maxHeap.size() >= k){
                maxHeap.remove(nums[i - k]);
            }

            maxHeap.offer(nums[i]);

            //保存窗口最大元素
            if (i >= k -1){
                result[index++] = maxHeap.peek();
            }
        }
        return result;
    }

}
