package com.qunar.qboss.qer.common.lianxi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        List<List<Integer>> lists = threeSum(nums);
       /* for (List<Integer> list : lists) {
            System.out.println("满足条件下标：【" + list.get(0)+ "，" + list.get(1) + "，" + list.get(2) + "]");
        }*/

        List<List<Integer>> lists01 = threeSum01(nums);
        for (List<Integer> list : lists01) {
            System.out.println("满足条件下标：【" + list.get(0)+ "，" + list.get(1) + "，" + list.get(2) + "]");

        }
    }

    private static List<List<Integer>> threeSum01(int[] nums) {
        List<List<Integer>> indexList  = new ArrayList<>();

        if(nums.length < 3){
            return indexList;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length -2 ; i++) {
            if( i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;//left
            int k = nums.length -1;//right
            while (j < k){
                int target = -nums[i];
                if(nums[j] + nums[k] == target ){
                    List<Integer> indexs = new ArrayList<>();
                    indexs.add(nums[i]);
                    indexs.add(nums[j]);
                    indexs.add(nums[k]);
                    indexList.add(indexs);

                    j++; k--;
                    while (j < nums.length && nums[j] == nums[j - 1]) j++;
                    while (k > j && nums[k] ==nums[k + 1]) k--;
                }else if (nums[j] + nums[k] > target) {
                    k--;
                }else {
                    j++;
                }
            }

        }

        return indexList;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> indexList  = new ArrayList<>();
        Arrays.sort(nums);

        int length = nums.length;
        for (int i = 0; i < length -2 ; i++) {
            for (int j = i + 1 ; j < length -1; j++) {
                for (int k = j + 1; k < length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0 ){
                        List<Integer> indexs = new ArrayList<>();
                        indexs.add(nums[i]);
                        indexs.add(nums[j]);
                        indexs.add(nums[k]);
                        if (indexList.indexOf(indexs) < 0)
                            indexList.add(indexs);
                    }
                }
            }
        }

        return indexList;
    }
}
