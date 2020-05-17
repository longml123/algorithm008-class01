package com.qunar.qboss.qer.common.lianxi.week04;

public class BinarySearch {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return  mid;
            }

            //nums满足局部升序
            // 先根据 nums[mid] 与 nums[left] 的关系判断 左段还是右段有序
            if (nums[mid] >= nums[left]) {
                //左段有序
                // 再判断 target 是在 mid 的左边还是右边，从而调整左右边界 lo 和 hi
                if (target >= nums[left] && target <= nums[mid]) {
                    right = mid -1;
                }else {
                    left = mid + 1;
                }

            }else {
                //右段有序
                if (target >= nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                }else {
                    right = mid -1;
                }
            }
        }
        return -1;
    }

    /**
     * @param nums
     * @param target
     * @return
     */
    public int search01(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[0] > target ^ nums[0] > nums[mid] ^ target > nums[mid]) {
                //
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left == right && nums[left] == target ? left : -1;
    }
}
