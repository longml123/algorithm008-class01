package com.qunar.qboss.qer.common.lianxi;

import java.util.HashMap;
import java.util.Map;

/**
 * 暴力求解
 * 双重for循环
 *
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 11, 7, 15};
        int target = 9;
        int[] ints = twoSum01(nums, target);

        int[] ints02 = twoSum02(nums, target);

        int[] ints03 = twoSum03(nums, target);
        for (int i = 0; i < ints03.length; i++) {
            System.out.println(i + "元素角标：" + ints03[i] );
        }

    }

    private static int[] twoSum03(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if(map.containsKey(tmp)){
                return new  int[]{map.get(tmp),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    private static int[] twoSum01(int[] nums,int target) {
        int[] index = new int[2];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = (i+1); j < len; j++) {
                if(nums[i] + nums[j] == target){
                    index[0] = i;
                    index[1] = j;
                    return index;
                }
            }
        }
        return index;
    }


    //快慢指针
    private static int[] twoSum02(int[] nums, int target) {
        int[] index = new int[2];
        int length = nums.length;
        int i = 0;
        int j = 1;

        while (i != length){
            //快指针到最后，慢指针加1，快指针是慢指针加1，开始新一轮；
            if (j == length){
                i++;
                j = i + 1;
                continue;
            }

            //达成目标结束
            if (nums[i] + nums[j] == target){
                index[0] = i;
                index[1] = j;
                return index;
            }
            j++;
        }

        return index;
    }




}
