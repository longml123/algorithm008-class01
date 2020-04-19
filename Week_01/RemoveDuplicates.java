package com.qunar.qboss.qer.common.lianxi;

import java.util.Collections;
import java.util.Vector;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String arg = "0,1,1,2,0,4,5,0";
        String[] arrs = arg.split(",");
        Vector<Integer> nums = new Vector<Integer>();
        for(String arr : arrs){
            nums.add(Integer.parseInt(arr));
        }

        Collections.sort(nums);
        int len = removeDuplicates(nums);
        System.out.println("去重后数组长度;" + len);

        for (int num : nums) {
            System.out.println("去重后;" + num);
        }

    }

    private static int removeDuplicates(Vector nums) {
        if(nums.size() == 0 ) return 0;
        int j = 0 ;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(j) != nums.get(i)){
                j++;
                nums.set(j,nums.get(i));
            }
        }
        return j + 1;
    }
}
