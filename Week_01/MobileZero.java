package com.qunar.qboss.qer.common.lianxi;

public class MobileZero {
    public static void main(String[] args) {
         int[] arr = {0,1,2,0,4,5,0};

//        moveZero(arr);
        moveZeros01(arr);

        //打印
        for (int i : arr) {
            System.out.println("移动后顺序"+ i);
        }

    }

    private static void moveZeros01(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                j++;
            }

        }
    }

    private static void moveZero(int[] arr) {
        int j = 0;//不为0元素下标
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 0){
                arr[j] = arr[i];
                if(j != i){
                    arr[i] = 0;
                }
                j ++;
            }
        }
    }


}
