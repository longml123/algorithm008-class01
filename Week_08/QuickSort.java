package com.qunar.qboss.qer.common.lianxi.week08;

public class QuickSort {

    /**
     * 快速排序
     * @param array
     * @param begin
     * @param end
     */
    public static void quickSort(int[] array, int begin,int end){
        if (begin <= end) return;
        int pivot = partition(array,begin,end);
        quickSort(array,begin,pivot - 1);
        quickSort(array,pivot + 1,end);
    }

    private static int partition(int[] array, int begin, int end) {
        // pivot: 标杆位置，counter: 小于pivot的元素的个数
        int pivot = end;
        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[pivot]) {
                int temp = array[counter]; array[counter] = array[i];  array[i] = temp;
                counter++;
            }
        }
        int temp = array[pivot]; array[pivot] = array[counter];array[counter] = temp;
        return counter;
    }


    /**
     * 归并排序
     * @param array
     * @param left
     * @param right
     */
    public static void mergeSort(int[] array, int left,int right) {
        if (left <= right) return;
        int mid = (left + right) >> 1;

        mergeSort(array,left,mid);
        mergeSort(array,mid + 1,right);
        merge(array,left, mid, right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left; int j = mid + 1; int k = 0;
        while (i <= mid && j <= right) {
            temp[k++] = array[i] <= array[j] ? array[i++] : array[j++];
        }
        while (i <= left) temp[k++] = array[i++];
        while (j <= right) temp[k++] = array[j++];

        for (int p = 0; p < temp.length; p++) {
            array[left + p] = temp[p];
        }

    }

    /**
     * 堆排序
     * @param array
     */
    public static void heapSort(int[] array){
        if (array.length == 0) return;

        int length = array.length;
        for (int i = length / 2 - 1; i >= 0 ; i--) {
            heapify(array,length,i);
        }

        for (int i = length - 1; i >= 0 ; i--) {
            int temp = array[0]; array[0] = array[i]; array[i] = temp;
            heapify(array,i,0);
        }

    }

    /**
     * 堆化
     * 手动维护一个堆
     * @param array
     * @param length
     * @param i
     */
    private static void heapify(int[] array, int length, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < left && array[left] > array[largest]) {
            largest = left;
        }
        if (right < left && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = array[i]; array[i] = array[largest]; array[largest] = temp;
            heapify(array,length,largest);
        }
    }

    /**
     * 冒泡排序
     * @param array
     */
    public static void bubbleSort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len -1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                // 相邻元素两两对比
                if (array[j] > array[j + 1]){
                    //前者比后者大，进行交换
                    int temp = array[j];array[j] = array[j + 1];array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     * @param array
     */
    public static void selectionSort(int[] array) {
        int len = array.length;
        int minIndex;
        int temp;
        for (int i = 0; i < len - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < len; j++) {
                // 寻找最小的数
                if (array[j] < array[minIndex]){
                    // 将最小数的索引保存
                    minIndex = j;
                }
            }
            // 将最小数与当前位置元素交换
            temp = array[i]; array[i] = array[minIndex];array[minIndex] = temp;
        }
    }

    /**
     * 插入排序
     * @param array
     */
    public static void insertionSort(int[] array) {
        int len = array.length;
        //前一个元素suoyin
        int preIndex;
        //当前元素
        int current;

        for (int i = 1; i < len; i++) {
            preIndex = i - 1;
            current = array[i];
            //前一个元素大于当前元素且前一个元素下标不越界，
            //最终找到当前元素在有序数组中位置
            while (preIndex >= 0 && array[preIndex] > current){
                // 前一个元素向后移动一位，（直到没有大于为止），
                 array[preIndex + 1] = array[preIndex];
                 preIndex--;
            }
            //把当前元素放置到对应位置
            array[preIndex + 1] = current;
        }
    }
    
    public static void shellSort(int[] array) {
        int len = array.length;

        for (int gap = (int)Math.floor(len / 2); gap > 0 ; gap = (int)Math.floor(gap / 2)) {
            // 注意：这里和动图演示的不一样，动图是分组执行，实际操作是多个分组交替执行
            for (int i = gap; i < len; i++) {
                //用于寻找当前元素位置索引
                int j = i;
                //当前元素
                int current = array[i];
                //组内找当前元素位置
                while (j - gap >= 0 && array[j - gap] > current) {
                    array[j] = array[j - gap];
                    j = j - gap;
                }
                array[j] = current;
            }
            
        }
    }
}
