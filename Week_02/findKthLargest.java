package com.qunar.qboss.qer.common.lianxi;

public class findKthLargest {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 3;
        int kthLargest = findKthLargest(nums, k);
        System.out.println("第"+ k +"大元素值：" + kthLargest);
    }
    // 说人话的版本
    public static int findKthLargest(int[] nums, int k){
        // k是要求的第几大(从1开始计数),k-1即是数组中的序号(0开始计数)
        return findKthLargest(nums,0,nums.length-1,k-1);
    }
    public static int findKthLargest(int[] nums, int low, int high, int k){
        int index = partition(nums,low,high,k);
        if (index == k)
            return nums[index];
        else if (index>k)
            return findKthLargest(nums,low,index-1,k);
        else
            return findKthLargest(nums,index+1,high,k);
    }

    // 同快排的partation,每次确定一个枢轴的位置,并返回其index
    // 找第k 大 的数就把数组按大->小排列
    private static int partition(int[] nums, int low, int high, int k){
        int pivot = nums[low];

        while (low<high){
            while (low<high && nums[high]<=pivot) // nums[high]<=pivot 体现出把数组按大->小排列
                high--;
            nums[low] = nums[high];

            while (low< high && nums[low]>=pivot)
                low++;
            nums[high] = nums[low];
        }

        nums[low] = pivot;
        return low;
    }

}
