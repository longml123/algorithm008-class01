package com.qunar.qboss.qer.common.lianxi;

import java.util.*;

public class LeastNumbers {
    //1、排序
    //2、小顶堆
    //3、快排
    public static void main(String[] args) {
        int[] arr = {3,2,1};
        int k = 2;
        int[] leastNumbers = getLeastNumbers04(arr, k);

        for (int i = 0; i < leastNumbers.length; i++) {
            System.out.println(leastNumbers[i]);
        }
    }

    public static int[] getLeastNumbers01(int[] arr, int k) {
        Arrays.sort(arr);
        int [] arrK = new int[k];
        for (int i = 0; i < k; i++) {
            arrK[i] = arr[i];
        }
        return arrK;
    }

    /**
     * // 保持堆的大小为K，然后遍历数组中的数字，遍历的时候做如下判断：
     * // 1. 若目前堆的大小小于K，将当前数字放入堆中。
     * // 2. 否则判断当前数字与大根堆堆顶元素的大小关系，如果当前数字比大根堆堆顶还大，这个数就直接跳过；
     * //    反之如果当前数字比大根堆堆顶小，先poll掉堆顶，再将该数字放入堆中。
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] getLeastNumbers02(int[] nums, int k) {
        if (nums.length == 0 || k ==0) {
            return new int[0];
        }

        Queue<Integer> maxHeap = new PriorityQueue<>((v1,v2) -> v2-v1);
        for (int num : nums) {
            if (maxHeap.size() < k){
                maxHeap.offer(num);
            }else if (num < maxHeap.peek()){
                maxHeap.poll();
                maxHeap.offer(num);
            }
        }

        int[] res = new int[k];
        int idx = 0;
        for (Integer integer : maxHeap) {
            res[idx++] = integer;
        }

        return res;
    }

    public static int[] getLeastNumbers03(int[] arr, int k) {
        if (arr.length == 0 || k == 0){
            return new int[0];
        }
        // 最后一个参数表示我们要找的是下标为k-1的数
        return  quickSearch(arr,0,arr.length - 1 ,k - 1);
    }

    private static int[] quickSearch(int[] arr, int low, int head, int k) {
        // 最后一个参数表示我们要找的是下标为k-1的数
        int index = partition(arr, low, head);

        if (index == k){
            return  Arrays.copyOf(arr,index + 1);
        }else if (index > k) {
            return quickSearch(arr,low, index - 1, k);
        }else {
            return quickSearch(arr,index + 1, head,k);
        }
    }
    // 快排切分，返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边。
    private static int partition(int[] arr, int low, int head) {
        int pivot = arr[low];
        int i = low;
        int j = head + 1;

        while (true){
            while (++i < head && arr[i] < pivot);
            while (--j > low && arr[j] > pivot);

            if (i >= j) {
                break;
            }

            int tmp = arr[j];
            arr[j] = arr[i];
            arr[i] = tmp;
        }
        arr[low] = arr[j];
        arr[j] = pivot;
        return j;
    }
    /*
    * BST 相对于前两种方法没那么常见，但是也很简单，和大根堆的思路差不多～
        要提的是，与前两种方法相比，BST 有一个好处是求得的前K大的数字是有序的。
        因为有重复的数字，所以用的是 TreeMap 而不是 TreeSet（有的语言的标准库自带 TreeMultiset，也是可以的）。

        TreeMap的key 是数字，value 是该数字的个数。
        我们遍历数组中的数字，维护一个数字总个数为 K 的 TreeMap：
        1.若目前 map 中数字个数小于 K，则将 map 中当前数字对应的个数 +1；
        2.否则，判断当前数字与 map 中最大的数字的大小关系：
        若当前数字大于等于 map 中的最大数字，就直接跳过该数字；
        若当前数字小于 map 中的最大数字，则将 map 中当前数字对应的个数 +1，
        并将 map 中最大数字对应的个数减 1。
    * */
    public static int[] getLeastNumbers04(int[] arr, int k) {
        if (arr.length == 0 || k == 0){
            return new int[0];
        }
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        int cnt = 0;
        for (int num : arr) {
            if (cnt < k){
                treeMap.put(num,treeMap.getOrDefault(num,0) + 1);
                cnt++;
                continue;
            }

            Map.Entry<Integer, Integer> lastEntry = treeMap.lastEntry();
            if (num < lastEntry.getKey()){
                treeMap.put(num,treeMap.getOrDefault(num,0) + 1);
                //最大值个数减1
                if (lastEntry.getValue() == 1){
                    treeMap.pollLastEntry();
                } else {
                    treeMap.put(lastEntry.getKey(),lastEntry.getValue() - 1);
                }
            }
        }
        // 最后返回map中的元素
        int[] res = new int[k];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            Integer count = entry.getValue();

            while (count-- > 0){
                res[idx++] = entry.getKey();
            }
        }
        return res;
    }

}
