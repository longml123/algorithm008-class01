package com.qunar.qboss.qer.common.lianxi.week08;


/**
 *1122. 数组的相对排序
 *
 * 给你两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 * 示例：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *  
 * 提示：
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 */
public class RelativeSortArray {
    /**
     * 整体思路：先统计arr1中各个数字出现的次数，再按照arr2中存在的元素顺序将arr1中的元素都加入到结果数组中，最后再把arr1中独有的元素按照升序放到结果数组中。
     *
     * 第一次是用Map来做的，在处理arr1中独有元素时调用Arrays.sort()方法排序，耗时3ms超过41.24%；
     * 看高手题解发现，直接用数组就可以了，而且还省去了排序的过程，用时0ms超过100%（代码如下）。
     *
     * 用数组代替Set和Map可以极大的提高执行效率，今后遇到需要统计元素频次的题目先看元素取值范围。如果取值范围合适（10万以内）直接使用数组来做，既可以提高效率又可以避免很多额外的操作。
     */

    public static int[] relativeSortArray(int[] arr1,int[] arr2){
        //统计arr1元素出现次数，用数组下标存储值，value存储次数
        int[] countArr = new int[1001];
        for (int arr1Value : arr1) {
            countArr[arr1Value]++;
        }

        //把记忆数组中，arr2中出现的元素按arr2顺序存储到arr1中
        int pos = 0;
        for (int arr2Value : arr2) {
            while (countArr[arr2Value]-- > 0) {
                arr1[pos++] = arr2Value;
            }
        }

        //把arr1中没有元素安升序存储到arr1中
        for (int i = 0; i < 1001; i++) {
            while (countArr[i]-- > 0) {
                arr1[pos++] = i;
            }
        }
        return arr1;
    }
}
