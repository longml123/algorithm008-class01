package com.qunar.qboss.qer.common.lianxi.week04;

public class FindMin {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];

        int left = 0;
        int right = nums.length - 1;
        if (nums[right] > nums[0]) return nums[0];

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) return nums[mid + 1];
            if (nums[mid] < nums[mid - 1]) return nums[mid];

            if (nums[mid] > nums[0]) {
                //左侧有序，变化点在mid右侧
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
